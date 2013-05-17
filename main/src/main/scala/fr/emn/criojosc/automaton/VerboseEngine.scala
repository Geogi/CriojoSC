/*
 * Copyright (c) 2013 Mines Nantes.
 *
 * This file is part of CriojoSC.
 *
 * CriojoSC is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CriojoSC is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CriojoSC.  If not, see <http://www.gnu.org/licenses/>.
 */

package fr.emn.criojosc.automaton

import fr.emn.criojosc.model.{ControlGuard, Agent}

class VerboseEngine(thisAgents: List[Agent]) extends fr.emn.criojosc.automaton.Engine(thisAgents) {
  var MAX_ITS: Option[Int] = None

  override def run() {
    println("### Startup")
    println()
    agents.foreach { a =>
      println("#### Agent " + a)
      println()
      println("**Initial solution:** " + a.solution.content.mkString(", "))
      println()
      println("**Rules:**")
      println()
      a.rules.foreach(r => println("* **" + r + ":** " + r.printed))
      println()
    }
    verboseRun(0)
  }

  private def verboseRun(i: Int) {
    println("### Step " + i)
    println()
    println("#### Unprocessed reactants")
    println()
    val hasUnprocessed = agents.groupBy(unprocessed(_).nonEmpty)
    hasUnprocessed.get(false).foreach(as => println("**None:** " + as.mkString(", ")))
    hasUnprocessed.get(true).foreach(_.foreach(a => println("* **" + a + ":** " +
      unprocessed(a).mkString(", "))))
    println()
    println("#### Automaton states")
    println()
    val allInitial = agents.groupBy(automatons(_).forall(a => a.states.forall { case (s, pes) =>
      if (s == a.initialState) pes == Set(PartialExecution())
      else pes.isEmpty}))
    allInitial.get(true).foreach(as => println("**All in initial state:** " + as.mkString(", ")))
    println()
    allInitial.get(false).foreach(_.foreach { case agent =>
      println("##### Agent " + agent)
      println()
      val initialAutomatons = automatons(agent).groupBy(a => a.states.forall { case (s, pes) =>
        if (s == a.initialState) pes == Set(PartialExecution())
        else pes.isEmpty})
      initialAutomatons.get(true).foreach { as =>
        println("**Initial state:**")
        println()
        as.foreach(a => println("* " + a.rule))
        println()
      }
      initialAutomatons.get(false).foreach(_.foreach { a =>
        println("###### Rule " + a.rule)
        println()
        println(a.rule.premise.reactants.mkString("| ", " | ", " |"))
        println(a.rule.premise.reactants.map(or => "-" * (or.toString.length - 2)).mkString("| :", " :|: ", ": |"))
        a.states.filter { case (s, pes) => s != a.initialState && pes.nonEmpty }.foreach { case (s, pes) =>
          println(a.rule.premise.reactants.map { or =>
            if (s.has(or)) " " * math.floor((or.toString.length - 7) / 2.0).toInt + "***X***" + " " * math.ceil((or.toString.length - 7) / 2.0).toInt
            else " " * or.toString.length
          }.mkString("| ", " | ", " |"))
          pes.foreach(pe => println("| " + pe + " " + "|" * a.rule.premise.reactants.size))
        }
        println()
      })
    })
    if(step() && MAX_ITS.map(i < _).getOrElse(true)) verboseRun(i + 1)
    else {
      if (MAX_ITS.map(i < _).getOrElse(true)) println("### Equilibrium reached")
      else {
        println("### Stopped")
        println()
        println("Maximum iteration reached: " + i)
      }
    }
  }

  override def step() = {
    println("#### Processing")
    agents.map(agent => {
      // proposes closed atoms
      automatons(agent).foreach(a => unprocessed(agent).foreach(a.propose(_)))
      // get completed executions (filter guards) whose guards are verified
      val complete = automatons(agent).flatMap(_.getCompleted).filter {
        case (automaton, pe) => !automaton.rule.isInstanceOf[ControlGuard] && evaluateGuard(automaton.rule.guard, pe.valuation)
      }
      println("**Completed rules:**" + complete.headOption.map(_=>"").getOrElse(" None"))
      println()
      if (complete.nonEmpty) {
        complete.foreach { case (automaton, pe) => println("* **" + automaton.rule + ":** " + pe) }
        println()
      }
      // clears the unprocessed reactants list
      unprocessed(agent).clear()
      // takes the first choice, if any
      val chosen = complete.headOption
      println("**Chosen:** " + chosen.map { case (automaton, pe) => automaton.rule + " *with* " + pe }.getOrElse("None"))
      println()
      // if defined, applies the valuation to the conclusion of the rule
      // and adds the products to the unprocessed reactant list
      val products = chosen.map { case (a, pe) => a.execute(pe) }
      println("**Products:** " + products.map(_.mkString(" & ")).getOrElse("None"))
      println()
      products.map(unprocessed(agent) ++= _)
      // if defined, destroys the PEs that use the same CRs
      chosen.foreach { case (a, pe) => automatons(agent).foreach(_.purge(pe.using)) }
      // returns true if defined
      chosen.isDefined
    }).contains(true)
  }
}

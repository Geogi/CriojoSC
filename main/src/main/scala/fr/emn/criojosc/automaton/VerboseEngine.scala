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

import fr.emn.criojosc._

import collection.mutable

class VerboseEngine(thisAgents: List[Agent]) extends fr.emn.criojosc.automaton.Engine(thisAgents) {
  var MAX_ITS: Option[Int] = None

  override def run() {
    println("### Startup")
    agents.foreach { a =>
      println("#### Agent " + a)
      println("**Initial solution:** " + a.solution.content.mkString(", "))
      println()
      println("**Rules:**")
      println()
      a.rules.foreach(r => println("* " + r.premise))
    }
    println()
    verboseRun(0)
  }

  private def verboseRun(i: Int) {
    println("### Step " + i)
    println("#### Unprocessed reactants")
    val hasUnprocessed = agents.groupBy(unprocessed(_).nonEmpty)
    hasUnprocessed.get(false).foreach(as => println("**None:** " + as.mkString(", ")))
    hasUnprocessed.get(true).foreach(_.foreach(a => println("* **" + a + ":** " +
      unprocessed(a).mkString(", "))))
    println()
    println("#### Automaton states")
    val allInitial = agents.groupBy(automatons(_).forall(a => a.states.forall { case (s, pes) =>
      if (s == a.initialState) pes == Set(PartialExecution())
      else pes.isEmpty}))
    allInitial.get(true).foreach(as => println("**All in initial state:** " + as.mkString(", ")))
    allInitial.get(false).foreach(_.foreach { case agent =>
      println("##### Agent " + agent)
      val initialAutomatons = automatons(agent).groupBy(a => a.states.forall { case (s, pes) =>
        if (s == a.initialState) pes == Set(PartialExecution())
        else pes.isEmpty})
      initialAutomatons.get(true).foreach(as => println("**Initial state:**" + as.mkString("\n")))
      initialAutomatons.get(false).foreach(_.foreach { a =>
        println("###### Rule " + a.rule.premise)
        println()
        println(a.rule.premise.reactants.mkString("| ", " | ", " |"))
        println(a.rule.premise.reactants.map(or => "-" * (or.toString.length - 2)).mkString("| :", " :|: ", ": |"))
        a.states.filter(_._2.nonEmpty).foreach { case (s, pes) =>
          println(a.rule.premise.reactants.map { or =>
            if (s.has(or)) " " * math.floor((or.toString.length - 1) / 2.0).toInt + "X" + " " * math.ceil((or.toString.length - 1) / 2.0).toInt
            else " " * or.toString.length
          }.mkString("| ", " | ", " |"))
          pes.foreach(pe => println("| " + pe + " " + "|" * a.rule.premise.reactants.size))
        }
        println()
      })
    })
    if(step() && MAX_ITS.map(i < _).getOrElse(true)) verboseRun(i + 1)
    else
      if (MAX_ITS.map(i < _).getOrElse(true)) println("### Equilibrium reached")
      else println("### Maximum iteration reached: " + i)
  }
}

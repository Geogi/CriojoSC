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
  private val agentNames = agents.zipWithIndex.toMap.mapValues(i => "A" + (i + 1))
  private val entitiesNames = mutable.Map.empty[EntitySymbol, String]

  private def crs(es: ClosedReactant) = {
    if (!entitiesNames.contains(es.symbol)) entitiesNames += es.symbol -> ("R" + (entitiesNames.size + 1))
    entitiesNames(es.symbol) + "(" + es.value.toString + ")"
  }

  private def ors(es: OpenReactant) = {
    if (!entitiesNames.contains(es.symbol)) entitiesNames += es.symbol -> ("R" + (entitiesNames.size + 1))
    entitiesNames(es.symbol) + "?(" + es.pattern.toString + ")"
  }
  private def premise_s(p: Premise) = p.reactants.map(ors).mkString(" & ")

  override def run() {
    println("### Startup")
    agents.foreach { a =>
      println("#### Agent " + agentNames(a))
      println("**Initial solution:** " + a.solution.content.map(crs).mkString(", "))
      println()
      println("**Rules:**")
      println()
      a.rules.foreach(r => println("* " + premise_s(r.premise)))
    }
    println()
    verboseRun(0)
  }

  private def verboseRun(i: Int) {
    println("### Step " + i)
    println("#### Unprocessed reactants")
    val hasUnprocessed = agents.groupBy(unprocessed(_).nonEmpty)
    hasUnprocessed.get(false).foreach(as => println("**None:** " + as.map(agentNames(_)).mkString(", ")))
    hasUnprocessed.get(true).foreach(_.foreach(a => println("* **" + agentNames(a) + ":** " +
      unprocessed(a).map(crs).mkString(", "))))
    println()
    println("#### Automaton states")
    val allInitial = agents.groupBy(automatons(_).forall(a => a.states.forall { case (s, pes) =>
      if (s == a.initialState) pes == Set(PartialExecution())
      else pes.isEmpty}))
    allInitial.get(true).foreach(as => println("**All in initial state:** " + as.map(agentNames(_)).mkString(", ")))
    allInitial.get(false).foreach(_.foreach { case agent =>
      println("##### Agent " + agentNames(agent))
      val initialAutomatons = automatons(agent).groupBy(a => a.states.forall { case (s, pes) =>
        if (s == a.initialState) pes == Set(PartialExecution())
        else pes.isEmpty})
      initialAutomatons.get(true).foreach(as => println("**Initial state:**" + as.map(a => premise_s(a.rule.premise)).mkString("\n")))
      initialAutomatons.get(false).foreach(_.foreach { a =>
        println("###### Rule " + premise_s(a.rule.premise))
        println(a.rule.premise.reactants.mkString(" | "))
        println(a.rule.premise.reactants.map(or => "-" * or.toString.length).mkString(" | "))
        a.states.filter(_._2.nonEmpty).foreach { case (s, pes) =>
          println(a.rule.premise.reactants.map { or =>
            if (s.has(or)) " " * math.floor((or.toString.length - 1) / 2.0).toInt + "X" + " " * math.ceil((or.toString.length - 1) / 2.0).toInt
            else " " * or.toString.length
          }.mkString(" | "))
          pes.foreach(pe => println(" " + pe + " " + "|" * (a.rule.premise.reactants.size - 1)))
        }
        println()
      })
    })
    if(step()) verboseRun(i + 1)
    else println("### Equilibrium reached")
  }
}

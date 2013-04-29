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

import fr.emn.criojosc.{ClosedReactant, EntitySymbol, Agent}

import collection.mutable

class VerboseEngine(thisAgents: List[Agent]) extends Engine(thisAgents) {
  private val agentNames = agents.zipWithIndex.toMap.mapValues(i => "A" + (i + 1))
  private val entitiesNames = mutable.Map.empty[EntitySymbol, String]

  private def crs(es: ClosedReactant) = {
    if (!entitiesNames.contains(es.symbol)) entitiesNames += es.symbol -> ("R" + (entitiesNames.size + 1))
    entitiesNames(es.symbol) + "(" + es.value.toString + ")"
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
      initialAutomatons.get(true).foreach(as => println("**Initial state:**" + as.map(_.rule.premise).mkString("\n")))
      initialAutomatons.get(false).foreach(_.foreach { a =>
        println("###### Rule " + a.rule.premise)
        val emptyStates = a.states.groupBy(_._2.isEmpty)
        emptyStates.get(true).foreach(ss => println("**Empty states:** " + ss.map(_._1).mkString(", ") + "\n"))
        emptyStates.get(false).foreach(_.foreach { case (s, pes) =>
          println("* " + s + ":")
          pes.foreach(pe => println("    * " + pe))
        })
        println()
      })
    })
    if(step()) verboseRun(i + 1)
    else println("### Equilibrium reached")
  }

  override def run() {
    println("### Startup")
    agents.foreach { a =>
      println("#### Agent " + agentNames(a))
      println("**Initial solution:** " + a.solution)
      println()
      println("**Rules:**")
      a.rules.foreach(r => println("* " + r.premise))
    }
    verboseRun(0)
  }
}

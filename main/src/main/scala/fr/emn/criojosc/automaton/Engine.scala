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

package fr.emn.criojosc
package automaton

import collection.mutable

class Engine(val agents: List[Agent]) extends fr.emn.criojosc.Engine {
  private val automatons = agents.map(a => a -> a.rules.map(r => new Automaton(r))).toMap
  private val unprocessed = agents.map(a => a -> a.solution.content.to[mutable.ListBuffer]).toMap

  def run() {
    if (step()) run()
    else println("Equilibrium reached.")
  }

  private def step(): Boolean = {
    agents.map(agent => {
      // proposes closed atoms, get completed executions
      val complete = automatons(agent).flatMap(a => unprocessed(agent).flatMap(a.propose(_)))
      // clears the unprocessed reactants list
      unprocessed(agent).clear()
      // chooses one execution (dummy: first)
      val chosen = complete.headOption
      // if defined, applies the valuation to the conclusion of the rule
      val products = chosen.map { case (a, pe) => a.execute(pe) }
      // if defined, destroys the PEs that use the same CRs
      products.foreach (op => automatons(agent).foreach(_.purge(op)))
      // returns true if defined
      chosen.isDefined
    }).contains(true)
  }
}

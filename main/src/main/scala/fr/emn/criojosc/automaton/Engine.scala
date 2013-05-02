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
  protected val automatons = agents.map(a => a -> a.rules.flatMap(recurAuto(_)())).toMap
  protected val unprocessed = agents.map(a => a -> a.solution.content.to[mutable.ListBuffer]).toMap

  private def recurAuto(parent: Rule)(guards: List[Guard] = List(parent.guard),
                                      children: List[Automaton] = Nil): List[Automaton] = guards match {
    case x :: xs => x match {
      case AndGuard(left, right) => recurAuto(parent)(left :: right :: xs, children)
      case NotGuard(guard) => recurAuto(parent)(guard :: xs, children)
      case NativeGuard(test) => recurAuto(parent)(xs, children)
      case guard: ControlGuard =>
        val subAutos = recurAuto(guard)()
        subAutos ::: recurAuto(parent)(xs, subAutos ::: children)
    }
    case _ => List(new Automaton(parent, children))
  }

  def run() {
    if (step()) run()
  }

  protected def step(): Boolean = {
    agents.map(agent => {
      // proposes closed atoms, get completed executions
      val complete = automatons(agent).flatMap(a => unprocessed(agent).flatMap(a.propose(_)))
      // clears the unprocessed reactants list
      unprocessed(agent).clear()
      // chooses one execution (dummy: first)
      val chosen = complete.headOption
      // if defined, applies the valuation to the conclusion of the rule
      // and adds the products to the unprocessed reactant list
      chosen.map { case (a, pe) => a.execute(pe) }.map(unprocessed(agent) ++= _)
      // if defined, destroys the PEs that use the same CRs
      chosen.foreach { case (a, pe) => automatons(agent).foreach(_.purge(pe.using)) }
      // returns true if defined
      chosen.isDefined
    }).contains(true)
  }
}

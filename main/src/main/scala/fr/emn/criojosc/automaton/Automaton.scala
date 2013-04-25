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

class Automaton(premise: Premise) {
  private def gen_states(ors: List[OpenReactant] = premise.reactants.toList): List[State] = ors match {
    case x :: xs => gen_states(xs).flatMap(s => List(s + x, s - x))
    case _ => List(State(Map.empty[OpenReactant, Boolean]))
  }
  val states: Map[State, mutable.Set[PartialExecution]] =
    gen_states().map((_, mutable.Set.empty[PartialExecution])).toMap

  private val initialState = State(premise.reactants.toList.map((_, false)).toMap)
  private val finalState = State(premise.reactants.toList.map((_, true)).toMap)
  states(initialState) += PartialExecution()

  private val ancestors = new mutable.HashMap[ClosedReactant, mutable.Set[PartialExecution]]
    with mutable.MultiMap[ClosedReactant, PartialExecution]

  def propose(cr: ClosedReactant) = {
    val new_states = states.flatMap { case (state, pes) =>
      state.has.flatMap {
        case (or, present) if !present && cr.symbol == or.symbol =>
          pes.map {
            pe => (or.matching(cr, pe.valuation), pe)
          }.map {
            case ((matched, valuation), pe) if matched =>
              val newExec = PartialExecution(valuation, Some(pe), cr)
              ancestors.addBinding(cr, newExec)
              ((state + or), newExec)
          }
      }
    }
    new_states.foreach {
      case (k, v) => states(k) += v
    }
    states(finalState)
  }
}

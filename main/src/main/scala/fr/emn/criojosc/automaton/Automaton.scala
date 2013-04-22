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
  private val index = premise.reactants.toList
  val states = new mutable.HashMap[State, mutable.Set[Valuation]] with mutable.MultiMap[State, Valuation]

  private val bottomValuation = new Valuation
  private val initialState = State(Array.fill(index.size)(false))
  states.addBinding(initialState) = bottomValuation

  def update(state: State, valuation: Valuation) { states.addBinding(state, valuation) }
  def remove(state: State, valuation: Valuation) { states.removeBinding(state, valuation) }
  def removeAll(state: State) { states.remove(state) }
  def apply(state: State) = states(state)
  def contains(state: State, valuation: Valuation) = states.entryExists(state, _ == valuation)
}

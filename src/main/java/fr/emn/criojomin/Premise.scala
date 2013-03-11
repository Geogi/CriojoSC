/*
 * Copyright (c) 2013 Paul Blouët.
 *
 * This file is part of criojo-min.
 *
 * criojo-min is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * criojo-min is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with criojo-min.  If not, see <http://www.gnu.org/licenses/>.
 */

package fr.emn.criojomin

import collection.mutable

class Premise(val reactants: List[Term]) {

  class State(val s: Valuation, val left: List[Term], val right: List[Instance]) {
    val end = left.size == 0

    def propose(instance: Instance): List[State] = {
      // take a term with the same symbol as `instance` --
      (left filter (_.symbol == instance.symbol)
        // -- retrieve all permutations of its patterns --
        // (so that the valuation can be applied disregarding the pattern order)
        map (_.patterns) map (_.permutations)
        // -- do the pattern matching --
        )
    }
  }

  object State {
    def initial = new State(new Valuation, reactants, List.empty[Instance])
  }

  val states = mutable.HashSet[State](State.initial)

  def addInstance(instance: Instance): List[Valuation] = {
    states ++= states flatMap (_.propose(instance))
    states filter (_.end) map (_.s) toList
  }

  def removeInstance(instance: Instance) {
    states --= states filter (_.right contains instance)
  }
}

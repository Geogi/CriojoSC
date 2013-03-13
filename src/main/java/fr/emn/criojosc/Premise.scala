/*
 * Copyright (c) 2013 Paul Blouët.
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

import collection.mutable

class Premise(val reactants: List[OpenReactant]) {

  def initial_state = new State(new Valuation, reactants, List.empty[ClosedReactant])

  val states = mutable.HashSet[State](initial_state)

  def +=(reactant: ClosedReactant): Iterable[State] = {
    states ++= states flatMap (_.propose(reactant))
    states filter (_.end)
  }

  def -=(reactant: ClosedReactant) {
    states --= states filter (_.right contains reactant)
  }
}

class State(val s: Valuation, val left: List[OpenReactant], val right: List[ClosedReactant]) {
  val end = left.size == 0

  def propose(instance: ClosedReactant): Iterable[State] = {
    // This is the set of new states that will be returned.
    val new_states = mutable.HashSet.empty[State]

    // We filter the terms which symbol is not the same as `instance`.
    val same_symbol: List[OpenReactant] = left filter (_.symbol == instance.symbol)

    // We create the following object: (term, all permutations of (pattern, value) in term) for all terms in `same_symbol`
    // This way we can try to do the pattern matching regardless of the order of the patterns, while knowing which
    // pattern a particular permutation belongs to.
    val all_permutations: List[(OpenReactant, Iterator[List[(Pattern[Any], Any)]])] =
      same_symbol map (t => (t, (t.patterns zip instance.values).permutations))

    // For all permutation, we clone the valuation of the current state, and we try the pattern matching on all
    // (pattern, value) pair in the permutation with this valuation.
    // If it works, we create a new state with the updated valuation clone, `left` with the term of the permutation
    // removed and `right` with `instance` appended. We add this state to `new_states`.
    all_permutations map {
      term_permutations =>
        term_permutations._2 map {
          matching_pairs =>
            val new_s: Valuation = s.clone()
            if (matching_pairs forall (pair => pair._1.matching(new_s, pair._2))) {
              new_states += new State(new_s, left.filter(_ != term_permutations._1), instance :: right)
            }
        }
    }

    // Finally we return `new_states`.
    new_states
  }
}
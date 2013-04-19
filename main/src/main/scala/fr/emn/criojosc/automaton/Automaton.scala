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

class Automaton(premise: Premise) {
  private val scope = premise.reactants.toSet
  val states = (Automaton.combinations(scope) + Set.empty[OpenReactant]).map(reactants => new State(reactants.toSet, scope))
  val transitions = (states, states).zipped.filter(
    (s1, s2) => (s1.reactants subsetOf s2.reactants) && (s1.reactants.size + 1 == s2.reactants.size)
  ).zipped.map((s1, s2) => new Transition(s1, s2))
}

object Automaton {
  def combinations[T](in: Set[T], sup: Set[T] = Set.empty[T], out: Set[Set[T]] = Set.empty[Set[T]]): Set[Set[T]] =
    if (in.isEmpty && sup.isEmpty) out
    else if (in.isEmpty) combinations(sup.dropRight(1), sup.tail, out + sup)
    else if (sup.isEmpty) combinations(in.dropRight(1), in.tail, out + in)
    else combinations(in.dropRight(1), sup, out + in)
}

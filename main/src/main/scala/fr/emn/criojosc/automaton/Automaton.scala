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

import scala.collection.mutable

class Automaton(premise: Premise) {
  import Automaton._
  val states = combinations(premise.reactants) :+ Nil
  val transitions = new mutable.HashMap[Transition, Set[Valuation]] with mutable.MultiMap[Transition, Valuation]
}

object Automaton {
  def combinations[T](in: List[T], sup: List[T] = Nil, out: List[List[T]] = Nil): List[List[T]] =
    if (in.isEmpty && sup.isEmpty) out
    else if (in.isEmpty) combinations(sup.dropRight(1), sup.tail, out :+ sup)
    else if (sup.isEmpty) combinations(in.dropRight(1), in.tail, out :+ in)
    else combinations(in.dropRight(1), sup, out :+ in)
}

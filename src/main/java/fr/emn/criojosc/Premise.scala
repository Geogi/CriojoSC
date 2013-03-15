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

class Premise(val reactants: List[OpenReactant])

object Premise {

  import language.implicitConversions

  class RelationGenOpen[T](r: Relation[T]) {
    def apply(p: Pattern[T]) = new OpenAtom(r, p)
  }

  implicit def relation2genOpen[T](r: Relation[T]) = new RelationGenOpen[T](r)

  implicit def tuple2Pattern[A, B](t: (Pattern[A], Pattern[B])) = new TuplePattern[A, B](t)

  implicit def any2Const[T](c: T) = new Const[T](c)

  def S(p: Pattern[Int]) = new Successor(p)
}

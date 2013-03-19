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

package fr.emn.criojosc.pattern

import fr.emn.criojosc.Valuation

class ListPattern[+T](val head: Pattern[T], val tail: ListPattern[T]) extends Pattern[List[T]] {
  def matching[S >: List[T]](proposed: S, s: Valuation) = proposed match {
    case plist: List[_] => cov_matching(plist, s)
    case _ => (false, s)
  }

  protected def cov_matching[S >: T](proposed: List[S], s: Valuation): (Boolean, Valuation) = {
    if (proposed.isEmpty)
      (false, s)
    else {
      head.matching(proposed.head, s) match {
        case (false, _) => (false, s)
        case (true, ns) => tail.cov_matching(proposed.tail, ns)
      }
    }
  }

  def ::[S >: T](new_head: Pattern[S]): ListPattern[S] = new ListPattern(new_head, this)

  def ::[S >: T](new_head: S): ListPattern[S] = ::(new Const(new_head))
}

case object Nip extends ListPattern[Nothing](Nil.head, throw new UnsupportedOperationException("tail of empty traversable pattern")) {
  override def cov_matching[S >: Nothing](proposed: List[S], s: Valuation) = (proposed.isEmpty, s)

  def &&:[T](p: Pattern[T]): Pattern[T] = p

  def &&:[T](v: T): Pattern[T] = &&:(new Const(v))
}

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

package fr.emn.criojosc.model

class ListPattern[+T] extends Pattern[List[T]] {
  def head: Pattern[T] = throw new UnsupportedOperationException("head of empty list pattern")
  def tail: ListPattern[T] = throw new UnsupportedOperationException("tail of empty list pattern")
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

  def ::[S >: T](new_head: Pattern[S]) = new ListPatternExpand(new_head, this)

  override def toString = ""
}





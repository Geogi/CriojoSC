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

trait Pattern[+T] {
  def matching[S >: T](proposed: S, s: Valuation): (Boolean, Valuation)
}

class Const[+T](val c: T) extends Pattern[T] {
  def matching[S >: T](proposed: S, s: Valuation) = (proposed == c, s)
}

class Successor(predecessor: Pattern[Int]) extends Pattern[Int] {
  def matching[S >: Int](proposed: S, s: Valuation) =
    if (proposed.asInstanceOf[Int] <= 0)
      (false, s)
    else
      predecessor.matching(proposed.asInstanceOf[Int] - 1, s)
}

class TuplePattern[+T1, +T2](val origin: (Pattern[T1], Pattern[T2])) extends Pattern[(T1, T2)] {
  def matching[S >: (T1, T2)](proposed: S, s: Valuation) = cov_matching(proposed.asInstanceOf[(T1, T2)], s)

  private def cov_matching[S1 >: T1, S2 >: T2](proposed: (S1, S2), s: Valuation) = {
    val half = origin._1.matching(proposed._1, s)
    if (!half._1)
      (false, s)
    else
      origin._2.matching(proposed._2, half._2)
  }
}

class ListPattern[+T](val head: Pattern[T], val tail: ListPattern[T]) extends Pattern[List[T]] {
  def matching[S >: List[T]](proposed: S, s: Valuation) =
    cov_matching(proposed.asInstanceOf[List[T]], s)

  def cov_matching[S >: T](proposed: List[S], s: Valuation): (Boolean, Valuation) = {
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
}

case object Nip extends ListPattern[Nothing](Nil.head,
  throw new UnsupportedOperationException("tail of empty traversable pattern")) {
  override def cov_matching[S >: Nothing](proposed: List[S], s: Valuation) = (proposed.isEmpty, s)
}

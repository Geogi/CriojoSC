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

trait InvariantPattern[+T] extends Pattern[T] {
  def matching[S >: T](proposed: S, s: Valuation) = inv_matching(proposed.asInstanceOf[T], s)

  def inv_matching(proposed: T, s: Valuation): (Boolean, Valuation)
}

class Const[+T](val c: T) extends Pattern[T] {
  def matching[S >: T](proposed: S, s: Valuation) = (proposed == c, s)
}

class Successor(predecessor: Pattern[Int]) extends InvariantPattern[Int] {
  def inv_matching(proposed: Int, s: Valuation) =
    if (proposed <= 0) (false, s)
    else predecessor.matching(proposed - 1, s)
}

class TuplePattern[+T1, +T2](val origin: (Pattern[T1], Pattern[T2])) extends InvariantPattern[(T1, T2)] {
  def inv_matching(proposed: (T1, T2), s: Valuation) = cov_matching(proposed, s)

  private def cov_matching[S1 >: T1, S2 >: T2](proposed: (S1, S2), s: Valuation) = {
    val half = origin._1.matching(proposed._1, s)
    if (!half._1)
      (false, s)
    else
      origin._2.matching(proposed._2, half._2)
  }
}

class TraversablePattern[+T](val pattern: Pattern[TraversableOnce[T]]) extends InvariantPattern[TraversableOnce[T]] {
  //TODO stub
  val content = Nil
  val cat = new Const(Nil)

  def inv_matching(proposed: TraversableOnce[T], s: Valuation) = cov_matching(proposed, s)

  private def cov_matching[S >: T](proposed: TraversableOnce[S], s: Valuation) =
    rec_matching(content.toIterator, proposed.toIterator, (true, s)) match {
      case (true, ns: Valuation) => (true, ns)
      case (false, _) => (false, s)
    }

  private def rec_matching[S >: T](oit: Iterator[Pattern[S]],
                                   pit: Iterator[S], partial: (Boolean, Valuation)): (Boolean, Valuation) =
    if (!partial._1)
      (false, partial._2)
    else
    if (oit.hasNext && pit.hasNext)
      rec_matching(oit, pit, oit.next().matching(pit.next(), partial._2))
    else
      (!oit.hasNext && !pit.hasNext, partial._2)

  def ::[S >: T](head: Pattern[S]) = new TraversablePattern[S](cat)
}

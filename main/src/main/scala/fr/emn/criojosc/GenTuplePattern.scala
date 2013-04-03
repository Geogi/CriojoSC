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

class Tuple2Pattern[+T1, +T2](val origin: (Pattern[T1], Pattern[T2])) extends Pattern[(T1, T2)] {
  def matching[S >: (T1, T2)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2](proposed: (S1, S2), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ")"
}

class Tuple3Pattern[+T1, +T2, +T3](val origin: (Pattern[T1], Pattern[T2], Pattern[T3])) extends Pattern[(T1, T2, T3)] {
  def matching[S >: (T1, T2, T3)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3](proposed: (S1, S2, S3), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ")"
}

class Tuple4Pattern[+T1, +T2, +T3, +T4](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4])) extends Pattern[(T1, T2, T3, T4)] {
  def matching[S >: (T1, T2, T3, T4)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4](proposed: (S1, S2, S3, S4), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ")"
}

class Tuple5Pattern[+T1, +T2, +T3, +T4, +T5](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5])) extends Pattern[(T1, T2, T3, T4, T5)] {
  def matching[S >: (T1, T2, T3, T4, T5)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5](proposed: (S1, S2, S3, S4, S5), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ")"
}

class Tuple6Pattern[+T1, +T2, +T3, +T4, +T5, +T6](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6])) extends Pattern[(T1, T2, T3, T4, T5, T6)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6](proposed: (S1, S2, S3, S4, S5, S6), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ")"
}

class Tuple7Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7](proposed: (S1, S2, S3, S4, S5, S6, S7), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ")"
}

class Tuple8Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8](proposed: (S1, S2, S3, S4, S5, S6, S7, S8), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ")"
}

class Tuple9Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ")"
}

class Tuple10Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ")"
}

class Tuple11Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ")"
}

class Tuple12Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11], Pattern[T12])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11, S12 >: T12](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._12.matching(proposed._12, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ", " + origin._12 + ")"
}

class Tuple13Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12, +T13](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11], Pattern[T12], Pattern[T13])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11, S12 >: T12, S13 >: T13](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._12.matching(proposed._12, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._13.matching(proposed._13, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ", " + origin._12 + ", " + origin._13 + ")"
}

class Tuple14Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12, +T13, +T14](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11], Pattern[T12], Pattern[T13], Pattern[T14])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11, S12 >: T12, S13 >: T13, S14 >: T14](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._12.matching(proposed._12, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._13.matching(proposed._13, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._14.matching(proposed._14, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ", " + origin._12 + ", " + origin._13 + ", " + origin._14 + ")"
}

class Tuple15Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12, +T13, +T14, +T15](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11], Pattern[T12], Pattern[T13], Pattern[T14], Pattern[T15])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11, S12 >: T12, S13 >: T13, S14 >: T14, S15 >: T15](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._12.matching(proposed._12, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._13.matching(proposed._13, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._14.matching(proposed._14, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._15.matching(proposed._15, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ", " + origin._12 + ", " + origin._13 + ", " + origin._14 + ", " + origin._15 + ")"
}

class Tuple16Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12, +T13, +T14, +T15, +T16](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11], Pattern[T12], Pattern[T13], Pattern[T14], Pattern[T15], Pattern[T16])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11, S12 >: T12, S13 >: T13, S14 >: T14, S15 >: T15, S16 >: T16](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._12.matching(proposed._12, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._13.matching(proposed._13, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._14.matching(proposed._14, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._15.matching(proposed._15, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._16.matching(proposed._16, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ", " + origin._12 + ", " + origin._13 + ", " + origin._14 + ", " + origin._15 + ", " + origin._16 + ")"
}

class Tuple17Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12, +T13, +T14, +T15, +T16, +T17](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11], Pattern[T12], Pattern[T13], Pattern[T14], Pattern[T15], Pattern[T16], Pattern[T17])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11, S12 >: T12, S13 >: T13, S14 >: T14, S15 >: T15, S16 >: T16, S17 >: T17](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16, S17), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._12.matching(proposed._12, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._13.matching(proposed._13, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._14.matching(proposed._14, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._15.matching(proposed._15, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._16.matching(proposed._16, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._17.matching(proposed._17, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ", " + origin._12 + ", " + origin._13 + ", " + origin._14 + ", " + origin._15 + ", " + origin._16 + ", " + origin._17 + ")"
}

class Tuple18Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12, +T13, +T14, +T15, +T16, +T17, +T18](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11], Pattern[T12], Pattern[T13], Pattern[T14], Pattern[T15], Pattern[T16], Pattern[T17], Pattern[T18])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11, S12 >: T12, S13 >: T13, S14 >: T14, S15 >: T15, S16 >: T16, S17 >: T17, S18 >: T18](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16, S17, S18), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._12.matching(proposed._12, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._13.matching(proposed._13, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._14.matching(proposed._14, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._15.matching(proposed._15, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._16.matching(proposed._16, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._17.matching(proposed._17, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._18.matching(proposed._18, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ", " + origin._12 + ", " + origin._13 + ", " + origin._14 + ", " + origin._15 + ", " + origin._16 + ", " + origin._17 + ", " + origin._18 + ")"
}

class Tuple19Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12, +T13, +T14, +T15, +T16, +T17, +T18, +T19](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11], Pattern[T12], Pattern[T13], Pattern[T14], Pattern[T15], Pattern[T16], Pattern[T17], Pattern[T18], Pattern[T19])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11, S12 >: T12, S13 >: T13, S14 >: T14, S15 >: T15, S16 >: T16, S17 >: T17, S18 >: T18, S19 >: T19](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16, S17, S18, S19), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._12.matching(proposed._12, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._13.matching(proposed._13, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._14.matching(proposed._14, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._15.matching(proposed._15, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._16.matching(proposed._16, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._17.matching(proposed._17, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._18.matching(proposed._18, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._19.matching(proposed._19, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ", " + origin._12 + ", " + origin._13 + ", " + origin._14 + ", " + origin._15 + ", " + origin._16 + ", " + origin._17 + ", " + origin._18 + ", " + origin._19 + ")"
}

class Tuple20Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12, +T13, +T14, +T15, +T16, +T17, +T18, +T19, +T20](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11], Pattern[T12], Pattern[T13], Pattern[T14], Pattern[T15], Pattern[T16], Pattern[T17], Pattern[T18], Pattern[T19], Pattern[T20])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11, S12 >: T12, S13 >: T13, S14 >: T14, S15 >: T15, S16 >: T16, S17 >: T17, S18 >: T18, S19 >: T19, S20 >: T20](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16, S17, S18, S19, S20), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._12.matching(proposed._12, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._13.matching(proposed._13, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._14.matching(proposed._14, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._15.matching(proposed._15, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._16.matching(proposed._16, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._17.matching(proposed._17, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._18.matching(proposed._18, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._19.matching(proposed._19, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._20.matching(proposed._20, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ", " + origin._12 + ", " + origin._13 + ", " + origin._14 + ", " + origin._15 + ", " + origin._16 + ", " + origin._17 + ", " + origin._18 + ", " + origin._19 + ", " + origin._20 + ")"
}

class Tuple21Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12, +T13, +T14, +T15, +T16, +T17, +T18, +T19, +T20, +T21](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11], Pattern[T12], Pattern[T13], Pattern[T14], Pattern[T15], Pattern[T16], Pattern[T17], Pattern[T18], Pattern[T19], Pattern[T20], Pattern[T21])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11, S12 >: T12, S13 >: T13, S14 >: T14, S15 >: T15, S16 >: T16, S17 >: T17, S18 >: T18, S19 >: T19, S20 >: T20, S21 >: T21](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16, S17, S18, S19, S20, S21), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._12.matching(proposed._12, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._13.matching(proposed._13, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._14.matching(proposed._14, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._15.matching(proposed._15, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._16.matching(proposed._16, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._17.matching(proposed._17, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._18.matching(proposed._18, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._19.matching(proposed._19, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._20.matching(proposed._20, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._21.matching(proposed._21, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ", " + origin._12 + ", " + origin._13 + ", " + origin._14 + ", " + origin._15 + ", " + origin._16 + ", " + origin._17 + ", " + origin._18 + ", " + origin._19 + ", " + origin._20 + ", " + origin._21 + ")"
}

class Tuple22Pattern[+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12, +T13, +T14, +T15, +T16, +T17, +T18, +T19, +T20, +T21, +T22](val origin: (Pattern[T1], Pattern[T2], Pattern[T3], Pattern[T4], Pattern[T5], Pattern[T6], Pattern[T7], Pattern[T8], Pattern[T9], Pattern[T10], Pattern[T11], Pattern[T12], Pattern[T13], Pattern[T14], Pattern[T15], Pattern[T16], Pattern[T17], Pattern[T18], Pattern[T19], Pattern[T20], Pattern[T21], Pattern[T22])) extends Pattern[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22)] {
  def matching[S >: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2, S3 >: T3, S4 >: T4, S5 >: T5, S6 >: T6, S7 >: T7, S8 >: T8, S9 >: T9, S10 >: T10, S11 >: T11, S12 >: T12, S13 >: T13, S14 >: T14, S15 >: T15, S16 >: T16, S17 >: T17, S18 >: T18, S19 >: T19, S20 >: T20, S21 >: T21, S22 >: T22](proposed: (S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16, S17, S18, S19, S20, S21, S22), s: Valuation): (Boolean, Valuation) = {
    var pr = (false, s)
    var ps = s
    pr = origin._1.matching(proposed._1, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._2.matching(proposed._2, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._3.matching(proposed._3, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._4.matching(proposed._4, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._5.matching(proposed._5, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._6.matching(proposed._6, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._7.matching(proposed._7, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._8.matching(proposed._8, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._9.matching(proposed._9, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._10.matching(proposed._10, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._11.matching(proposed._11, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._12.matching(proposed._12, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._13.matching(proposed._13, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._14.matching(proposed._14, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._15.matching(proposed._15, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._16.matching(proposed._16, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._17.matching(proposed._17, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._18.matching(proposed._18, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._19.matching(proposed._19, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._20.matching(proposed._20, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._21.matching(proposed._21, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    pr = origin._22.matching(proposed._22, ps)
    if (!pr._1)
      return (false, s)
    ps = pr._2
    (true, ps)
  }

  override def toString = "~(" + origin._1 + ", " + origin._2 + ", " + origin._3 + ", " + origin._4 + ", " + origin._5 + ", " + origin._6 + ", " + origin._7 + ", " + origin._8 + ", " + origin._9 + ", " + origin._10 + ", " + origin._11 + ", " + origin._12 + ", " + origin._13 + ", " + origin._14 + ", " + origin._15 + ", " + origin._16 + ", " + origin._17 + ", " + origin._18 + ", " + origin._19 + ", " + origin._20 + ", " + origin._21 + ", " + origin._22 + ")"
}


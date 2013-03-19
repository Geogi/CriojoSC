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

class TuplePattern[+T1, +T2](val origin: (Pattern[T1], Pattern[T2])) extends Pattern[(T1, T2)] {
  def matching[S >: (T1, T2)](proposed: S, s: Valuation) = proposed match {
    case ptuple: (_, _) => cov_matching(ptuple, s)
    case _ => (false, s)
  }

  private def cov_matching[S1 >: T1, S2 >: T2](proposed: (S1, S2), s: Valuation) = {
    val half = origin._1.matching(proposed._1, s)
    if (!half._1)
      (false, s)
    else
      origin._2.matching(proposed._2, half._2)
  }
}

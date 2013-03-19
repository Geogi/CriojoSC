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

import fr.emn.criojosc.{Pattern, Valuation}

class Successor(predecessor: Pattern[Int]) extends Pattern[Int] {
  def matching[S >: Int](proposed: S, s: Valuation) = proposed match {
    case pint: Int if pint > 0 => predecessor.matching(pint - 1, s)
    case _ => (false, s)
  }

}

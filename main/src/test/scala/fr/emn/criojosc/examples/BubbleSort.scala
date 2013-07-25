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
package examples

import fr.emn.criojosc.model.{Agent, Valuation}
import fr.emn.criojosc.model.pattern.Variable
import fr.emn.criojosc.model.relation.Relation

object BubbleSort {
  val R = Relation[Int, Int]("R")
  val agent = namedAgent("BubbleSort")(
  {
    val Seq(i, j, u, v) = Variable.multi[Int]("i", "j", "u", "v")
    (R?(i, u) & R?(j, v)). --> (
      (s: Valuation) => j(s) > i(s) && u(s) > v(s)). ? (
      (s: Valuation) => R(i(s), v(s)) & R(j(s), u(s)))
  },
  R(0, 0), R(1, 3), R(2, 2), R(3, 1), R(4, 7), R(5, 2), R(6, 8), R(7, 5), R(8, 3), R(9, 6)
  )
}

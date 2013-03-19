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

import fr.emn.criojosc._

object Engine extends App {
  val agent = new Agent {
    val R = Relation[(Int, (String, Char))]
    val rule = new Rule {
      val z = Var[Int]
      val premise = new Premise(List(R ? (S ? (z) &: "a" &: ?('b'))))

      def right_hand(implicit s: Valuation) = (
        !z > 0,
        new Conclusion(List(R(1, ("a", 1))))
        )
    }

    val channels = List()
    val relations = List(R)
    val rules = List(rule)
    val solution = Solution(R(1, ("b", 1)))
  }
}
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

import org.specs2._

class BubbleSortSpec extends Specification { def is =
  "Test CriojoSC with the bubble sort algorithm"         ^
                                                         p^
  automatonOut                                           ^
                                                         end

  val bubbleSort = engine (
    {
      val R = Relation[Int, Int]("R")
      namedAgent("BubbleSort")(
      {
        val List(i, j, u, v) = Variable.multi[Int]("i", "j", "u", "v")
        (R?(i, u) & R?(j, v)). --> (!j > !i && !u > !v). ? (R(!i, !v) & R(!j, !u))
      },
      R(0, 0), R(1, 3), R(2, 2)
      )
    }
  )

  lazy val automatonOut = {
    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) {
      bubbleSort.run()
    }
    val output = stream.toString
    stream.close()
    output
  }
}

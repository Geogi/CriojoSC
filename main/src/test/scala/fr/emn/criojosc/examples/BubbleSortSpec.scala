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
import fr.emn.criojosc.automaton.VerboseEngine
import fr.emn.criojosc.model._
import fr.emn.criojosc.model.NativeGuard
import scala.Some

class BubbleSortSpec extends Specification { def is =
  "Test CriojoSC with the transitive closure algorithm"         ^
                                                                p^
  automatonOut                                                  ^
                                                                end

  val max = 10

  lazy val bubbleSort = new Agent {
    override val name = Some("BubbleSort")

    lazy val R = Relation[Int, Int]("R")
    val solution = new Solution(Set(R(0, 0)))
    val rules = Seq(
      new Rule {
        override val name = Some("Sort")
        lazy val (i, j, u, v) = (Variable[Int]("i"), Variable[Int]("j"), Variable[Int]("u"), Variable[Int]("v"))
        def conclusion(implicit s: Valuation) = new Conclusion(List(R(!i, !v), R(!j, !u)))
        override val explicitVal = Some("R(i, v) & R(j, u))")

        val premise = new Premise(List(R?(i, u), R?(j, v)))
        val guard = new NativeGuard({implicit s: Valuation => !j == !i + 1 && !u > !v}) {
          override val explicitVal = Some("j == i + 1 && u > v")
        }
      }
    )
  }
  lazy val engine = new VerboseEngine(List(bubbleSort))
  engine.MAX_ITS = Some(100)

  lazy val automatonOut = {
    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) {
      engine.run()
    }
    val output = stream.toString
    stream.close()
    output
  }
}

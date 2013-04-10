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
package printer

import org.specs2._

class PrinterEngineSpec extends Specification { def is =
  "Printer engine specification."                         ^
                                                          p^
  "Print two agents"                                      ! testPrinter ^
                                                          end

  def testPrinter = {
    val agent1 = new Agent {
      val R = Relation[List[String], Int]
      val A = new Rule {
        val x = Var[String]
        val premise = new Premise(List(R?(x :: Nip, 1)))
        def right_hand(implicit s: Valuation) = (true, new Conclusion(R(!x :: "a" :: Nil, 1) :: Nil))
      }
      val rules = Seq(A)
      val solution = Solution(R("a" :: Nil, 1))
    }
    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) {
      new PrinterEngine(Seq(agent1)).run()
    }
    val output = stream.toString
    stream.close()
    output === """agent[R] {
        |}
        |""".stripMargin
  }
}

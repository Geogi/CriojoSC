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
package automaton

import org.specs2._

class EngineSpec extends Specification { def is =
  "Automaton engine specification."                          ^
                                                             p^
  "Be the rule: R(x) & R(y) -> T? R(x + y)"                  ^
    "Test output"                                            ! testAutomaton ^
                                                             end

  lazy val agent = new Agent {
    lazy val R = Relation[Int]
    lazy val rule = new Rule {
      val x, y = Var[Int]
      val premise = new Premise(List(R?(1)))
      def right_hand(implicit s: Valuation) = (true, new Conclusion(R(1) :: Nil))
    }
    val rules = List(rule)
    val solution = new Solution(Set(R(1), R(2)))
  }
  lazy val engine = new Engine(List(agent))

  def testAutomaton = {
    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) {
      engine.run()
    }
    val output = stream.toString
    stream.close()
    output === """Equilibrium reached.
                 |""".stripMargin
  }
}

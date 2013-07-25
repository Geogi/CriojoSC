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
import fr.emn.criojosc.model._
import fr.emn.criojosc.model.guard.{ControlGuard, NativeGuard}
import fr.emn.criojosc.model.rule.{Solution, Premise, Conclusion}
import fr.emn.criojosc.model.pattern.Variable

class EngineSpec extends Specification { def is =
  "Automaton engine specification."                               ^
                                                                  p^
    automatonOut                                                  ^
                                                                  end

  lazy val agent = new Agent {
    lazy val R, S = Relation[Int]
    lazy val rule = new Rule {
      val x, y = Variable[Int]
      val premise = new Premise(List(R?(x), R?(y)))
      val guard: Guard = ! new ControlGuard {
        val z = Variable[Int]
        val premise = new Premise(List(S?(z)))
        val guard: Guard = NativeGuard((s: Valuation) => true)
      }
      def conclusion(s: Valuation) = new Conclusion(R(x(s) + y(s)) :: Nil)
    }
    val rules = List(rule)
    val solution = new Solution(Set(R(1), R(2), R(3), S(0)))
  }
  lazy val engine = new VerboseEngine(List(agent))

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

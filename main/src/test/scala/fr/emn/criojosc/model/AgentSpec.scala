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
package model

import org.specs2._
import fr.emn.criojosc.model.rule.{Conclusion, Solution}
import fr.emn.criojosc.model.guard.TrueGuard

class AgentSpec extends Specification { def is =

  "Agent specification."                           ^
                                                   p^
  "An agent is created by implementing its trait." ! createAgent^
                                                   end

  def createAgent = {
    deduplication must beAnInstanceOf[Agent]
  }

  val deduplication = new Agent {
    val R = Relation[Any]("R")
    val r = new Rule {
      val x = Variable[Any]("x")

      def conclusion(s: Valuation) = new Conclusion(List(R(x)))

      val premise = R?(x) & R?(x)
      val guard = TrueGuard
    }
    override val rules = List(r)
    override val solution = Solution(R(0), R(0), R(1))
  }
}

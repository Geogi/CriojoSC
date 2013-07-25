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

package fr.emn.criojosc.examples

import fr.emn.criojosc.model.{Valuation, Rule, Agent}
import fr.emn.criojosc._
import fr.emn.criojosc.model.rule.{Solution, Conclusion}
import fr.emn.criojosc.model.guard.{NativeGuard, TrueGuard}

object Deduplication extends Agent {
  override val optName = Some("Deduplication")
  val R = Relation[Int]("R")
  val r = new Rule {
    val Seq(x, y) = Variable.multi[Int]("x", "y")

    def conclusion(s: Valuation) = new Conclusion(List(R(x(s))))
    override val explicitVal = Some("R(x)")

    val premise = R?(x) & R?(y)
    val guard = new NativeGuard((s: Valuation) => x(s) == y(s)) {
      override val explicitVal = Some("x! == y!")
    }
  }
  override val rules = List(r)
  override val solution = Solution(R(0), R(0), R(1))
}

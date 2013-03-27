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
package experimental

import reflect.runtime.universe._

class PrettyPrinter(val agents: Iterable[Agent]) extends Engine {
  def print: String = agents.zipWithIndex.map(printAgent).mkString("\n")

  private def printAgent(args: (Agent, Int)): String = {
    val (agent, index) = args
    val names = (agent.relations ++ agent.channels).zipWithIndex.map(t => (t._1, genStringName(t._2))).toMap
    "Agent " + index + ":\n" + agent.rules.map("  " + printRule(_, names))
  }

  private def printRule(rule: Rule, entityNames: Map[EntitySymbol, String]): String = {
    //getType(rule).members.filter(_.isMethod).map(_.asMethod).map(_.)
    ""
  }

  private def genStringName(index: Int): String =
    if (index < 26) (index + 65).toChar.toString
    else genStringName(index / 26 - 1) + genStringName(index % 26)

  private def getType[T: TypeTag](obj: T) = typeTag[T].tpe
}

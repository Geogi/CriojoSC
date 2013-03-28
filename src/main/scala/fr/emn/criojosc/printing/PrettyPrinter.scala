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
package printing

import reflect.runtime.universe._
import tools.reflect.ToolBox
import fr.emn.criojosc.{Engine, Agent}

class PrettyPrinter(val agents: Iterable[Agent]) extends Engine {
  def print: String = ""
}

trait Printable[T] {
  val ast: Expr[T]
  private val rm = runtimeMirror(getClass.getClassLoader)
  val tb = rm.mkToolBox()
  def goodMirror: Mirror[Printable.this.type.tb.u]
  val value = tb.compile(ast).asInstanceOf[T]
}

trait PrintableAgent extends Agent with Printable[Agent] {

}

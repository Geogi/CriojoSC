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

import language.experimental.macros
import reflect.macros.Context

trait RichAgent extends Agent with Named {
}

object RichAgent {
  def enrich(a: Agent): Unit = macro enrichImpl
  def enrichImpl(c: Context)(a: c.Expr[Agent]): c.Expr[Unit] = {
    import c.universe._
    println(a)
    println("-----")
    c.Expr[Unit](Block(List(Literal(Constant(1))), Literal(Constant(()))))
  }
}

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

package fr.emn.criojosc.printer

import language.experimental.macros
import reflect.macros.Context

trait Quine[T] {
  val ast: Context#Tree
  val value: T
}

object Quine {
  def quinize[T](obj: T): Quine[T] = macro quinizeImpl[T]
  def quinizeImpl[T: c.WeakTypeTag](c: Context)(obj: c.Expr[T]): c.Expr[Quine[T]] = {
    import c.universe._
    val this_ast: Expr[Tree] = reify { Literal(Constant(obj.splice)) }
    reify { new Quine[T] {
      val ast = this_ast.splice
      val value = obj.splice
    }}
  }
}

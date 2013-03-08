/*
 * Copyright (c) 2013 Paul Blouët.
 *
 * This file is part of criojo-min.
 *
 * criojo-min is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * criojo-min is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with criojo-min.  If not, see <http://www.gnu.org/licenses/>.
 */

package fr.paulblouet.criojomin

import util.{Failure, Success, Try}

trait Pattern[T] {
  def get(s: Valuation): T

  def set(s: Valuation, v: T, mod: (T) => T = Function.const[T, T])

  def matching(s: Valuation, proposed: T): Boolean = Try(get(s)) match {
    case Success(real) => proposed == real
    case Failure(_: NoSuchElementException) => {
      set(s, proposed)
      true
    }
    case Failure(e) => throw e
  }
}

trait RecursivePattern[T] extends Pattern[T] {
  val child: Pattern[T]

  def set_recursion(v: T): T

  def get_recursion(v: T): T

  override def set(s: Valuation, v: T, mod: (T) => T) {
    child.set(s, v, mod compose set_recursion)
  }

  override def get(s: Valuation) = child.get(s)
}

class Const[T](val c: T) extends Pattern[T] {
  override def get(s: Valuation) = c

  override def set(s: Valuation, x: T, mod: (T) => T) {}
}

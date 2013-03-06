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

trait Pattern[T] {
  def get: T

  def set(s: Valuation, mod: (T) => T = x => x, v: T)
}

trait PredefPatterns {

  // utility
  trait RecursivePattern[T] extends Pattern[T] {
    val child: Pattern[T]

    def set_recursion(v: T): T

    def get_recursion(v: T): T

    override def set(s: Valuation, mod: (T) => T, v: T) {
      child.set(s, mod compose set_recursion, v)
    }

    override def get = child.get
  }

  // constants
  class Const[T](override val get: T) extends Pattern[T] {
    override def set(s: Valuation, mod: (T) => T, x: T) {}
  }

  def C(i: Int) = new Const[Int](i)

  // functional patterns
  def S(this_child: Pattern[Int]) = new RecursivePattern[Int] {
    override val child = this_child

    override def set_recursion(i: Int) = i - 1

    override def get_recursion(i: Int) = i + 1
  }
}

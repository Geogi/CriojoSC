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

package fr.paulblouet

package object criojomin {
  def C(i: Int) = new Const[Int](i)

  def C[T](c: T) = new Const[T](c)

  // functional patterns
  def S(this_child: Pattern[Int]) = new RecursivePattern[Int] {
    override val child = this_child

    override def set_recursion(i: Int) = i - 1

    override def get_recursion(i: Int) = i + 1
  }

}

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

package fr.emn

/** Criojo-Min is an implementation of CRIOJO, a CHAM-based engine for running concurrent applications with guaranteed causal order.<br />
  * It sounds cool, but it's far from complete at the moment.
  *
  * Criojo-Min uses Scala and is GPL licenced.
  *
  * Some useful resources:
  * <ul>
  * <li>The mainline implementation by Mayleen Lacouture: [[https://github.com/maylencita/CRIOJO/tree/version2.0 maylencita/CRIOJO@GitHub]]</li>
  * <li>The latest CRIOJO research paper: [[http://hal.inria.fr/hal-00676083/]]</li>
  * </ul>
  */
package object criojosc {
  /** Creates an Int [[fr.emn.criojosc.Const]] of value `i`. */
  def C(i: Int) = new Const[Int](i)

  /** Creates a [[fr.emn.criojosc.Const]] of any value `c: T`. */
  def C[T](c: T) = new Const[T](c)

  /** Successor [[fr.emn.criojosc.Pattern]]: binds to `i - 1` and returns `i + 1`. */
  def S(this_child: Pattern[Int]) = new RecursivePattern[Int] {
    override val child = this_child

    override def set_recursion(i: Int) = i - 1

    override def get_recursion(i: Int) = i + 1
  }

}

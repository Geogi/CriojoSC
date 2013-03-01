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

/*
If we have (x, y, z): R(x, y + 1) & S(y) --> T(z) | z < y ? R(x, y) & S(y)
We want to rewrite it as:
(x: Var[Any], y: Var[Int], z: Var[Int]) => (R(x, {what?}
*/
trait Rule {
  private type Content = (Iterable[Variable] => (Premise, Valuation => (Guard, Conclusion)))

  private trait Premise {
    val reagents: Iterable[Reagent]
  }

  private trait Guard

  private trait Conclusion

}

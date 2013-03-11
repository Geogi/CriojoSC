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

package fr.emn.criojosc

class Variable[+T] extends Pattern[T] {
  override def get(s: Valuation): T = s(this).asInstanceOf[T]

  def unary_!(s: Valuation) = get(s)

  override def set[S >: T](s: Valuation, v: S, mod: (S) => S) {
    s +=(this, mod(v))
  }
}

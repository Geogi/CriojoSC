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

import util.{Failure, Success, Try}

trait Pattern[+T] {
  def get(s: Valuation): T

  def set[S >: T](s: Valuation, v: S, mod: (S) => S = identity[S] _)

  def matching[S >: T](s: Valuation, proposed: S): Boolean = Try(get(s)) match {
    case Success(real) => proposed == real
    case Failure(_: NoSuchElementException) => {
      set(s, proposed)
      true
    }
    case Failure(e) => throw e
  }
}

class Const[+T](val c: T) extends Pattern[T] {
  override def get(s: Valuation) = c

  override def set[S >: T](s: Valuation, x: S, mod: (S) => S) {}
}

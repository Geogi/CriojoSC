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

class AtomPattern(val symbol: Atom, val patterns: List[Pattern[_]]) extends Reactant

class AtomInstance(val symbol: Atom, val values: List[Any]) extends Molecule

trait Atom

class Atom0 extends Atom {
  def unary_~ = new AtomPattern(this, Nil)

  def unary_! = new AtomInstance(this, Nil)
}

class Atom1[T1] extends Atom {
  def apply(p1: Pattern[T1]) = new AtomPattern(this, List(p1))

  def apply(v1: T1) = new AtomInstance(this, List(v1))
}

class Atom2[T1, T2] extends Atom {
  def apply(p1: Pattern[T1], p2: Pattern[T2]) = new AtomPattern(this, List(p1, p2))

  def apply(v1: T1, v2: T2) = new AtomInstance(this, List(v1, v2))
}

object Atom {
  def apply() = new Atom0

  def apply[T1] = new Atom1[T1]

  def apply[T1, T2] = new Atom2[T1, T2]
}

/*
 * Copyright (c) 2013 Paul Blouët.
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

/** An atom identifier, which can create [[fr.emn.criojosc.OpenAtom]]s and
  * [[fr.emn.criojosc.ClosedAtom]]s.<br />
  *
  * Use the companion object to create new instances of `Atom`, as it will transparently instantiate
  * [[fr.emn.criojosc.Relation]] with the right type.
  *
  * Usage:
  * {{{
  * val R = Relation[Int]          // Relation
  * val p = Var[Int]               // Pattern
  * R(p)                           // OpenAtom (argument is a Pattern)
  * R(!p)                          // ClosedAtom (argument is not a Pattern)
  * }}}
  */

/** An identifier for an unary atom. See [[fr.emn.criojosc.Relation]] for more details. */
class Relation[+T] {
  /** Creates an [[fr.emn.criojosc.OpenAtom]] of this atom with pattern `p1`. */
  val symbol = new EntitySymbol

  def apply[S >: T](p: Pattern[S]) = new OpenAtom(symbol, List(p))

  /** Creates an [[fr.emn.criojosc.ClosedAtom]] of this atom with value `v1`. */
  def apply[S >: T](v: S) = new ClosedAtom(symbol, List(v))
}

/** This object provides utilities for creating [[fr.emn.criojosc.Relation]]s. */
object Relation {
  /** Creates a ([[fr.emn.criojosc.Relation]]) with signature `T` */
  def apply[T] = new Relation[T]
}
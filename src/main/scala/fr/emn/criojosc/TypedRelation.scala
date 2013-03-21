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

package fr.emn.criojosc

/** An atom identifier, which can create [[fr.emn.criojosc.OpenAtom]]s and
  * [[fr.emn.criojosc.ClosedAtom]]s.<br />
  *
  * Use the companion object to create new instances of `Atom`, as it will transparently instantiate
  * [[fr.emn.criojosc.TypedRelation]] with the right type.
  *
  * Usage:
  * {{{
  * val R = Relation[Int]          // TypedRelation
  * val p = Var[Int]               // Pattern
  * R(p)                           // OpenAtom (argument is a Pattern)
  * R(!p)                          // ClosedAtom (argument is not a Pattern)
  * }}}
  */

/** An identifier for an unary atom. See [[fr.emn.criojosc.TypedRelation]] for more details. */
class TypedRelation[T] extends Relation {
  def apply(v: T) = new ClosedAtom(this, v)

  def ?(p: Pattern[T]): OpenAtom = new OpenAtom(this, p)
}

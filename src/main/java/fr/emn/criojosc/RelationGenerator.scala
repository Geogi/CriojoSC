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
  * [[fr.emn.criojosc.RelationGenerator]] with the right type.
  *
  * Usage:
  * {{{
  * val R = Relation[Int]          // RelationGenerator
  * val p = Var[Int]               // Pattern
  * R(p)                           // OpenAtom (argument is a Pattern)
  * R(!p)                          // ClosedAtom (argument is not a Pattern)
  * }}}
  */

trait Relation extends EntitySymbol

/** An identifier for an unary atom. See [[fr.emn.criojosc.RelationGenerator]] for more details. */
class RelationGenerator[T] extends Relation {
  val or = new PatternRelation[T](this)
  val cr = new TermRelation[T](this)
}

/** This object provides utilities for creating [[fr.emn.criojosc.RelationGenerator]]s. */
object Relation {
  /** Creates a ([[fr.emn.criojosc.RelationGenerator]]) with signature `T` */
  def apply[T] = new RelationGenerator[T]
}

trait TermPatternImplicits {

  import language.implicitConversions

  implicit def relation2genClosed[T](r: RelationGenerator[T]) = new TermRelation[T](r)
}
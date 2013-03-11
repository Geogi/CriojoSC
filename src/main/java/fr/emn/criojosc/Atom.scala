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

/** A symbolic representation of an [[fr.emn.criojosc.Atom]], as used in rule premises and "where" guards.<br />
  * The engine matches it against the actual instances in [[fr.emn.criojosc.EntitySymbol]] to produce a
  * [[fr.emn.criojosc.Valuation]], used by most [[fr.emn.criojosc.Guard]]s and
  * [[fr.emn.criojosc.Rule]] conclusions.
  *
  * Note that while [[fr.emn.criojosc.AtomPattern]] is not typed itself, it is created by
  * an AtomN ([[fr.emn.criojosc.Atom0]], [[fr.emn.criojosc.Atom1]], etc) that
  * is typed, ensuring a consistent state.<br />
  * This is why instances of this class should not be created manually, but using `Atom.apply` (arity > 0) or
  * `Atom0.unary_~`.
  *
  * @param symbol The Atom this particular representation refers to.
  * @param patterns The list of [[fr.emn.criojosc.Pattern]]s used by the matching process.
  */
class AtomPattern(val symbol: Atom, val patterns: List[Pattern[Any]]) extends Term

/** An instance of an [[fr.emn.criojosc.Atom]] in a given state (a list of an unbound type).<br />
  * It may exist in [[fr.emn.criojosc.EntitySymbol]] or be the product of a [[fr.emn.criojosc.Rule]]
  * (listed in its conclusion).
  *
  * Note that while [[fr.emn.criojosc.AtomInstance]] is not typed itself, it is created by
  * an `AtomN` ([[fr.emn.criojosc.Atom0]], [[fr.emn.criojosc.Atom1]], etc) that
  * is typed, ensuring a consistent state.<br />
  * This is why instances of this class should not be created manually, but using `Atom.apply` (arity > 0) or
  * `Atom0.unary_!`.
  *
  * @param symbol The Atom this instance refers to.
  * @param values The list of values (unbound type) that defines the state of this instance.
  */
class AtomInstance(val symbol: Atom, val values: List[Any]) extends Instance

/** An atom identifier, which can create [[fr.emn.criojosc.AtomPattern]]s and
  * [[fr.emn.criojosc.AtomInstance]]s.<br />
  * Its implementations are arity dependent: [[fr.emn.criojosc.Atom0]] to (currently)
  * [[fr.emn.criojosc.Atom2]] (will expand to Atom22, to match `scala.Product`).
  *
  * Use the companion object to create new instances of `Atom`, as it will transparently instantiate the right `AtomN`
  * class.<br />
  * The way to create patterns or instances of the atom depends on whether it's nullary (see example below).
  *
  * @example {{{
  *                                                                                                                           val atom0 = Atom()             // nullary Atom
  *                                                                                                                           ~atom0                         // AtomPattern
  *                                                                                                                           !atom0                         // AtomInstance
  *
  *                                                                                                                           val atom2 = Atom[Int, String]  // binary Atom
  *                                                                                                                           val p2 = Var[String]           // Pattern
  *                                                                                                                           atom2(C(2), p2)                // AtomPattern (all arguments are Patterns)
  *                                                                                                                           atom2(2, !p2)                  // AtomInstance (no argument is a Pattern)
  *                                                                                                                           atom2(2, p2)                   // !!!AtomInstance!!! (at least one argument, here the first, is not a Pattern)
  *                                                                                                                                                          // __this is probably not what you want, since p2 will not be valuated__
  *                                                                                                                           /* Likewise with Atom1 to Atom22 */
  *          }}}
  */
trait Atom extends EntitySymbol

/** An identifier for a nullary atom. See [[fr.emn.criojosc.Atom]] for more details. */
class Atom0 extends Atom {
  /** Creates an [[fr.emn.criojosc.AtomPattern]] of this atom */
  def unary_~ = new AtomPattern(this, Nil)

  /** Creates an [[fr.emn.criojosc.AtomInstance]] of this atom */
  def unary_! = new AtomInstance(this, Nil)
}

/** An identifier for an unary atom. See [[fr.emn.criojosc.Atom]] for more details. */
class Atom1[T1] extends Atom {
  /** Creates an [[fr.emn.criojosc.AtomPattern]] of this atom with pattern `p1`. */
  def apply(p1: Pattern[T1]) = new AtomPattern(this, List(p1))

  /** Creates an [[fr.emn.criojosc.AtomInstance]] of this atom with value `v1`. */
  def apply(v1: T1) = new AtomInstance(this, List(v1))
}

/** An identifier for a binary atom. See [[fr.emn.criojosc.Atom]] for more details. */
class Atom2[T1, T2] extends Atom {
  /** Creates an [[fr.emn.criojosc.AtomPattern]] of this atom with patterns `p1`, `p2`. */
  def apply(p1: Pattern[T1], p2: Pattern[T2]) = new AtomPattern(this, List(p1, p2))

  /** Creates an [[fr.emn.criojosc.AtomInstance]] of this atom with values `v1`, `v2`. */
  def apply(v1: T1, v2: T2) = new AtomInstance(this, List(v1, v2))
}

/** This object provides utilities for creating [[fr.emn.criojosc.Atom]]s.
  *
  * @example {{{
  *                                                                                                                           atom0 = Atom()        // create a nullary Atom
  *                                                                                                                           atom2 = Atom[T1, T2]  // create a binary Atom whose instances accept (T1, T2) values
  *                                                                                                                           /* Likewise with Atom[T1] to Atom[T1, .. T22] */
  *          }}}
  */
object Atom {
  /** Creates a nullary atom ([[fr.emn.criojosc.Atom0]]) */
  def apply() = new Atom0

  /** Creates an unary atom ([[fr.emn.criojosc.Atom1]]) with signature `T1` */
  def apply[T1] = new Atom1[T1]

  /** Creates a binary atom ([[fr.emn.criojosc.Atom2]]) with signature `T1`, `T2` */
  def apply[T1, T2] = new Atom2[T1, T2]
}
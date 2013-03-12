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

trait Term {
  def patterns: List[Pattern[Any]]

  def symbol: EntitySymbol
}

/** A symbolic representation of an [[fr.emn.criojosc.Relation]], as used in rule premises and "where" guards.<br />
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
class AtomPattern(val symbol: Relation, val patterns: List[Pattern[Any]]) extends Term

/** A symbolic representation of a [[fr.emn.criojosc.Message]]. !CURRENTLY A STUB! */
class MessagePattern(val channel: Channel, val patterns: List[Pattern[Any]]) extends Term {
  val symbol = Message
}

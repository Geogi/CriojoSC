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

package fr.emn.criojosc.model

trait OpenReactant {
  def pattern: Pattern[Any]

  def symbol: EntitySymbol

  def matching(cr: ClosedReactant, s: Valuation) =
    if (symbol != cr.symbol) (false, s)
    else pattern.matching(cr.value, s)

  def &(that: OpenReactant) = new Premise(List(this, that))
}

/** A symbolic representation of an [[TypedRelation]], as used in rule premises and "existence" guards.<br />
  * The engine matches it against the actual instances in [[EntitySymbol]] to produce a
  * [[model.Valuation]], used by most [[Guard]]s and
  * [[Rule]] conclusions.
  *
  * Note that while [[OpenAtom]] is not typed itself, it is created by
  * ([[TypedRelation.apply]] that is typed, ensuring a consistent state.<br />
  * This is why instances of this class should not be created manually, but using `Atom.apply`.
  *
  * @param symbol The Atom this particular representation refers to.
  * @param pattern The list of Patterns used by the matching process.
  */
class OpenAtom(val symbol: EntitySymbol, val pattern: Pattern[Any]) extends OpenReactant {
  override def toString = symbol.toString + "(" + pattern.toString + ")"
}

/** A symbolic representation of a Message. !CURRENTLY A STUB! */
class OpenMessage(val symbol: EntitySymbol, val info: ChannelInfo, val pattern: Pattern[Any]) extends OpenReactant
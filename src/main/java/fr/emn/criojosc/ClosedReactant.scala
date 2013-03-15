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

/** Something that exist in the [[fr.emn.criojosc.Solution]] or can be created by a [[fr.emn.criojosc.Rule]]. */
trait ClosedReactant {
  def value: Any

  def symbol: EntitySymbol
}

/** An instance of an [[fr.emn.criojosc.Relation]] in a given state (a list of patterns).<br />
  * It may exist in [[fr.emn.criojosc.Solution]] or be the product of a [[fr.emn.criojosc.Rule]]
  * (listed in its conclusion).
  *
  * Note that while [[fr.emn.criojosc.ClosedAtom]] is not typed itself, it is created by
  * a ([[fr.emn.criojosc.Relation]] `apply` method, that is typed, ensuring a consistent state.<br />
  * This is why instances of this class should not be created manually, but using `Relation.apply`.
  *
  * @param symbol The Atom this instance refers to.
  * @param value The value (Any) that defines the state of this instance.
  */
class ClosedAtom(val symbol: EntitySymbol, val value: Any) extends ClosedReactant

class ClosedMessage(val symbol: EntitySymbol, val info: ChannelInfo, val value: Any) extends ClosedReactant

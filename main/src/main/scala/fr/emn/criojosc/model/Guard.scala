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

/** Guards allow conditional triggering of Rules. !CURRENTLY A STUB!
  *
  * Their most useful feature is that they permit introspection of the EntitySymbol, allowing
  * tests that would not be possible only with the premise.<br />
  * For instance, `Abs(~A)` test if no ClosedAtom of A is present in the solution.
  */
trait Guard extends Printable {
  def unary_! = NotGuard(this)

  def &&(that: Guard) = AndGuard(this, that)
}













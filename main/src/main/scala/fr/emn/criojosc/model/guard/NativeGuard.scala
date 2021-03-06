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

package fr.emn.criojosc.model.guard

import fr.emn.criojosc.model.{Guard, Valuation}
import fr.emn.criojosc.model.output.OptExplicit

/** Guard whose truth value comes from a Scala boolean. !CURRENTLY A STUB!
  *
  * {{{
  *  !x >= !y
  * }}}
  *
  * @param test A Boolean to evaluate to.
  */
case class NativeGuard(test: Valuation => Boolean) extends Guard with OptExplicit {
  override val explicitAlt = "native"

  override def toString = explicitly

  override def printed = explicitly
}

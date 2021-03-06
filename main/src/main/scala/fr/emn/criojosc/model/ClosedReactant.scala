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

import fr.emn.criojosc.model.rule.Conclusion

/** Something that exist in the [[Solution]] or can be created by a [[Rule]]. */
trait ClosedReactant {
  def value: Any

  def symbol: RelationSymbol

  override def toString = symbol.toString + (value.toString match {
    case s if s.startsWith("(") && s.endsWith(")") => s
    case s => "(" + s + ")"
  })

  def &(that: ClosedReactant) = new Conclusion(List(this, that))
}

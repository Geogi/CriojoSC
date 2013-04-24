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
package automaton

import collection.mutable

trait PartialExecution {
  def valuation: Valuation
  def using: List[ClosedReactant]
  val children: mutable.Iterable[PartialExecution]
}

object PartialExecution {
  def apply(valuation: Valuation, using: List[ClosedReactant]) = new FullPartialExecution(valuation, using)
}

class FullPartialExecution(val valuation: Valuation, val using: List[ClosedReactant]) extends PartialExecution {
  val children = mutable.HashSet.empty[PartialExecution]
}

class DeltaPartialExecution(val valuation: Valuation, parent: Option[PartialExecution], added: ClosedReactant) extends PartialExecution {
  override lazy val using = parent.map { added :: _.using } getOrElse List(added)
  val children = mutable.HashSet.empty[PartialExecution]
}

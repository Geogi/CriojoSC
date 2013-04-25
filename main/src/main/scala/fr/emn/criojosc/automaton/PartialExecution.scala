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
  val children: mutable.Set[(State, PartialExecution)] = mutable.HashSet.empty[(State, PartialExecution)]
  def +(ns: Valuation, cr: ClosedReactant, state: State): PartialExecution = {
    val child = new DeltaPartialExecution(ns, Some(PartialExecution.this), cr)
    children += state -> child
    child
  }
}

object PartialExecution {
  def apply(valuation: Valuation, using: List[ClosedReactant]) = new FullPartialExecution(valuation, using)
  def apply(valuation: Valuation, parent: Option[PartialExecution], added: ClosedReactant) = new DeltaPartialExecution(valuation, parent, added)
  def apply() = EmptyExecution
}

class FullPartialExecution(val valuation: Valuation, val using: List[ClosedReactant]) extends PartialExecution

class DeltaPartialExecution(val valuation: Valuation, parent: Option[PartialExecution], added: ClosedReactant) extends PartialExecution {
  override lazy val using = parent.map { added :: _.using } getOrElse List(added)
}

object EmptyExecution extends PartialExecution {
  override val valuation = EmptyValuation
  override def using = Nil

  override def +(s: Valuation, cr: ClosedReactant, state: State) = PartialExecution(s, None, cr)
}

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

import fr.emn.criojosc.Variable

trait Valuation {
  val content: Map[Variable[Any], Any]
  def get(x: Variable[Any]) = content.get(x)
  def contains(x: Variable[Any]) = content.contains(x)
  def +(x: Variable[Any], v: Any): Valuation = Valuation(Some(Valuation.this), Map(x -> v))
  def ++(that: Valuation): Valuation = this ++ that.content
  def ++(that: Map[Variable[Any], Any]): Valuation = Valuation(Some(Valuation.this), that)

  override def toString = content.map{case (k, v) => k + "→" + v}.mkString(", ")
}

object Valuation {
  def apply(parent: Option[Valuation], delta: Map[Variable[Any], Any]) = DeltaValuation(parent, delta)
  def apply() = EmptyValuation
}





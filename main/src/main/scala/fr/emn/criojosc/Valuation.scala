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

trait Valuation {
  val content: Map[Variable[Any], Any]
  def get(x: Variable[Any]) = content.get(x)
  def +(x: Variable[Any], v: Any): Valuation = Valuation(Some(Valuation.this), x -> v)
}

object Valuation {
  def apply(parent: Option[Valuation], delta: (Variable[Any], Any)) = DeltaValuation(parent, delta)
  def apply() = EmptyValuation
}

case object EmptyValuation extends Valuation {
  override val content = Map.empty[Variable[Any], Any]

  override def +(x: Variable[Any], v: Any) = Valuation(None, x -> v)
}

case class FullValuation(content: Map[Variable[Any], Any] = Map.empty[Variable[Any], Any]) extends Valuation

case class DeltaValuation(parent: Option[Valuation], delta: (Variable[Any], Any)) extends Valuation {
  override lazy val content = parent map { _.content + delta } getOrElse Map(delta)
}

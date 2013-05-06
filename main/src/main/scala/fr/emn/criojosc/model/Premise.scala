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

class Premise(val reactants: List[OpenReactant]) {
  override def toString = reactants.mkString(" & ")

  def &(that: OpenReactant) = new Premise(reactants :+ that)

  def -->(that: () => Conclusion) = new Rule {
    def conclusion(implicit s: Valuation) = that()

    val premise = new Premise(reactants)
    val guard = TrueGuard
  }

  def -->(that: Guard) = new ControlGuard {
    val premise = new Premise(reactants)
    val guard = that
  }

  def -->(that: (Valuation) => Boolean) = new ControlGuard {
    val premise = new Premise(reactants)
    val guard = NativeGuard({implicit s: Valuation => that(s)})
  }
}

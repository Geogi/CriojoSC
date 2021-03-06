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

import fr.emn.criojosc.model._
import fr.emn.criojosc.model.rule.{Conclusion, NoConclusion}

/** `true` if the premise match and, given the updated Valuation, the sub-guard is `true` !CURRENTLY A STUB! */
trait ControlGuard extends Rule with Guard {
  override def conclusion(s: Valuation) = NoConclusion

  override lazy val printed = premise.reactants.mkString(" & ") + " → " + guard.toString

  def ?(that: Valuation => Conclusion) = {
    val oldPremise = premise
    val oldGuard = guard
    new Rule {
      def conclusion(s: Valuation) = that(s)

      val premise = oldPremise
      val guard = oldGuard
    }
  }
}

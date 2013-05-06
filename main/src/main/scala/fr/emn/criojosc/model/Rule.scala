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

trait Rule extends RuleImplicits with OptNamedPrintedFallback with OptExplicit {
  val premise: Premise

  val guard: Guard

  def conclusion(implicit s: Valuation): Conclusion

  lazy val printed = premise.reactants.mkString(" & ") + " → " + guard.printed + " ? " + explicitly

  override val explicitAlt = "conclusion"
}

trait RuleImplicits {
  import language.implicitConversions

  implicit def const[T](v: T) = new Const(v)
}

object RuleImplicits extends RuleImplicits

class Conclusion(val content: List[ClosedReactant]) {
  def &(that: ClosedReactant) = new Conclusion(content :+ that)
}

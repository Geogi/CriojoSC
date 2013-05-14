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

case class NotGuard(sub: Guard) extends Guard {
  override def printed = "¬(" + sub.printed + ")"

  override def toString = printed
}

case object TrueGuard extends Guard {
  override def printed = "true"

  override def toString = printed
}

case class AndGuard(left: Guard, right: Guard) extends Guard {
  override def printed = "(" + left.printed + " ∧ " + right.printed + ")"

  override def toString = printed
}

/** Guard whose truth value comes from a Scala boolean. !CURRENTLY A STUB!
  *
  * {{{
  *  !x >= !y
  * }}}
  *
  * @param test A Boolean to evaluate to.
  */
case class NativeGuard(test: () => Boolean) extends Guard with OptExplicit {
  override val explicitAlt = "native"

  override def toString = explicitly

  override def printed = explicitly
}

/** `true` if the premise match and, given the updated Valuation, the sub-guard is `true` !CURRENTLY A STUB! */
trait ControlGuard extends Rule with Guard {
  override def conclusion() = NoConclusion

  override lazy val printed = premise.reactants.mkString(" & ") + " → " + guard.toString

  def ?(that: () => Conclusion) = {
    val oldPremise = premise
    val oldGuard = guard
    new Rule {
      def conclusion() = that()

      val premise = oldPremise
      val guard = oldGuard
    }
  }
}

case object NoConclusion extends Conclusion(Nil)

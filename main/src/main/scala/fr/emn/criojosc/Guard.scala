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

/** Guards allow conditional triggering of [[fr.emn.criojosc.Rule]]s. !CURRENTLY A STUB!
  *
  * Their most useful feature is that they permit introspection of the [[fr.emn.criojosc.EntitySymbol]], allowing
  * tests that would not be possible only with the premise.<br />
  * For instance, `Abs(~A)` test if no [[fr.emn.criojosc.ClosedAtom]] of A is present in the solution.
  */
trait Guard {
  /** Truth of this guard. Will probably be changed when guards are implemented with state machines. !CURRENTLY A STUB! */
  def evaluate(implicit s: Valuation): Boolean

  def unary_! = NotGuard(this)

  def &&(that: Guard) = AndGuard(this, that)
}

case class NotGuard(sub: Guard) extends Guard {
  def evaluate(implicit s: Valuation) = !sub.evaluate
}

case class AndGuard(left: Guard, right: Guard) extends Guard {
  def evaluate(implicit s: Valuation) = left.evaluate && right.evaluate
}

/** Guard whose truth value comes from a Scala boolean. !CURRENTLY A STUB!
  *
  * {{{
  *  !x >= !y
  * }}}
  *
  * @param test A Boolean to evaluate to.
  */
case class NativeGuard(test: (Valuation) => Boolean) extends Guard {
  def evaluate(implicit s: Valuation) = test(s)
}

/** `true` if the premise match and, given the updated [[fr.emn.criojosc.Valuation]], the sub-guard is `true` !CURRENTLY A STUB! */
trait ControlGuard extends Rule with Guard {
  def guard(implicit s: Valuation): Guard

  override def evaluate(implicit s: Valuation) = right_hand._1.evaluate

  override def right_hand(implicit s: Valuation) = (guard, NoConclusion)
}

case object NoConclusion extends Conclusion(Nil)

object Guard {
  import language.implicitConversions

  implicit def bool2Guard(bool: Boolean) = new NativeGuard(Function.const[Boolean, Valuation](bool))
}

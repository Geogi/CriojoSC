/*
 * Copyright (c) 2013 Paul Blouët.
 *
 * This file is part of criojo-min.
 *
 * criojo-min is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * criojo-min is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with criojo-min.  If not, see <http://www.gnu.org/licenses/>.
 */

package fr.emn.criojosc

/** Guards allow conditional triggering of [[fr.emn.criojosc.Rule]]s. !CURRENTLY A STUB!
  *
  * Their most useful feature is that they permit introspection of the [[fr.emn.criojosc.EntitySymbol]], allowing
  * tests that would not be possible only with the premise.<br />
  * For instance, `Abs(~A)` test if no [[fr.emn.criojosc.AtomInstance]] of A is present in the solution.
  */
trait Guard {
  /** Truth of this guard. Will probably be changed when guards are implemented with state machines. !CURRENTLY A STUB! */
  def evaluate: Boolean
}

/** A guard that always evaluate to `true`. It is the default. !CURRENTLY A STUB! */
case object TrueGuard extends Guard {
  def evaluate = true
}

/** A guard that always evaluate to `false`. !CURRENTLY A STUB! */
case object FalseGuard extends Guard {
  def evaluate = false
}

/** && guard (using a [[fr.emn.criojosc.Guard]] method is probably preferable) !CURRENTLY A STUB! */
case class AndGuard(left: Guard, right: Guard) extends Guard {
  def evaluate = left.evaluate && right.evaluate
}

/** && guard (using a [[fr.emn.criojosc.Guard]] method is probably preferable) !CURRENTLY A STUB! */
case class OrGuard(left: Guard, right: Guard) extends Guard {
  def evaluate = left.evaluate || right.evaluate
}

/** `true` if the premise match and, given the updated [[fr.emn.criojosc.Valuation]], the sub-guard is `true` !CURRENTLY A STUB! */
case class WhereGuard(premise: Premise, guard: Guard) extends Guard {
  def evaluate = throw new NotImplementedError
}

/** Guard whose truth value comes from a Scala boolean. !CURRENTLY A STUB!
  *
  * @example {{{
  *                                                               !x >= !y
  *          }}}
  *
  * @param evaluate A Boolean to evaluate to.
  */
case class NativeGuard(evaluate: Boolean) extends Guard

/** The parent trait of all guards that require special handling by the [[fr.emn.criojosc.EntitySymbol]] (inspectors). !CURRENTLY A STUB! */
trait IntrospectionGuard extends Guard
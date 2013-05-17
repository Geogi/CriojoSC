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

import org.specs2._
import fr.emn.criojosc.Variable

class GuardSpec extends Specification { def is =
  "Guard specification."                                                                 ^
                                                                                         p^
  "Native guards are Scala expressions that, given a valuation, evaluate to a Boolean."  ! nativeGuard^
  "There is an implicit conversion from a boolean to a native guard, using a dummy " +
    "valuation to force the abstraction."                                                ! implicitGuard^
                                                                                         p^
  "Unary construct: !negated"                                                            ! notGuard^
  "Binary constructs:"                                                                   ^
    "left && right"                                                                      ! andGuard^
                                                                                         endp^
  "Control guards act as a pseudo-rules, and evaluate against the solution. " +
    "They're stubs for now"                                                              ! pending^
                                                                                         end
  def nativeGuard = {
    val x = new Variable[Int]
    implicit val sx = Valuation(None, Map(x -> 1))
    pending
  }

  val dummyValuation = Valuation()

  def implicitGuard = {
    val implicitly: Guard = NativeGuard((s: Valuation) => false)
    pending
  }

  val trueGuard: Guard = NativeGuard((s: Valuation) => true)
  val falseGuard: Guard = NativeGuard((s: Valuation) => false)

  def notGuard = pending

  def andGuard = pending
}

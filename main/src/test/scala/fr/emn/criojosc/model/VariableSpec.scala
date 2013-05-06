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

class VariableSpec extends Specification { def is =
  "Variable specification."                                   ^
                                                              p^
  "A variable is nothing but a name."                         ^
    "x == x, x != y"                                          ! testSymbol^
                                                              p^
  "A valuation is needed to store the value of the variable"  ^
    "store (x, 3) in s, test !x == 3"                         ! testValuation^
                                                              p^
  "If the variable is free, it's bound to the proposed value" ! bindTest^
                                                              end

  def testSymbol = {
    val (x, y) = (new Variable[Int], new Variable[Int])
    (x === x) and (x !== y)
  }

  def testValuation = {
    val x = new Variable[Int]
    val s1 = Valuation()
    val s2 = s1 + (x, 3)
    x.unary_!(s2) === 3
  }

  def bindTest = {
    val s = Valuation()
    val x = new Variable[String]
    val (r1, s1) = x.matching("something", s)
    val (r3, _) = x.matching("something else", s1)
    (r1 must beTrue) and (s1 !== s) and      // matches because free and the valuation is updated
      (r3 must beFalse)                      // doesn't match with other value
  }
}

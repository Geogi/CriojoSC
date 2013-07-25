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

package fr.emn.criojosc.model.pattern

import org.specs2._
import fr.emn.criojosc.S
import fr.emn.criojosc.model.rule.RuleImplicits
import fr.emn.criojosc.model.{Pattern, Valuation}

class SuccessorSpec extends Specification with RuleImplicits { def is =

  "Specification of the Successor[Int] constructor."               ^
                                                                   p^
  "Inside the left hand:"                                          ^
    "Create a pattern with the companion object's '?' method..."   ! { Successor ? (1) must bePatternInt } ^
    "... or with the shortcut 'S?'."                               ! { S ? (1) must bePatternInt } ^
    "It returns no match if the proposed value is not an Int..."   ! returnsNoMatch("a") ^
    "... or if the value is zero or less."                         ! returnsNoMatch(0) ^
    "Otherwise it chains the matching with the value decremented"  ^
    "e.g. S?(1) matches only 2"                                    ! { S1Match(2) and !S1Match(3) } ^
                                                                   endp ^
  "Inside the right hand:"                                         ^
    "Create an Int term by applying the companion object or 'S'."  ! isIntInsideRight ^
    "It will be the successor of the parameter: S(1) = 2."         ! { S(1) === 2 }

  val s = Valuation()

  def bePatternInt = beAnInstanceOf[Pattern[Int]]

  def returnsNoMatch(x: Any) = (S ? (1)).matching(x, s)._1 must beFalse

  def S1Match(i: Int) = (S ? (1)).matching(i, s)._1

  def isIntInsideRight = (Successor(1) must beLike {
    case _: Int => ok
  }) and (S(1) must beLike {
    case _: Int => ok
  })
}

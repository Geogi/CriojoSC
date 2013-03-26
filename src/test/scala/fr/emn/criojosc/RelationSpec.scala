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

import org.specs2._

class RelationSpec extends Specification { def is =
  "Relation specification."                         ^
                                                    p^
  "Creating a new relation with its companion"      ^
    "Unary"                                         ! createRelation1^
    "Ternary"                                       ! createRelation3^
                                                    p^
  "The ? method creates an OpenAtom"                ^
    "Unary"                                         ! instantiateOpenAtom1^
    "Ternary"                                       ! instantiateOpenAtom3^
                                                    p^
  "The apply method creates a ClosedAtom"           ^
    "Unary"                                         ! instantiateClosedAtom1^
    "Ternary"                                       ! instantiateClosedAtom3^
                                                    end

  import RuleImplicits.const

  val R1 = Relation[Int]
  val R3 = Relation[Char, String, Int]

  def createRelation1 =  R1 must beAnInstanceOf[TypedRelation[Int]]
  def createRelation3 = R3 must beAnInstanceOf[TypedRelation3[Char, String, Int]]

  def instantiateOpenAtom1 = R1?(1) must beAnInstanceOf[OpenReactant]
  def instantiateOpenAtom3 = R3?('a', "a", 0) must beAnInstanceOf[OpenReactant]

  def instantiateClosedAtom1 = R1(1) must beAnInstanceOf[ClosedReactant]
  def instantiateClosedAtom3 = R3('a', "a", 0) must beAnInstanceOf[ClosedReactant]
}

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

class TuplePatternSpec extends Specification { def is =
  "Tuple pattern specification."                                                      ^
                                                                                      p^
  "Tuple patterns are used by n-ary relations (n > 1)."                               ^
  see(new RelationSpec)                                                               ^
                                                                                      p^
  "Tuple patterns match element by element, and return false on the first failure."   ^
    "While its members match, the updated valuation is passed along"                  ^ bt^
    "(1, \"a\", 0 :: 'b' :: Nip) vs. (1, \"a\", 0 :: 'b' :: Nil) true"                ! testTuple3_1 ^
    "(1, \"a\", 0 :: 'b' :: Nip) vs. (1, \"a\", 0 :: 'c' :: Nil) true"                ! testTuple3_2 ^
                                                                                      end

  import RuleImplicits.const

  val s = new Valuation

  val tuple3 = new Tuple3Pattern[Int, String, List[AnyVal]]((1, "a", 0 :: 'b' :: Nip))
  def testTuple3_1 = tuple3.matching((1, "a", 0 :: 'b' :: Nil), s)._1 must beTrue
  def testTuple3_2 = tuple3.matching((1, "a", 0 :: 'c' :: Nil), s)._1 must beFalse
}

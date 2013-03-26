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

class ListPatternSpec extends Specification { def is =

  "List pattern specification."                                           ^
                                                                          p^
  "Creating a list pattern with the :: cons"                              ! consTest^
  "This pattern is covariant in List[+T]"                                 ! covTest^
                                                                          p^
  "It matches as a functional list," +
    " i.e. it tries to match its head, and matches its tail on success"   ^
  "Nip matches Nil"                                                       ! nipTest^
  "A single const object matches itself"                                  ! singletonTest^
  "It works recursively on many objects"                                  ! matchTest^
                                                                          end


  import RuleImplicits.const

  val s = new Valuation

  def consTest = (0 :: 1 :: 2 :: Nip) must beAnInstanceOf[Pattern[List[Int]]]

  def covTest = {
    class A
    class B extends A
    val (a, b) = (new A, new B)
    ((b :: Nip) must beAnInstanceOf[Pattern[List[B]]]) and
      ((a :: b :: Nip) must beAnInstanceOf[Pattern[List[A]]]) and
      ((1 :: b :: Nip) must beAnInstanceOf[Pattern[List[Any]]])
  }

  def nipTest = Nip.matching(Nil, s)._1 must beTrue
  def singletonTest = ("a" :: Nip).matching("a" :: Nil, s)._1 must beTrue
  def matchTest = (0 :: "a" :: Nip).matching(0 :: "a" :: Nil, s)._1 must beTrue
}

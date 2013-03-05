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

package fr.paulblouet.criojomin

trait Pattern {
  type T

  def get: T

  def set(s: Valuation, mod: (T) => T = x => x, x: T)
}

trait PredefPatterns {

  // utility
  @throws[ClassCastException]("recursive pattern mismatch")
  trait RecursivePattern[A] extends Pattern with Retype {
    override type T = A
    val child: Pattern

    def set_recursion(v: A): A

    def get_recursion(v: A): A

    override def set(s: Valuation, mod: (T) => T, v: T) {
      try {
        child.set(s, compose1[T, child.T, A](mod, set_recursion), v.asInstanceOf[child.T])
      } catch {
        case _: ClassCastException => throw new ClassCastException("recursive pattern type mismatch")
      }
    }

    override def get = try {
      get_recursion(child.get.asInstanceOf[A])
    } catch {
      case _: ClassCastException => throw new ClassCastException("recursive pattern type mismatch")
    }
  }

  // types
  class Const[A](override val get: A) extends Pattern {
    override type T = A

    override def set(s: Valuation, mod: (T) => T, x: T) {}
  }

  // implicits

  import scala.language.implicitConversions

  implicit def intPattern(i: Int) = new Const[Int](i)

  // functional patterns
  def S(this_child: Pattern) = new RecursivePattern[Int] {
    override val child = this_child

    override def set_recursion(i: Int) = i - 1

    override def get_recursion(i: Int) = i + 1
  }
}

sealed trait Retype {
  def retype1[AF, RF, AI, RI](f: (AI) => RI): (AF => RF) = (a => f(a.asInstanceOf[AI]).asInstanceOf[RF])

  def compose1[A, B, R](f: (A) => A, g: (R) => R) = retype1[B, B, A, A](f) compose retype1[B, B, R, R](g)
}
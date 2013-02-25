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

/**
 * User: pblout
 * Date: 20/02/13
 * Time: 13:51
 */

class Rule(val premise: Term, val guard: Option[Guard], val conclusion: Term) {
}

class Guard(val value: Any, val conclusion: Term) {
}

trait Term {
  val tail: Option[Term]
  def &(that: Term): Term
  def ?:(guard: Any) = new Guard(guard, this)
  def ->(guard: Guard) = new Rule(this, Some(guard), guard.conclusion)
  def ->(conclusion: Term) = new Rule(this, None, conclusion)
}

class Relation(val state: Seq[Any] = Seq(), val tail: Option[Term] = None) extends Term {
  def &(that: Term): Term = tail match {
    case Some(t) => new Relation(state, Some(t & that))
    case None => new Relation(state, Some(that))
  }
  def apply(values: Any*) = new Relation(values, tail)
}

class Variable {
}

class Valuation(map: Option[Map[Variable, Any]] = None) {
  @throws[NoSuchFieldException]("valuation is not ready")
  @throws[NoSuchElementException]("variable is unknown to the valuation")
  @throws[ClassCastException]("variable cannot be appraised using the selected type")
  def apply[T](v: Variable): T = {
    map match {
      case Some(m) => m.get(v) match {
        case Some(x) => x match {
          case x: T => x
          case _ => throw new ClassCastException
        }
        case None => throw new NoSuchElementException
      }
      case None => throw new NoSuchFieldException
    }
  }
}

object Test extends App {
  val R = new Relation
  val i = new Variable
  val s = new Valuation
  val r: Rule = (R(s[Int](i) + 1) & R(1) & R(2)) -> (-1) ?: (R(3) & R(4) & R(5))
}

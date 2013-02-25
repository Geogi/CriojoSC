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

import java.util.UUID

/**
 * User: pblout
 * Date: 20/02/13
 * Time: 13:51
 */

class Rule(val premise: ((Valuation, Variable) => Seq[Relation]), val guard: ((Valuation, Variable) => Boolean),
           val conclusion: ((Valuation, Variable) => Seq[Relation]))

class Relation(id: String = UUID.randomUUID.toString, val state: Option[Any] = None) {
  def apply(values: Any) = new Relation(id, Some(values))

  override def toString = "R[" + id.toString.substring(0, 4) + "](" + state.get + ")"
}

class Variable(id: String = UUID.randomUUID.toString)

class Valuation(map: Option[Map[Variable, Any]] = None) {
  @throws[NoSuchFieldException]("valuation is not ready")
  @throws[NoSuchElementException]("variable is unknown to the valuation")
  @throws[ClassCastException]("variable cannot be appraised using the selected type")
  def apply[T](v: Variable): T = {
    map match {
      case Some(m) => m.get(v) match {
        case Some(x) => x match {
          case x: T@unchecked => x
          case _ => throw new ClassCastException
        }
        case None => throw new NoSuchElementException
      }
      case None => throw new NoSuchFieldException
    }
  }
}

class Agent(rules: Seq[Rule], state: Seq[Relation] = Seq()) {
  state match {
    case relation :: tail => relation.state match {
      case Some(v) =>
        val x = new Variable
        val s = new Valuation(Some(Map((x, v))))
        rules.foreach {
          rule =>
            (rule.premise(s, x).forall(t => state.contains(t)) && rule.guard(s, x)) match {
              case true => new Agent(rules, rule.conclusion(s, x))
              case _ =>
            }
        }
      case None =>
    }
    new Agent(rules, tail)
    case _ =>
  }

  override def toString = state.mkString(", ")
}

object Test extends App {
  val R = new Relation

  def pre(s: Valuation, i: Variable) = Seq(R(i), R(s[Int](i) + 1))

  def gar(s: Valuation, i: Variable) = s[Int](i) < 10

  def con(s: Valuation, i: Variable) = Seq(R(s[Int](i) + 1), R(s[Int](i) + 2))

  val r = new Rule(pre, gar, con)
  val agent = new Agent(Seq(r), Seq(R(0), R(1)))
  println(agent)
}

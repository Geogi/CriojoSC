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

trait Guard {
  def evaluate: Boolean
}

case object TrueGuard extends Guard {
  def evaluate = true
}

case object FalseGuard extends Guard {
  def evaluate = false
}

case class AndGuard(left: Guard, right: Guard) extends Guard {
  def evaluate = left.evaluate && right.evaluate
}

case class OrGuard(left: Guard, right: Guard) extends Guard {
  def evaluate = left.evaluate || right.evaluate
}

case class WhereGuard(premise: Rule#Premise, guard: Guard) extends Guard {
  def evaluate = throw new NotImplementedError
}

case class NativeGuard(evaluate: Boolean) extends Guard

trait IntrospectionGuard extends Guard
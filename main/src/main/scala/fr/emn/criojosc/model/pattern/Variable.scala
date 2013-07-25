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

import fr.emn.criojosc.model.{Valuation, Pattern}
import fr.emn.criojosc.model.output.OptNamed

class Variable[+T] extends Pattern[T] with OptNamed {
  def matching[S >: T](proposed: S, s: Valuation) = if (s.contains(this)) (false, s) else (true, s + (this, proposed))

  def unary_!(implicit s: Valuation): T = (s.get(this) getOrElse
    (throw new NoSuchElementException("Unbound variable"))).asInstanceOf[T]

  def apply(s: Valuation): T = unary_!(s)
}

object Variable {
  def apply[T] = new Variable[T]
  def apply[T](s: String) = new Variable[T] {
    override val optName = Some(s)
  }
  def multi[T](ss: String*) = ss.map(apply[T](_))
}

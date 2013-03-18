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

class Variable[+T] extends Pattern[T] {
  def matching[S >: T](proposed: S, s: Valuation) = s.get(this) match {
    case Some(real) => (proposed == real, s)
    case None => (true, new Valuation(s +(this, proposed)))
  }

  def unary_!(implicit s: Valuation): T = (s.get(this) getOrElse
    (throw new NoSuchElementException("Unbound variable"))).asInstanceOf[T]
}

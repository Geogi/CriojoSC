/*
 * Copyright (c) 2013 Paul Blouët.
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

import collection.mutable

class Valuation(val contents: mutable.HashMap[Variable[Any], Any] = mutable.HashMap.empty[Variable[Any], Any]) {

  @throws[NoSuchElementException]("access attempt on unset variable")
  def apply(x: Variable[Any]) = contents(x) match {
    case Some(v) => v
    case None => throw new NoSuchElementException("trying to access unbound variable")
  }

  def +=(x: Variable[Any], v: Any) {
    contents(x) = v
  }

  override def clone() = new Valuation(contents.clone())
}

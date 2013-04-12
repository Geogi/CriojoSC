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

package fr.emn.criojosc.macros.utils

import reflect.macros.Context

object Resugar {
  def resugar(c: Context)(t: c.Tree): c.Tree = {
    // compose any re-sugaring below
    val nt = listCons(c)(t)
    if (t == nt)
      nt
    else
      resugar(c)(nt)
  }

  private def listCons(c: Context)(t: c.Tree): c.Tree = {
    t
  }
}

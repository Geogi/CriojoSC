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

package fr.emn.criojosc.model

import org.specs2._
import fr.emn.criojosc.model.pattern.Variable

class ValuationSpec extends Specification { def is =
  "Valuation specification."                        ^
                                                    p^
  "Valuations are usually made implicit."           ^
    "implicitly !x = 3"                             ! implicitTest^
                                                    end

  def implicitTest = {
    val x = new Variable[Int]
    implicit val s = Valuation(None, Map(x -> 3))
    !x === 3
  }
}

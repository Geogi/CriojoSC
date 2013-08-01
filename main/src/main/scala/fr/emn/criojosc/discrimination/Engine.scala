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

package fr.emn.criojosc.discrimination

import fr.emn.criojosc.model.{Agent, Engine => ModelEngine}

/** Discrimination engine
  *
  * Phase 1: supports only rules without control guards.
  * Works only on the first agent.
  **/
class Engine(val agents: List[Agent]) extends ModelEngine {
  val agent = agents.head.getOrElse(sys.error("P1: needs an agent"))

  def run() {
    step && run()
  }

  def step: Boolean = {

  }
}

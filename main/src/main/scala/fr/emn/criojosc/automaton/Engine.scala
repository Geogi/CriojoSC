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
package automaton

class Engine(val agents: Iterable[Agent]) extends fr.emn.criojosc.Engine {
  val automatons = agents.map(a => (a, a.rules.map(r => new Automaton(r.premise)))).toMap

  def run() {
    init()

  }

  private def init() = {
    automatons.foreach { case (agent, autos) =>
      val updated_states = autos.map { auto =>
        (auto, agent.solution.content.map{ cr =>
          auto.propose(cr)
        })
      }.toMap
      val completed_states = ???
    }
  }

  private def step():Boolean = ???
}

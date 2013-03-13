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

class Solution(val agent: Agent) {
  val content = mutable.HashSet.empty[ClosedReactant]

  def +=(reactant: ClosedReactant) {
    content += reactant
    val completed_states = agent.rules map (rule => (rule, rule.premise += reactant))
    // dummy choice algorithm beginning
    val selected: Option[(Rule, State)] = completed_states filter (_._2.nonEmpty) match {
      case r :: _ => Some((r._1, r._2.head))
      case _ => None
    }
    // dummy choice algorithm end
    selected foreach {
      rule_state =>
        rule_state._2.right foreach (this -= _)
        rule_state._1.conclusion(rule_state._2.s).content foreach (this += _)
    }
  }

  def ++=(rs: Iterable[ClosedReactant]) {
    rs.foreach(this += _)
  }

  def -=(reactant: ClosedReactant) {
    content -= reactant
    agent.rules foreach (_.premise -= reactant)
  }
}

object Solution {
  def apply(agent: Agent, rs: ClosedReactant*) = {
    val sol = new Solution(agent)
    sol ++= rs
    sol
  }
}
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

package fr.emn.criojosc

import collection.mutable

class Solution(val agent: Agent) {
  val content = mutable.HashSet.empty[Instance]

  def +=(instance: Instance) {
    content += instance
    val complete_states = agent.rules map (rule => (rule, rule.premise addInstance instance))
    // dummy choice algorithm beginning
    val selected = complete_states filter (_._2.nonEmpty) match {
      case r :: _ => Some((r._1, r._2.head))
      case _ => None
    }
    // dummy choice algorithm end
    selected foreach {
      rule_state =>
        rule_state._2.right foreach (this -= _)
        rule_state._1.conclusion(rule_state._2.s) foreach (this += _)
    }
  }

  def ++=(is: Iterable[Instance]) {
    is.foreach(this += _)
  }

  def -=(instance: Instance) {
    agent.rules foreach (_.premise.removeInstance(instance))
  }
}

object Solution {
  def apply(agent: Agent, is: Instance*) = {
    val sol = new Solution(agent)
    sol ++= is
    sol
  }
}
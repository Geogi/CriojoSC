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

package fr.emn.criojosc.automaton.internal

import collection.mutable
import fr.emn.criojosc.model.{Rule, OpenReactant, Guard, ClosedReactant}
import fr.emn.criojosc.automaton.internal.pexec.PartialExecution
import fr.emn.criojosc.automaton.internal.PartialExecution

class Automaton(val rule: Rule) {
  val isGuard = rule.isInstanceOf[Guard]
  private val premise = rule.premise
  private def gen_states(ors: List[OpenReactant] = premise.reactants.toList): List[State] = ors match {
    case x :: xs => gen_states(xs).flatMap(s => List(s + x, s - x))
    case _ => List(State(Map.empty[OpenReactant, Boolean]))
  }
  val states: Map[State, mutable.Set[PartialExecution]] =
    gen_states().map(_ -> mutable.Set.empty[PartialExecution]).toMap

  val initialState = State(premise.reactants.toList.map((_, false)).toMap)
  private val finalState = State(premise.reactants.toList.map((_, true)).toMap)
  states(initialState) += PartialExecution()

  private val ancestors = new mutable.HashMap[ClosedReactant, mutable.Set[(State, PartialExecution)]]
    with mutable.MultiMap[ClosedReactant, (State, PartialExecution)]

  def propose(cr: ClosedReactant) {
    val new_states: List[(State, PartialExecution)] = states.toList.flatMap { case (state, pes) =>
      state.has.collect {
        case (or, present) if !present && cr.symbol == or.symbol =>
          pes.map {
            pe => (or.matching(cr, pe.valuation), pe)
          }.collect {
            case ((matched, valuation), pe) if matched =>
              val newState = state + or
              val binding = (newState, (pe + (valuation, cr, newState)))
              ancestors.addBinding(cr, binding)
              binding
          }
      }.flatten
    }
    new_states.foreach {
      case (k, v) => states(k) += v
    }
  }

  def getCompleted = states(finalState).map(this -> _)

  def execute(pe: PartialExecution): Iterable[ClosedReactant] = rule.conclusion(pe.valuation).content

  def purge(crs: Iterable[ClosedReactant]) {
    def purgePE(binding: (State, PartialExecution)) {
      val (state, pe) = binding
      pe.children.foreach(purgePE(_))
      states(state) -= pe
    }
    // for all input CRs
    crs.foreach(cr =>
      // if defined in ancestors, drop it and purge from states
      ancestors.remove(cr).foreach(_.foreach(purgePE(_)))
    )
  }
}

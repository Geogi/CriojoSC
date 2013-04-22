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

import collection.mutable
import akka.actor.Actor

class Automaton(premise: Premise) extends Actor {
  private val index = premise.reactants.toVector
  private val symbols = premise.reactants.map(_.symbol).toSet
  val states = new mutable.HashMap[State, mutable.Set[AssociatedValuation]] with mutable.MultiMap[State, AssociatedValuation]

  private val bottomValuation = Valuation()
  private val initialState = State(Array.fill(index.size)(false))
  states.addBinding(initialState) = (bottomValuation, Set.empty[ClosedReactant])

  private val resolvedSymbols = new mutable.HashMap[EntitySymbol, mutable.Set[(Int, State)]] with mutable.MultiMap[EntitySymbol, (Int, State)]
  index.zipWithIndex.foreach { case (or, i) =>
    resolvedSymbols.addBinding(or.symbol, (i, State(Array.fill(index.size)(false))))
  }

  def receive = {
    case Propose(cr) =>
      if (!symbols.contains(cr.symbol)) sender ! NotInterested(cr.symbol)
      else {
        resolvedSymbols(cr.symbol).foreach { case (i, state) =>
          val toUpdate = states(state).map { case (s, crs) => (index(i).matching(cr, s), crs + cr) }.filter(_._1._1).map(o => (o._1._2, o._2))
          val newState = state.add(i)
          toUpdate.foreach { av =>
            states.addBinding(newState, av)
          }
          if (!newState.complete) newState.lacking.foreach(i => resolvedSymbols.addBinding(index(i).symbol, (i, newState))
          else toUpdate.foreach(sender ! Completed(_))
        }
      }
    case _ =>
  }
}

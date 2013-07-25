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

import model._
import guard._
import internal.Automaton

class Engine(val agents: List[Agent]) extends model.Engine {
  protected val automatons = agents.map(a => a -> a.rules.flatMap(recurAuto(_)())).toMap
  protected val unprocessed = agents.map(a => a -> a.solution.content.to[mutable.ListBuffer]).toMap

  private val automatonsByRule = automatons.flatMap {
    case (_, as) => as.map(a => a.rule -> a)
  }.toMap

  private def recurAuto(parent: Rule)(guards: List[Guard] = List(parent.guard)): List[Automaton] = guards match {
    case x :: xs => x match {
      case TrueGuard => recurAuto(parent)(xs)
      case AndGuard(left, right) => recurAuto(parent)(left :: right :: xs)
      case NotGuard(guard) => recurAuto(parent)(guard :: xs)
      case NativeGuard(test) => recurAuto(parent)(xs)
      case guard: ControlGuard => recurAuto(guard)() ::: recurAuto(parent)(xs)
    }
    case _ => List(new Automaton(parent))
  }

  def run() {
    if (step()) run()
  }

  protected def evaluateGuard(guard: Guard, valuation: Valuation): Boolean = guard match {
    case TrueGuard => true
    case AndGuard(left, right) => evaluateGuard(left, valuation) && evaluateGuard(right, valuation)
    case NotGuard(subGuard) => !evaluateGuard(subGuard, valuation)
    case NativeGuard(test) => test(valuation)
    case subGuard: ControlGuard => automatonsByRule(subGuard).getCompleted.exists {
      case (_, pe) => evaluateGuard(subGuard.guard, valuation ++ pe.valuation)
    }
  }

  protected def step(): Boolean = agents.map { agent =>
    // proposes closed atoms, get completed executions (filter guards) whose guards are verified
    automatons(agent).foreach(a => unprocessed(agent).foreach(a.propose(_)))
    // get completed executions (filter guards) whose guards are verified
    val complete = automatons(agent).flatMap(_.getCompleted).filter {
      case (automaton, pe) => !automaton.rule.isInstanceOf[ControlGuard] && evaluateGuard(automaton.rule.guard, pe.valuation)
    }
    // clears the unprocessed reactants list
    unprocessed(agent).clear()
    // takes the first choice, if any
    val chosen = complete.headOption
    // if defined, applies the valuation to the conclusion of the rule
    // and adds the products to the unprocessed reactant list
    chosen.map { case (a, pe) => a.execute(pe) }.map(unprocessed(agent) ++= _)
    // if defined, destroys the PEs that use the same CRs
    chosen.foreach { case (a, pe) => automatons(agent).foreach(_.purge(pe.using)) }
    // returns true if defined
    chosen.isDefined
  }.contains(true)
}

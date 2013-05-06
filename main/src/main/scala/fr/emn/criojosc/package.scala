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

package fr.emn

/** CriojoSC is an implementation of CRIOJO, a CHAM-based engine for running concurrent applications with guaranteed causal order.<br />
  * It sounds cool, but it's far from complete at the moment.
  *
  * CriojoSC uses Scala and is GPL licenced.
  *
  * Some useful resources:
  * <ul>
  * <li>The mainline implementation by Mayleen Lacouture: [[https://github.com/maylencita/CRIOJO/tree/version2.0 maylencita/CRIOJO@GitHub]]</li>
  * <li>The latest CRIOJO research paper: [[http://hal.inria.fr/hal-00676083/]]</li>
  * </ul>
  */

package object criojosc {
  val Nip = model.NilPatternList
  val S = model.Successor

  def engine(agents: model.Agent*) = new automaton.VerboseEngine(agents.toList)

  def agent(args: Either[model.Rule, model.ClosedReactant]*) = new model.Agent {
    val solution = new model.Solution(args.filter(_.isRight).map(_.right.get).toSet)
    val rules = args.filter(_.isLeft).map(_.left.get)
  }

  import language.implicitConversions
  implicit def rule2left(ru: model.Rule) = Left(ru)
  implicit def cr2right(cr: model.ClosedReactant) = Right(cr)
}

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

package fr.emn.criojosc.experimental

import fr.emn.criojosc._
import language.experimental.macros
import reflect.macros.Context

object PrettyPrinter {
  def printerVariables(r: Rule): Rule = macro printerVariablesImpl

  def printerVariablesImpl(c: Context)(r: c.Expr[Rule]): c.Expr[Rule] = {
    import c.universe._
    c.Expr[Rule](Block())
  }

  def print(engine: Engine): String = engine.agents flatMap {
    a =>
      a.rules map {
        r =>
          a.toString + ": " + r.premise.reactants.map(_.toString).mkString(" & ") +
            " --> "
      }
  } mkString ("\n")
}

case object DummyValuation extends Valuation

class PrinterVariable(id: String, `type`: String) extends Variable[Unit] {
  override def matching[S >: Nothing](p: S, s: Valuation) = (true, s)

  override def unary_!(implicit s: Valuation) {

  }
}

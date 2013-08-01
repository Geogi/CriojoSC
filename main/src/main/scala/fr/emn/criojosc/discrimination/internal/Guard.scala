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

package fr.emn.criojosc.discrimination.internal

import fr.emn.criojosc.model.ClosedReactant
import fr.emn.criojosc.model.pattern.Variable

/** parts are pairwise disjoint */
class Guard(val context: List[Environment], val partition: List[Part], val controls: List[ControlGuard])
class Environment(val parent: Guard, val valuations: List[Valuation])
class Valuation(val parent: Environment, val identity: Binder, val interpretation: Set[Binding])
class Binder(val name: String, val domain: List[Variable[Any]])
//class Binding(val parent: Valuation, val values: Map[Variable[Any], Any], val using: ClosedReactant)
/** all bound variables belong to the last environment in the context except maybe the first one */
class Part(val parent: Guard, val equivalenceClass: List[BoundVariable])
class BoundVariable(val parent: Part, val sigma: Binder, val variable: Variable[Any])
class ControlGuard(val parent: Guard, val context: List[Environment], val extension: Environment, guard: Guard)

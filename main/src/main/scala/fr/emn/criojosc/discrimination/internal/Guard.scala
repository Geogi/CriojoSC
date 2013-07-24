package fr.emn.criojosc.discrimination.internal

/** parts are pairwise disjoint */
class Guard(val context: List[Environment], val partition: List[Part], val controls: List[ControlGuard]) {
class Environment(val parent: Guard, val valuations: List[Valuation])
class Valuation(val parent: Environment, val identity: Binder, val interpretation: Set[Binding])
class Binder(val name: String, val domain: List[Variable[Any]])
class Binding(val parent: Valuation, val values: Map[Variable[Any], Any], val using: ClosedReactant)
/** all bound variables belong to the last environment in the context except maybe the first one */
class Part(val parent: Guard, val equivalenceClass: List[BoundVariable]) {
class BoundVariable(val parent: Part, val sigma: Binder, val variable: Variable[Any])
class ControlGuard(val parent: Guard, val context: List[Environment], val extension: Environment, guard: Guard)


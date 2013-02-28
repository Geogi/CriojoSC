package fr.paulblouet.criojomin

/*
If we have (x, y, z): R(x, y + 1) & S(y) --> T(z) | z < y ? R(x, y) & S(y)
We want to rewrite it as:
(x: Var[Any], y: Var[Int], z: Var[Int]) => (R(x, {what?}
*/
trait Rule {
  val arity: Int
  val premise: Premise
  val guard: Guard

  //val conclusion: Iterable

  trait Premise

  trait Guard

}

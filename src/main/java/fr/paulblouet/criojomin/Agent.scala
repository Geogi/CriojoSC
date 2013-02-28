package fr.paulblouet.criojomin

trait Agent {
  val channels: Iterable[Channel]
  val relations: Iterable[Relation]
  val rules: Iterable[Rule]
  val solution: Solution
}

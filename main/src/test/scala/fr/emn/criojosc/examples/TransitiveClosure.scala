package fr.emn.criojosc
package examples

import fr.emn.criojosc.model.{Guard, Valuation, Agent, Rule}
import fr.emn.criojosc.model.guard.{ControlGuard, NativeGuard}
import fr.emn.criojosc.model.rule.{Solution, Premise, Conclusion}
import fr.emn.criojosc.model.pattern.Variable
import fr.emn.criojosc.model.relation.Relation

object TransitiveClosure {
  val agent = new Agent {
    override val optName = Some("TransitiveClosure")

    lazy val R = Relation[String, String]("R")
    lazy val Rs = Relation[String, String]("R+")
    val solution = new Solution(Set(R("A", "B"), R("B", "C"), R("C", "A")))
    val rules = Seq(
      new Rule {
        override val optName = Some("Init")
        lazy val (x, y) = (Variable[String]("x"), Variable[String]("y"))

        def conclusion(sa: Valuation) = {
          implicit val s = sa
          new Conclusion(List(Rs(!x, !y), R(!x, !y)))
        }
        override val explicitVal = Some("R+(x, y) & R(x, y)")

        val premise = new Premise(List(R?(x, y)))
        val guard = ! new ControlGuard {
          override val optName = Some("Init — no duplicate")
          lazy val (u, v) = (Variable[String]("u"), Variable[String]("v"))
          val premise = new Premise(List(Rs?(u, v)))
          val guard = (x === u) && (y === v)
        }
      },
      new Rule {
        override val optName = Some("Extend")
        lazy val (x, y, u, v) = (Variable[String]("x"), Variable[String]("y"), Variable[String]("u"), Variable[String]("v"))
        def conclusion(sa: Valuation) = {
          implicit val s = sa
          new Conclusion(List(Rs(!x, !v), Rs(!u, !v), Rs(!x, !y)))
        }
        override val explicitVal = Some("R+(x, v) & R+(y, v) & R+(x, y)")

        val premise = new Premise(List(Rs?(x, y), Rs?(u, v)))
        val guard: Guard = (y === u) && ! new ControlGuard {
          override val optName = Some("Extend — no duplicate")
          lazy val (i, j) = (Variable[String]("i"), Variable[String]("j"))
          val premise = new Premise(List(Rs?(i, j)))
          val guard = (i === x) && (j === v)
        }
      }
    )
  }
}

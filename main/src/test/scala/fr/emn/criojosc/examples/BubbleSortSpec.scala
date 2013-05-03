package fr.emn.criojosc
package examples

import org.specs2._

class BubbleSortSpec extends Specification { def is =
  "Test CriojoSC with the transitive closure algorithm"         ^
    p^
    automatonOut                                                  ^
    end

  lazy val transitiveClosure = new Agent {
    override val name = Some("TransitiveClosure")

    lazy val R = Relation[String, String]("R")
    lazy val Rs = Relation[String, String]("R+")
    val solution = new Solution(Set(R("A", "B"), R("B", "C"), R("C", "A")))
    val rules = Seq(
      new Rule {
        override val name = Some("Init")
        lazy val (x, y) = (Variable[String]("x"), Variable[String]("y"))
        def conclusion(implicit s: Valuation) = new Conclusion(List(Rs(!x, !y), R(!x, !y)))
        override val explicitVal = Some("R+(x, y) & R(x, y)")

        val premise = new Premise(List(R?(x, y)))
        val guard = ! new ControlGuard {
          override val name = Some("Init — no duplicate")
          lazy val (u, v) = (Variable[String]("u"), Variable[String]("v"))
          val premise = new Premise(List(Rs?(u, v)))
          val guard = new NativeGuard({implicit s: Valuation => !x == !u && !y == !v}) {
            override val explicitVal = Some("x == u && y == v")
          }
        }
      },
      new Rule {
        override val name = Some("Extend")
        lazy val (x, y, u, v) = (Variable[String]("x"), Variable[String]("y"), Variable[String]("u"), Variable[String]("v"))
        def conclusion(implicit s: Valuation) = new Conclusion(List(Rs(!x, !v), Rs(!u, !v), Rs(!x, !y)))
        override val explicitVal = Some("R+(x, v) & R+(y, v) & R+(x, y)")

        val premise = new Premise(List(Rs?(x, y), Rs?(u, v)))
        val guard: Guard = new NativeGuard({implicit s: Valuation => !y == !u}) {
          override val explicitVal = Some("y == u")
        } && ! new ControlGuard {
          override val name = Some("Extend — no duplicate")
          lazy val (i, j) = (Variable[String]("i"), Variable[String]("j"))
          val premise = new Premise(List(Rs?(i, j)))
          val guard = new NativeGuard({implicit s: Valuation => !i == !x && !j == !v}) {
            override val explicitVal = Some("i == x && j == v")
          }
        }
      }
    )
  }
  lazy val engine = new VerboseEngine(List(transitiveClosure))
  engine.MAX_ITS = Some(15)

  lazy val automatonOut = {
    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) {
      engine.run()
    }
    val output = stream.toString
    stream.close()
    output
  }
}

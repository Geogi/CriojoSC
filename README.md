CriojoSC
==========

CriojoSC is an implementation of CRIOJO, a CHAM-based engine for running concurrent applications with guaranteed causal order. It sounds cool, but it's far from complete at the moment.

CriojoSC uses [Scala](http://www.scala-lang.org/) and is [GPL](http://www.gnu.org/licenses/gpl.html) licenced.

Some useful resources:
* The mainline implementation by Mayleen Lacouture: [maylencita/CRIOJO](https://github.com/maylencita/CRIOJO/tree/version2.0)
* The latest CRIOJO research paper: http://hal.inria.fr/hal-00676083/

Building
--------
1. Install the following dependencies: [Git](http://git-scm.com/), [SBT](http://www.scala-sbt.org/). On Linux, get them from your distro repositories.
2. Clone from GitHub: `$ git clone https://github.com/Geogi/criojomin.git`.
3. Run the code generator then compile CriojoSC: `$ sbt sbt ";project generate; run; project main; compile"`.  
   The .class files will be located at `target/${scalaVersion}/classes/`.
4. If you want the JAR: `$ sbt package`. It will be located at `target/`.

Generating the API
------------------
Do the first two steps above then `$ sbt doc`. The API will be located at `target/${scalaVersion}/api/index.html`.

The [Specs2](http://etorreborre.github.com/specs2/) specification can be generated with `$ sbt test`. It will be located at `target/specs2-reports/index.html`.

Using
-----
It's really unstable and partially unimplemented, so writing a tutorial at this point isn't sensible.

Refer to the API documentation if needed.

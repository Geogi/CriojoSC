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
2. Clone from GitHub: `$ git clone https://github.com/Geogi/CriojoSC.git`.
3. Run the code generator then compile CriojoSC: `$ sbt "criojosc-generate/run" compile`.
   The .class files will be located at `target/${scalaVersion}/classes/`.
4. If you want the JAR: `$ sbt package`. It will be located at `target/`.

If you get a lot of memory related exceptions when running SBT, run the following and retry (in the same console):
`export SBT_OPTS="-Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=384M"`

Generating the API
------------------
Build the project then `$ sbt doc`. The API will be located at `target/${scalaVersion}/api/index.html`.

The [Specs2](http://etorreborre.github.com/specs2/) specification can be generated with `$ sbt test`. It will be located at `target/specs2-reports/index.html`.

Using
-----
It's really unstable and partially unimplemented, so writing a tutorial at this point isn't sensible.

Refer to the API documentation if needed.

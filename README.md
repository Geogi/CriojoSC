Criojo-Min
==========

Criojo-Min is an implementation of CRIOJO, a CHAM-based engine for running concurrent applications with guaranteed causal order. It sounds cool, but it's far from complete at the moment.
Criojo-Min uses [Scala](http://www.scala-lang.org/) and is [GPL](http://www.gnu.org/licenses/gpl.html) licenced.

Some useful resources:
* The mainline implementation by Mayleen Lacouture: maylencita/CRIOJO@fe2be8414ad2b501b62271d986e1173ea999a4ab
* The latest CRIOJO research paper: http://hal.inria.fr/hal-00676083/

Building
--------
1. Install the following dependencies: [Git](http://git-scm.com/), [Maven](http://maven.apache.org/). On Linux, get them from your distro repositories.
2. Clone from GitHub: `$ git clone https://github.com/Geogi/criojomin.git`
3. Compile Criojo-Min: `$ mvn compile`. The .class files will be located at `target/fr/paulblouet/criojomin/`
4. If you want the JAR: `$ mvn package`. It will be located at `target/`

Generating the API
------------------
Do the first two steps above then `$ mvn site`. The API will be located at `target/site/scaladocs/index.html`.

Using
-----
It's really unstable and partially unimplemented, so writing a tutorial at this point isn't sensible.
Refer to the API documentation if needed.
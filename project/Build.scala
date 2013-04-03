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

import sbt._
import Keys._

object CriojoSCBuild extends Build {
  lazy val main = Project("main", file("main")) dependsOn(generate, macros, common)
  lazy val common = Project("common", file("common"))
  lazy val macros = Project("macros", file("macros")) dependsOn(common) settings(
    libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _)
    )
  lazy val generate = Project("generate", file("generate")) settings(
    libraryDependencies += ("org.fusesource.scalate" % "scalate-core_2.10" % "1.6.1")
    )
}

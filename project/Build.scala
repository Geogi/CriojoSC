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

object CriojoSCBuild extends Build {
  lazy val root = Project("criojosc-root", file(".")) aggregate(main, macros, common)
  lazy val main = Project("criojosc-main", file("main")) dependsOn(macros, common)
  lazy val macros = Project("criojosc-macros", file("macros")) dependsOn(common)
  lazy val common = Project("criojosc-common", file("common"))
  lazy val generate = Project("criojosc-generate", file("generate"))
}

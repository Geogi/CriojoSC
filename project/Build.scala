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
  lazy val root = Project("criojosc-root", file(".")) aggregate(main) settings (
    mappings in (Compile, packageBin) <++= mappings in (main, Compile, packageBin),
    mappings in (Compile, packageSrc) <++= mappings in (main, Compile, packageSrc)
    )
  lazy val main = Project("criojosc-main", file("main"))
  lazy val generate = Project("criojosc-generate", file("generate"))
}

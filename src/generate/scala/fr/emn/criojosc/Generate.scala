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

package fr.emn.criojosc

import java.io.{PrintWriter, FileFilter, File}
import org.fusesource.scalate._

object Generate {
  val engine = new TemplateEngine
  val templateFilter = new FileFilter {
    def accept(p1: File): Boolean = p1.isDirectory || p1.getName.endsWith(".ssp")
  }
  val srcDir = new File(System.getProperty("user.dir"), "src")
  val srcDirS = srcDir.getPath

  def printWriter(f: File) = new PrintWriter(srcDirS + f.getPath.replaceFirst(srcDirS, "").
    replaceFirst("generate", "main").replaceFirst(".ssp$", ".gen.scala"))

  def recurGetTemplates(f: File): Array[File] = {
    val files = f.listFiles(templateFilter)
    files.filter(_.isFile) ++ files.filter(_.isDirectory).flatMap(recurGetTemplates)
  }

  def main(args: Array[String]) {
    recurGetTemplates(srcDir).foreach {
      f =>
        engine.layout(f.getPath, printWriter(f), Map.empty[String, Any])
    }
  }
}

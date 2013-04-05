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
  lazy val main = Project("main", file(".")) dependsOn(macros, common) settings(
    mappings in (Compile, packageBin) <++= mappings in (common, Compile, packageBin),
    mappings in (Compile, packageSrc) <++= mappings in (common, Compile, packageSrc),
    mappings in (Compile, packageBin) <++= mappings in (macros, Compile, packageBin),
    mappings in (Compile, packageSrc) <++= mappings in (macros, Compile, packageSrc)
    )
  lazy val common = Project("common", file("common"))
  lazy val macros = Project("macros", file("macros")) dependsOn(common)
  lazy val generator = TaskKey[Generate]("generator")
}

class Generate(val classpath: Classpath) {
  import java.io.{IOException, PrintWriter, FileFilter, File}
  import java.nio.file.Files
  import org.fusesource.scalate.TemplateEngine

  private val engine = new TemplateEngine
  engine.escapeMarkup = false
  engine.classpath = classpath.map(_.data).map(f =>
    if(f.isFile)
      f.getPath
    else
      f.getPath + File.separator + "*"
  ).mkString(File.pathSeparator)

  private val templateFilter = new FileFilter {
    def accept(p1: File): Boolean = p1.isDirectory || p1.getName.endsWith(".ssp")
  }

  private val srcDir = new File(System.getProperty("user.dir"))

  private def recurGetTemplates(f: File): Array[File] = {
    val files = f.listFiles(templateFilter)
    files.filter(_.isFile) ++ files.filter(_.isDirectory).flatMap(recurGetTemplates)
  }

  def generateSources(outDir: File): Seq[File] = {
    println(engine.classpath)
    if (!outDir.exists)
      Files.createDirectories(outDir.toPath)
    recurGetTemplates(srcDir).map { f =>
      val generated = new File(outDir, f.getName.replaceFirst(".ssp$", ".scala"))
      val writer = new PrintWriter(generated)
      engine.layout(f.getPath, writer, Map.empty[String, Any])
      val error = writer.checkError
      writer.close()
      if (error)
        throw new IOException("error during template writing")
      generated
    }
  }
}

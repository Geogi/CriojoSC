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

import org.specs2._
import main.Arguments
import runner.SpecificationsFinder._
import java.util.regex.{Matcher, Pattern => JavaPattern}
import specification.SpecificationStructure

class index extends Specification {
  def is = "index".title ^ specifications().map(link)

  def specifications(path: String = "**/*.scala",
                     pattern: String = ".*Spec",
                     filter: String => Boolean = { (name: String) => true },
                     basePath: String = "src/test/scala",
                     verbose: Boolean = false)
                    (implicit args: Arguments = Arguments()): Seq[SpecificationStructure] = {
    specificationNames(path, pattern, basePath, verbose).view.filter(filter).
      flatMap(n => createSpecification(n, verbose))
  }

  def specificationNames(path: String = "**/*.scala",
                         pattern: String = ".*Spec",
                         basePath: String = "src/test/scala",
                         verbose: Boolean = false) : Seq[String] = {
    lazy val specClassPattern = {
      val p = specPattern("class", pattern)
      if (verbose) println("\nthe pattern used to match specification classes is: "+p+"\n")
      JavaPattern.compile(p)
    }
    lazy val specObjectPattern = {
      val p = specPattern("object", pattern)
      if (verbose) println("\nthe pattern used to match specification objects is: "+p+"\n")
      JavaPattern.compile(p)
    }
    filePaths(basePath, path, verbose) filter (_.endsWith(".scala")) flatMap { p =>
      val fileContent = readFile(p)
      val packName = packageName(fileContent)
      val (objectPattern, classPattern) = (specObjectPattern, specClassPattern)
      if (verbose) println("\nSearching for specifications in file: "+p)
      classNames(packName, fileContent, objectPattern, "$", verbose) ++ classNames(packName, fileContent, classPattern, "", verbose)
    }
  }

  def classNames(packageName: String, content: String, pattern: JavaPattern, suffix: String, verbose: Boolean = false): Seq[String] = {
    val CLASSNAME_REGEX = """([\p{L}_$][\p{L}\p{N}_$]*\.)*[\p{L}_$][\p{L}\p{N}_$]*""".r
    def result(m: Matcher): Stream[String] =
      if (m.find) {
        val fullName = List(packageName, m.group(1).trim).mkString(".") + suffix
        Stream.cons(fullName, result(m))
      } else Stream.empty

    val found = result(pattern.matcher(content)).toList
    if (verbose && found.nonEmpty) println("found the following classes: "+found.mkString(", "))
    found.filter(c => CLASSNAME_REGEX.pattern.matcher(c).matches)
  }

  def packageName(content: String): String = {
    def result(m: Matcher): Stream[String] =
      if (m.find) Stream.cons(m.group(1).replace(";", "").trim, result(m))
      else Stream.empty

    val pattern = "\\s*package\\s*(.+)\\s*"

    // extract the packages section at the beginning of the file
    val packages = content.split("\n").filter(_.trim.startsWith("package")).mkString("\n")
    result(JavaPattern.compile(pattern).matcher(packages)).mkString(".")
  }
}

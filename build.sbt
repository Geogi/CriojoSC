name := "CriojoSC"

version in ThisBuild := "0.2-SNAPSHOT"

scalaVersion in ThisBuild := "2.10.1"

libraryDependencies += ("org.specs2" %% "specs2" % "1.14" % "test")

generator <<= (dependencyClasspath in Compile) map (new Generate(_))

sourceGenerators in Compile <+= (generator, sourceManaged in Compile) map (_.generateSources(_))

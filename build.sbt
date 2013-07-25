name := "CriojoSC"

version in ThisBuild := "2.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.10.2"

libraryDependencies in ThisBuild ++= Seq("org.specs2" %% "specs2" % "2.1.1" % "test",
                                         "org.pegdown" % "pegdown" % "1.4.0" % "test")

scalacOptions += "-Yrangepos"

testOptions in Test in ThisBuild += Tests.Argument("html", "console")

name := "CriojoSC"

version in ThisBuild := "0.2-SNAPSHOT"

scalaVersion in ThisBuild := "2.10.1"

libraryDependencies ++= Seq("org.specs2" %% "specs2" % "1.14" % "test",
                            "org.pegdown" % "pegdown" % "1.2.1" % "test")

testOptions in Test += Tests.Argument("html")

javaOptions in ThisBuild += "-Xmx4096m"

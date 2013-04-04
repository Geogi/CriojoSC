name := "CriojoSC code generator"

libraryDependencies ++= Seq("org.fusesource.scalate" %% "scalate-core" % "1.6.1",
                            "org.slf4j" % "slf4j-simple" % "1.7.5")

generateSources := (Run.run("Generate", Nil, Nil, ConsoleLogger())) dependsOn(compile)

packageBin <<= packageBin dependsOn(generateCode)

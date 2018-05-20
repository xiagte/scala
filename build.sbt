name := "scala"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.quartz-scheduler" % "quartz" % "2.3.0",

  "com.h2database" % "h2" % "1.4.195",// % Test,

  "log4j" % "log4j" % "1.2.17",

  "com.typesafe" % "config" % "1.3.1",

  "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test
)

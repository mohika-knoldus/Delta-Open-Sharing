ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "Delta Open Sharing"
  )

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.5.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.5.0"
libraryDependencies += "io.delta" %% "delta-sharing-spark" % "1.0.2"
libraryDependencies += "io.delta" %% "delta-sharing-client" % "1.0.2"



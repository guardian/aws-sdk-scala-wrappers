organization := "com.gu"

name := "aws-sdk-scala-wrapper"

scalaVersion := "2.11.2"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "com.amazonaws" % "aws-java-sdk" % "1.8.9.1"
)

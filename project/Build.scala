import sbt._
import Keys._
import Dependencies._

object AwsSdkScalaWrapperBuild extends Build {
  val baseSettings = Seq(
    organization := "com.gu",
    scalaVersion := "2.11.2",
    libraryDependencies += awsJavaSdk
  )

  val generator = Project(
    id = "code-generation",
    base = file("code-generation"),
    settings = baseSettings ++ Seq(
      name := "aws-sdk-scala-wrapper-macro",
      libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
    )
  )

  val instances = Project(
    id = "instances",
    base = file("instances"),
    settings = baseSettings ++ Seq(
      name := "aws-sdk-scala-wrapper"
    )
  ).dependsOn(generator)

  val main = Project("root", base = file(".")).aggregate(
    generator,
    instances
  )
}

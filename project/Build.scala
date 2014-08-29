import sbt._
import Keys._
import Dependencies._
import sbtrelease.ReleasePlugin._
import sbtrelease._
import ReleaseStateTransformations._
import xerial.sbt.Sonatype._
import com.typesafe.sbt.pgp._

object AwsSdkScalaWrapperBuild extends Build {
  val baseSettings = Seq(
    organization := "com.gu",
    scalaVersion := "2.11.2",
    libraryDependencies ++= Seq(
      awsJavaSdk,
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      compilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)
    ),
    autoCompilerPlugins := true
  )

  val publishSettings = releaseSettings ++ sonatypeSettings ++ Seq(
    scmInfo := Some(ScmInfo(
      url("https://github.com/guardian/aws-sdk-scala-wrappers"),
      "scm:git:git@github.com:guardian/aws-sdk-scala-wrappers.git"
    )),
    pomExtra := (
      <url>https://github.com/guardian/aws-sdk-scala-wrappers</url>
        <developers>
          <developer>
            <id>robertberry</id>
            <name>Robert Berry</name>
            <url>https://github.com/robertberry</url>
          </developer>
        </developers>
    ),
    licenses := Seq(
      "Apache V2" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")
    ),
    ReleaseKeys.releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runTest.copy(enableCrossBuild = false),
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      ReleaseStep(
        action = state => Project.extract(state).runTask(PgpKeys.publishSigned, state)._1
      ),
      setNextVersion,
      commitNextVersion,
      ReleaseStep(state => Project.extract(state).runTask(SonatypeKeys.sonatypeReleaseAll, state)._1),
      pushChanges
    )
  )

  val generator = Project(
    id = "code-generation",
    base = file("code-generation"),
    settings = baseSettings ++ Seq(
      name := "aws-sdk-scala-wrappers-macro"
    )
  )

  val instances = Project(
    id = "instances",
    base = file("instances"),
    settings = baseSettings ++ Seq(
      name := "aws-sdk-scala-wrappers"
    ) ++ publishSettings
  ).dependsOn(generator)

  val main = Project("root", base = file(".")).aggregate(
    generator,
    instances
  )
}

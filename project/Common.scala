import sbt._
import sbt.Keys._

import com.sksamuel.scapegoat.sbt.ScapegoatSbtPlugin.autoImport._
import scoverage.ScoverageKeys._

import Dependencies._

object Common {

  val commonSettings = Seq(
    organization := "net.archwill.aufwachen",

    scalaVersion := "2.12.3",
    crossScalaVersions := Seq("2.12.3", "2.11.11"),

    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % scalaTestVersion,
      "org.mockito" % "mockito-core" % mockitoVersion
    ).map(_ % "test"),

    libraryDependencies ++= Seq(
      compilerPlugin("org.psywerx.hairyfotr" %% "linter" % linterVersion)
    ),

    javacOptions ++= Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-source", "1.8",
      "-target", "1.8",
      "-Xlint"
    ),

    scalacOptions ++= Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-feature",
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions",
      "-target:jvm-1.8",
      "-unchecked",
      "-Xfatal-warnings",
      "-Xfuture",
      "-Xlint",
      "-Yno-adapted-args",
      "-Ypartial-unification",
      "-Ywarn-dead-code",
      "-Ywarn-numeric-widen",
      "-Ywarn-unused-import"
    ),

    // Disable fatal warnings for targets where it makes no sense
    scalacOptions in (Compile, console) ~= (_ filterNot (_ == "-Xfatal-warnings")),
    scalacOptions in (Test, console) ~= (_ filterNot (_ == "-Xfatal-warnings")),
    scalacOptions in Scapegoat ~= (_ filterNot (_ == "-Xfatal-warnings")),

    fork in run := true,
    fork in Test := true,
    logBuffered in Test := false,

    autoAPIMappings := true,

    scapegoatVersion := "1.3.3"
  )

}

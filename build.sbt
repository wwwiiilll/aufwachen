import Common._
import Dependencies._

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "auf"
  )
  .dependsOn(core)
  .aggregate(core)

lazy val core = (project in file("./auf-core"))
  .settings(commonSettings)
  .settings(
    name := "auf-core"
  )

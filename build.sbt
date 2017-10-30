import Common._
import Dependencies._

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "auf"
  )
  .dependsOn(core)
  .aggregate(core, scalaz)

lazy val core = (project in file("./auf-core"))
  .settings(commonSettings)
  .settings(
    name := "auf-core"
  )

lazy val scalaz = (project in file("./auf-scalaz"))
  .settings(commonSettings)
  .settings(
    name := "auf-scalaz"
  )
  .dependsOn(core)
  .aggregate(core)

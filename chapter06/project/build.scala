import sbt._
import Keys._

import org.scalatra.sbt._
import com.earldouglas.xwp.JettyPlugin

object Chapter06Build extends Build {

  val Organization = "org.scalatra"
  val Name = "file-upload"
  val Version = "0.1.0-SNAPSHOT"
  val ScalaVersion = "2.11.6"
  val ScalatraVersion = "2.4.0"

  lazy val project = Project (
    Name,
    file("."),
    settings = Defaults.defaultConfigs ++ ScalatraPlugin.scalatraSettings ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      fork in Test := true,
      libraryDependencies ++= Seq(
        "org.scalatra" %% "scalatra" % ScalatraVersion,
        "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
        "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
        "ch.qos.logback" % "logback-classic" % "1.0.6" % "runtime",
        "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
      )
    )
  ).enablePlugins(JettyPlugin)

}

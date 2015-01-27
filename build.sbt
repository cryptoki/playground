name := "playground"

version := "1.0"

lazy val `playground` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( jdbc , anorm , cache , ws )

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.5",
  "org.joda" % "joda-convert" % "1.7",
  "org.scala-lang.modules" %% "scala-async" % "0.9.2",
  "com.typesafe.akka" %% "akka-actor" % "2.3.7"
)

resolvers += "Scalaz bintray" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.2",
  "org.mockito" % "mockito-core" % "1.10.8",
  "org.specs2" %% "specs2" % "2.4.11",
  "org.scalacheck" %% "scalacheck" % "1.11.6"
).map(_ % "test")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  
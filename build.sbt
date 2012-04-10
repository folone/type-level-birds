name := "TypeLevelBirds"

version := "1.0-SNAPSHOT"

organization := "info.folone"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "1.9" % "test"
)

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"  at "http://oss.sonatype.org/content/repositories/releases")

sbtPlugin := true

name := "sbt-pillar-plugin"

description := "sbt plugin for cassandra schema/data migrations using pillar (https://github.com/comeara/pillar)"

organization := "io.ino"

version := "1.0.5"

licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

scalaVersion := "2.10.4"

scalacOptions += "-target:jvm-1.7"

libraryDependencies ++= Seq(
  "com.chrisomeara" %% "pillar" % "2.1.0",
  "com.datastax.cassandra" % "cassandra-driver-core" % "3.0.0"
)

resolvers ++= Seq(
  "marcopriebe at bintray" at "https://dl.bintray.com/marcopriebe/maven/",
  "Typesafe repository:" at "http://repo.typesafe.com/typesafe/releases/"
)

// Maven publishing info
publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <url>https://github.com/inoio/sbt-pillar-plugin</url>
  <scm>
    <url>git@github.com:inoio/sbt-pillar-plugin.git</url>
    <connection>scm:git:git@github.com:inoio/sbt-pillar-plugin.git</connection>
  </scm>
  <developers>
    <developer>
      <id>martin.grotzke</id>
      <name>Martin Grotzke</name>
      <url>https://github.com/magro</url>
    </developer>
  </developers>)

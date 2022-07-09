import scoverage.ScoverageKeys

name := "gfc-semver"

organization := "org.gfccollective"

scalaVersion := "2.13.8"

crossScalaVersions := Seq(scalaVersion.value, "2.12.16")

scalacOptions += "-target:jvm-1.8"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.12" % Test,
)

ScoverageKeys.coverageMinimumStmtTotal := 77.0

ScoverageKeys.coverageFailOnMinimum := true

publishMavenStyle := true

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

homepage := Some(url("https://github.com/gfc-collective/gfc-semver"))

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

Test / publishArtifact := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>https://github.com/gfc-collective/gfc-semver.git</url>
    <connection>scm:git:git@github.com:gfc-collective/gfc-semver.git</connection>
  </scm>
  <developers>
    <developer>
      <id>stjohnb</id>
      <name>Brendan St John</name>
      <url>https://github.com/stjohnb</url>
    </developer>
  </developers>
)

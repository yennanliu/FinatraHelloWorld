name := "FinatraHelloWorld"

version := "1.0"

scalaVersion := "2.11.8"

lazy val versions = new {
  val finatra = "20.8.0"
  val logback = "1.1.7"
  val guice = "4.0"
}

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
"com.twitter" %% "finatra-http" % versions.finatra,
// testing
"com.twitter" %% "finatra-http" % "20.8.0" % "test" classifier "tests"
)

//mainClass := Some("server.BasicServer")

conflictManager := ConflictManager.latestRevision
name := "FinatraHelloWorld"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(

"com.twitter" %% "finatra-http" % "20.8.0",
// testing
"com.twitter" %% "finatra-http" % "20.8.0" % "test" classifier "tests"
)

//mainClass := Some("server.BasicServer")

conflictManager := ConflictManager.latestRevision
name := "FinatraHelloWorld"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(

"com.twitter" %% "finatra-http" % "20.8.0",
// logging
"com.twitter" %% "twitter-server-slf4j-log4j12" % "20.6.0",
// testing
"com.twitter" %% "finatra-http" % "20.8.0" % "test" classifier "tests"
)

//mainClass := Some("server.BasicServer")

conflictManager := ConflictManager.latestRevision
name := "hello-service"
version := "0.1.0"
scalaVersion := "2.12.4"

assemblyJarName in assembly := "app.jar"
mainClass in assembly := Some("mono.Main")

// Docker Section
import com.typesafe.sbt.packager.docker._
enablePlugins(DockerPlugin)

version in Docker := version.value

dockerCommands := Seq() // To clear out the built in commands
dockerCommands ++= Seq(
	Cmd("FROM", "bigtruedata/sbt:latest AS build"),
	Cmd("WORKDIR", "/app"),
	Cmd("COPY", ". ."),
	ExecCmd("CMD", "sbt", "assembly"),

	Cmd("FROM", "openjdk:8-alpine"),
	Cmd("WORKDIR", "/app"),
	Cmd("COPY", "--from=build /app/target/scala-2.12/app.jar ."),
	Cmd("EXPOSE", "8080"),
	ExecCmd("ENTRYPOINT", "java -jar /app/app.jar")
)


// Akka
val akkaVersion = "2.5.11"
val akkaDeps = Seq(
	"com.typesafe.akka" %% "akka-actor" % akkaVersion,
	"com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
	"com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test
)

libraryDependencies ++= akkaDeps

// HTTP
val akkaHttpVersion = "10.1.0"
val akkaHttpDeps = Seq(
	"com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
	"com.typesafe.akka" %% "akka-stream" % "2.5.11",
	"com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
	"com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test
)

libraryDependencies ++= akkaHttpDeps

// Database
val slickVersion = "3.2.2"
val slickDeps = Seq(
	"com.typesafe.slick" %% "slick" % slickVersion,
	"com.typesafe.slick" %% "slick-hikaricp" % slickVersion
)

libraryDependencies ++= slickDeps

// Logging
val slf4j = "org.slf4j" % "slf4j-api" % "1.6.4"
val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies ++= Seq(slf4j, logback)

// General Testing
val scalatest = "org.scalatest" %% "scalatest" % "3.0.5" % Test

libraryDependencies ++= Seq(scalatest)
name := "monorepo"
version := "0.1"
scalaVersion := "2.12.4"

// Akka
val akkaVersion = "2.5.11"
val akkaDeps = Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
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
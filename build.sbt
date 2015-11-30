name := "tlfd-acceptance-tests"

version := "0.0.1"

scalaVersion := "2.11.7"

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

val hmrcRepoHost = java.lang.System.getProperty("hmrc.repo.host", "https://nexus-preview.tax.service.gov.uk")

resolvers ++= Seq(
  "hmrc-snapshots" at hmrcRepoHost + "/content/repositories/hmrc-snapshots",
  "hmrc-releases" at hmrcRepoHost + "/content/repositories/hmrc-releases",
  "typesafe-releases" at hmrcRepoHost + "/content/repositories/typesafe-releases")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.github.detro.ghostdriver" % "phantomjsdriver" % "1.1.0",
  "org.seleniumhq.selenium" % "selenium-java" % "2.47.1",
  "org.seleniumhq.selenium" % "selenium-firefox-driver" % "2.47.1",
  "uk.gov.hmrc" % "secure-utils" % "4.0.0",
  "uk.gov.hmrc" %% "domain" % "2.1.0",
  "com.typesafe.play" %% "play-json" % "2.3.0",
  "org.scalatest" % "scalatest_2.11" % "2.2.1",
  "org.pegdown" % "pegdown" % "1.1.0" % "test",
  "org.scala-lang" % "scala-library" % "2.11.7",
  "info.cukes" % "cucumber-scala_2.11" % "1.1.8",
  "info.cukes" % "cucumber-junit" % "1.1.8",
  "info.cukes" % "cucumber-picocontainer" % "1.1.8",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test"
)

val scala3Version: String = "3.1.0"


val zioVersion = "1.0.10"


val zio = "dev.zio" % "zio_3" % zioVersion
val zioTest = "dev.zio" % "zio-test_3" % zioVersion % Test
val zioTestSbt = "dev.zio" % "zio-test-sbt_3" % zioVersion % Test
val quill = "io.getquill" % "quill-jdbc-zio_3" % "3.12.0.Beta1.7"
val sqliteJdbc = "org.xerial" % "sqlite-jdbc" % "3.36.0.3"

ThisBuild / testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

lazy val root = project
  .in(file("."))
  .settings(
    name := "dummy-proto-quill-use",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(zio, zioTest, zioTestSbt, quill, sqliteJdbc),
      excludeDependencies ++= Seq(
          ExclusionRule("com.lihaoyi", "pprint_2.13"),
          ExclusionRule("com.lihaoyi", "fansi_2.13"),
          ExclusionRule("com.lihaoyi", "sourcecode_2.13"),
      ),
    javaOptions += "-Dquill.binds.log=true",
    crossScalaVersions := Seq(scala3Version),
  )

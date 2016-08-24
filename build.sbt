name := "scala-playground"

version := "1.0"

scalaVersion := "2.11.8"

lazy val root = project.in(file(".")).aggregate(collections, testing)

lazy val collections = project

lazy val testing = project

lazy val classesTraits = project

lazy val iterableFunctions = project

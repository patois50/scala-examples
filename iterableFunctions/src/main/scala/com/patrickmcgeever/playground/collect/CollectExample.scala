package com.patrickmcgeever.playground.collect

import scala.util.{Try, Failure}

object CollectExample extends App {

  val someMap = Map(
    ("one", 1),
    ("two", 2),
    ("three", 3)
  )

  val someOtherMap = Map(
    ("one", 1)
  )

  // for each key in the map I want to execute a function which could result in an exception so
  // it is wrapped in a try

  // If any one of the functions resulted in a fail I want to return fail for any one of the failed functions
  // if they all succeed I want to return succeed

  // collect first finds the first value which the specified partial function is defined for
  // and returns an option containing the output of the partial function

  def theMainFunction(theMap: Map[String, Int]): String = {
    val result = theMap.map {
      case (k,v) => k -> someFunction(v)
    } collectFirst {
      case (name, Failure(th)) => Fail(name, th.getMessage)
    } getOrElse(TotalSuccess)
    result.toString
  }

  def someFunction(x: Int): Try[Unit] = Try {
    // Do something which could result in an exception
    x match {
      case x if(x < 1) => throw new Exception("I dont like numbers less than 1")
      case 2 => throw new Exception("I dont like 2")
      case x if(x > 2) => throw new Exception("I dont like numbers bigger than 2")
      case 1 => Unit
    }
  }

  println("For map containing 1,2,3 =>")
  println(theMainFunction(someMap))
  println("For map containing 1 =>")
  println(theMainFunction(someOtherMap))
}

case class Fail(name: String, reason: String) {
  override def toString: String = s"$name failed with reason: $reason"
}

object TotalSuccess {
  override def toString: String = "A success"
}

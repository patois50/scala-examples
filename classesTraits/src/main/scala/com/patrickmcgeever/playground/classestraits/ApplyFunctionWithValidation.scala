package com.patrickmcgeever.playground.classestraits

class ApplyFunctionWithValidation {

}

/**
 * We have a companion object with an apply function which returns an Either.
 * Either a list of exceptions representing the validations failures
 * or The feeder itself
 *
 * The feeder has had to be declared abstract because it already has an apply function.
 * The existing apply function is the one provided by scala since its a case class.
 *
 * We could have made this just a class but then we lose the goodness that comes with a case class
 * such as pattern matching.
 *
 */

object Feeder {

  def validate(value: String): List[RuntimeException] = {
    val regex = "^[A-Z]{2}-[a-z]{2}(:.+)?$".r
    List(if (regex.findFirstIn(value).isEmpty) Some(new RuntimeException("Feeder value does not match expected pattern AB-cd[:something]")) else None).flatten
  }

  def apply(value: String): Either[List[RuntimeException], Feeder] = {
    val exceptions = validate(value)
    if (exceptions.isEmpty)
      Right(new Feeder(value){}) /* intentionally empty implementation of the abstract class */
    else
      Left(exceptions)
  }
}

sealed abstract case class Feeder private(value: String)

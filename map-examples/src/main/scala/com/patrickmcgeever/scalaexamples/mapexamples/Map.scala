package com.patrickmcgeever.scalaexamples.mapexamples

object Map extends App {

  println("From:\nhttp://www.brunton-spall.co.uk/post/2011/12/02/map-map-and-flatmap-in-scala/")

  println

  val l = List(1,2,3,4,5)

  println("Original list")
  println(l)

  println

  println("List map function result")
  println(l.map(x => x*2))

  println

  println("Flat map takes a function which returns a sequence for every element in the list then returns a flattened " +
    "list...\nE.g. We define a function which takes a number and returns a list containing n-1, n, n+1 and pass this " +
    "function to flat spec on our original list.")
  def f(x: Int) = List(x-1, x, x+1)
  println(l.flatMap(f))

  println

  println("Options are also considered a sequence that is empty or contains an item")
  println("so if we have a function which returns an option if the number is gt 2 and pass that in to flatmap it will" +
    " flatten each option by only taking the number out of those which are not empty.")
  def g(x: Int) = if (x > 2) Some(x) else None
  val lo = l.flatMap(x => g(x))
  println(lo)
}

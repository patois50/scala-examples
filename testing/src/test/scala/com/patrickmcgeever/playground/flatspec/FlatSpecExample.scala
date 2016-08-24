package scala.com.patrickmcgeever.scalaexamples.testexamples.flatspec

import org.scalatest.FlatSpec

class FlatSpecExample extends FlatSpec {

  it should "test2" in {
    val obj = new SomeObject
    "val" == obj.testString
  }

  "another test" should "do something" in {
    "val" == "val"
  }

  it should "test3" in new SomeObject{
    "val" == testString
  }

  it should "test4" in new SomeObject{
    "val" == "val"
  }

  private class SomeObject {
    val testString = "val"
  }
}

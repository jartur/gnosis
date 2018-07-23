package works.merely.fpscala

import org.scalatest._

class CurrySpec extends FlatSpec with Matchers {
  "The `Curry#curry` function" should "curry a function" in {
    Curry.curry[Int, Int, Int](_ + _)(1)(2) shouldEqual 3
  }
}

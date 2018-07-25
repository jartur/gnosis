package works.merely.fpscala

import org.scalatest._

class UncurrySpec extends FlatSpec with Matchers {
  "The `Uncurry#uncurry` function" should "uncurry a function" in {
    Uncurry.uncurry[Int, Int, Int]{x => y => x + y}(1, 2) shouldEqual 3
  }
}

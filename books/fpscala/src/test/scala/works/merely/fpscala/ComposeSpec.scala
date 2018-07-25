package works.merely.fpscala

import org.scalatest._

class ComposeSpec extends FlatSpec with Matchers {
  "The `compose` function" should "compose two functions" in {
    Compose.compose({ x: String => x.length }, { x: Int => x.toString })(100) shouldEqual 3
  }
}

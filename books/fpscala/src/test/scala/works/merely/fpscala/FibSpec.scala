package works.merely.fpscala

import org.scalatest._

class FibSpec extends FlatSpec with Matchers {
  "The `Fib#fib` function" should "compute the nth Fibbonacci number" in {
    (0 to 10).map(Fib.fib) shouldEqual Seq(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
  }
}

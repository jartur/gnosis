package works.merely.fpscala

import org.scalatest._

class chapter2Spec extends FlatSpec with Matchers {
  "The `compose` function" should "compose two functions" in {
    chapter2.compose({ x: String => x.length }, { x: Int => x.toString })(100) shouldEqual 3
  }

  "The `fib` function" should "compute the nth Fibbonacci number" in {
    (0 to 10).map(chapter2.fib) shouldEqual Seq(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
  }

  "The `curry` function" should "curry a function" in {
    chapter2.curry[Int, Int, Int](_ + _)(1)(2) shouldEqual 3
  }

  "The `isSorted` function" should "return true for a sorted array" in {
    chapter2.isSorted[Int](Array(1, 2, 3, 4), {(x, y) => x <= y}) shouldBe true
  }

  "The `isSorted` function" should "return false for a unsorted array" in {
    chapter2.isSorted[Int](Array(1, 2, 3, 4), {(x, y) => x > y}) shouldBe false
  }

  "The `isSorted` function" should "work for arbitrary types" in {
    chapter2.isSorted[String](Array("1", "22", "333"), {(x, y) => x.length <= y.length}) shouldBe true
  }

  "The `uncurry` function" should "uncurry a function" in {
    chapter2.uncurry[Int, Int, Int]{x => y => x + y}(1, 2) shouldEqual 3
  }
}

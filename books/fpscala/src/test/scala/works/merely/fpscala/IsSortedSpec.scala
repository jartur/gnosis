package works.merely.fpscala

import org.scalatest._

class IsSortedSpec extends FlatSpec with Matchers {
  "The `IsSorted#isSorted` function" should "return true for a sorted array" in {
    IsSorted.isSorted[Int](Array(1, 2, 3, 4), {(x, y) => x <= y}) shouldBe true
  }

  "The `IsSorted#isSorted` function" should "return false for a unsorted array" in {
    IsSorted.isSorted[Int](Array(1, 2, 3, 4), {(x, y) => x > y}) shouldBe false
  }

  "The `IsSorted#isSorted` function" should "work for arbitrary types" in {
    IsSorted.isSorted[String](Array("1", "22", "333"), {(x, y) => x.length <= y.length}) shouldBe true
  }
}

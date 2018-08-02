package works.merely.fpscala

import org.scalatest.{FlatSpec, Matchers}

class chapter3Spec extends FlatSpec with Matchers {
  "tail" should "return the tail of a nonempty list" in {
    chapter3.tail(List(1, 2, 3)) should be (List(2, 3))
  }

  it should "return an empty list for an empty list" in {
    chapter3.tail(List()) should be (List())
  }

  "setHead" should "replace the first element in a nonempty list" in {
    chapter3.setHead(7)(List(1, 2, 3)) should be (List(7, 2, 3))
  }

  "drop" should "drop n elems from a list with at least n elements" in {
    chapter3.drop(2)(List(1, 2, 3)) should be (List(3))
  }

  "dropWhile" should "drop appropriate prefix" in {
    chapter3.dropWhile(List(-1, -2, 1, 2))(_ < 0) should be (List(1, 2))
  }

  "init" should "remove the last element in a nonempty list" in {
    chapter3.init(List(1, 2, 3)) should be (List(1, 2))
  }

  "length" should "calculate the length of a list" in {
    chapter3.length(List(1, 2, 3)) should be (3)
  }

  "foldLeft" should "fold a list" in {
    chapter3.foldLeft(List(1, 2, 3), 0)(_+_) should be (6)
    chapter3.foldLeft(List(1, 2, 3), List[Int]())((xs, x) => x :: xs) should be (List(3, 2, 1))
  }

  "foldLeftInFoldRight" should "behave like foldLeft" in {
    chapter3.foldLeftInFoldRight(List(1, 2, 3), List[Int]())((xs, x) => x :: xs) should be (List(3, 2, 1))
    chapter3.foldLeftInFoldRight2(List(1, 2, 3), List[Int]())((xs, x) => x :: xs) should be (List(3, 2, 1))
  }

  "foldRightInFoldLeft" should "behave like foldRight" in {
    chapter3.foldRightInFoldLeft(List(1, 2, 3), List[Int]())((x, xs) => x :: xs) should be (List(1, 2, 3))
  }
}

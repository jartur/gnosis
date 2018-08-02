package works.merely.fpscala

import scala.annotation.tailrec

object chapter3 {
  // 3.2
  def tail[A](xs: List[A]): List[A] = xs match {
    case Nil => Nil // or throw an exception
    case x :: tail => tail
  }

  // 3.3
  def setHead[A](h: A)(xs: List[A]): List[A] = xs match {
    case Nil => Nil // or throw
    case x :: tail => h :: tail
  }

  // 3.4
  @tailrec
  def drop[A](n: Int)(xs: List[A]): List[A] = if (n == 0) xs else xs match {
    case Nil => Nil
    case x :: tail => drop(n - 1)(tail)
  }

  // 3.5
  // Scala resolves left to right, so I have to reverse the argument order
  @tailrec
  def dropWhile[A](xs: List[A])(p: A => Boolean): List[A] = xs match {
    case Nil => Nil
    case x :: tail if p(x) => dropWhile(tail)(p)
    case _ => xs
  }

  // 3.6
  def init[A](xs: List[A]): List[A] = xs match {
    case Nil => Nil // or throw
    case x :: Nil => Nil
    case x :: tail => x :: init(tail)
  }

  // 3.7 -- Yes it could halt immediately if the combining function takes its argument by name or we
  // delay its right argument evaluation in some other way.

  // 3.8 -- It creates an identical copy of the list. Cons and foldRight have the same associativity.

  // 3.9 Note I am using the standard `foldRight` here
  def length[A](xs: List[A]): Int = xs.foldRight(0) { (_, acc) => acc + 1 }

  // 3.10
  @tailrec
  def foldLeft[A, B](xs: List[A], z: B)(f: (B, A) => B): B = xs match {
    case Nil => z
    case x :: xs => foldLeft(xs, f(z, x))(f)
  }

  // 3.11
  def sumL(xs: List[Int]): Int = foldLeft(xs, 0)(_ + _)

  def prodL(xs: List[Int]): Int = foldLeft(xs, 1)(_ * _)

  def lengthL(xs: List[Int]): Int = foldLeft(xs, 0)((acc, _) => acc + 1)

  // 3.12
  def reverse[A](xs: List[A]): List[A] = foldLeft(xs, List[A]())((xs, x) => x :: xs)

  // 3.13
  def foldLeftInFoldRight[A, B](xs: List[A], z: B)(f: (B, A) => B): B = xs.reverse.foldRight(z)((x, acc) => f(acc, x))

  def foldRightInFoldLeft[A, B](xs: List[A], z: B)(f: (A, B) => B): B = foldLeft(xs.reverse, z)((acc, x) => f(x, acc))

  // I needed a hint to get this one, I had a feeling that it is possible but couldn't really get it all by myself.
  def foldLeftInFoldRight2[A, B](xs: List[A], z: B)(f: (B, A) => B): B = xs.foldRight { b: B => b }((x, b) => s => b(f(s, x)))(z)
}

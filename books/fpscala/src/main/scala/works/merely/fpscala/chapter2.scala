package works.merely.fpscala

object chapter2 {
  // 2.1
  def fib(n: Int): Int = {
    @annotation.tailrec
    def fibR(`n-i`: Int, cᵢ: Int, `cᵢ₊₁`: Int): Int = {
      if(`n-i` == 0) {
        cᵢ 
      } else if(`n-i` == 1) {
        `cᵢ₊₁`
      } else {
        fibR(`n-i` - 1, `cᵢ₊₁`, cᵢ + `cᵢ₊₁`)
      }
    }
    fibR(n - 0, 0, 1)
  }

  // 2.2
  @annotation.tailrec
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    if(as.length < 2) {
      true
    } else {
      if(ordered(as(0), as(1))) {
        isSorted(as.slice(1, as.length), ordered)
      } else {
        false
      }
    }
  }

  // 2.3
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)

  // 2.4
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)

  // 2.5
  def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))
}

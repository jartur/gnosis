package works.merely.fpscala

object Fib {  
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
}

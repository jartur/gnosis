package works.merely.fpscala

object IsSorted {
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
}
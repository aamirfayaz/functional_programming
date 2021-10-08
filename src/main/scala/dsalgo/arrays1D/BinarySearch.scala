package dsalgo.arrays1D

import scala.annotation.tailrec

object BinarySearch extends App {

  @tailrec
  def search(a: Array[Int], elem: Int, low: Int, high: Int): Int = {
    if (low > high) -1 else {
      val mid = low + (high - low) / 2
      if (a(mid) == elem) mid
      else if (a(mid) > elem) search(a, elem, low, mid - 1)
      else search(a, elem, mid + 1, high)
    }
  }
  val a1 = Array(1,2,3,4,5)
  println(search(a1, 3, 0, a1.length - 1))
  println(search(a1, 30, 0, a1.length - 1))
}
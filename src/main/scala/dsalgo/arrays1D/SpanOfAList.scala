package dsalgo.arrays1D

/**
 * Find diff of min and max number in list
 */

object SpanOfAList1 extends App {

  def maxMin(list: List[Int], min: Int, max: Int): Int = list match {
    case Nil => max - min
    case _   =>
      val mi = if (list.head < min) list.head else min
      val ma = if (list.head > max) list.head else max
      maxMin(list.tail, mi, ma)
  }

  val l1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  require(l1.size > 1)
  val result1 = maxMin(l1.tail, l1.head, l1.head)
  assert(result1 == 8)
  val l2 = List(1, 20, 3, 4, 5, 0, 7, 8, 9)
  require(l2.size > 1)
  val result2 = maxMin(l2.tail, l2.head, l2.head)
  assert(result2 == 20)
}


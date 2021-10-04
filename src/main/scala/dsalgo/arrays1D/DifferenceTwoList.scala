package dsalgo.arrays1D

import scala.annotation.tailrec

object DifferenceTwoList extends App {

  //assume l1 is greater than l2
  @tailrec
  def difference(l1: List[Int], l2: List[Int], carry: Int = 0, acc: List[Int] = Nil): List[Int] = (l1, l2) match {
    case (Nil, Nil) => {
      if(acc.head == 0) acc.tail else acc
    }
    case (_, Nil)   => {
      val diff = l1.last - carry
      difference(l1.init, l2, 0 , diff :: acc)
    }
    case (_, _)     => {
      val diff = l1.last - carry
      val (d, c) = if(diff < l2.last) {
        ((10 + diff) - l2.last, 1)
      } else (diff - l2.last, 0)

      difference(l1.init, l2.init, c, d :: acc )
    }
  }
  println(difference(List(1,2,3,4,5,6), List(9, 2, 9, 4, 9)))
}
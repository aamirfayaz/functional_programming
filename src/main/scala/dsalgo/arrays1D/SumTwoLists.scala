package dsalgo.arrays1D

/**
 * size = 5
 * 3 1 0 7 5
 * size = 6
 * 1 1 1 1 1 1
 * output = 1 4 2 1 8 6
 */

object SumTwoLists extends App {
  val a1 =    List(9, 1, 0, 7, 9)
  val a2 =          List(8, 1, 9)

  def sumF(l1: List[Int], l2: List[Int]): List[Int] = {
    l1.zip(l2).map { case (a, b) => a + b }
  }

  def sum(l1: List[Int], l2: List[Int], carry: Int = 0, acc: List[Int] = Nil): List[Int] = (l1, l2) match {
    case (Nil, Nil) => {
      if (carry == 0) acc else carry :: acc
    }
    case (_, Nil)   => {
      val s = (carry + l1.last)
      sum(l1.init, l2, s / 10, s % 10 :: acc)
    }
    case (Nil, _)   => {
      val s = (carry + l2.last)
      sum(l1, l2.init, s / 10, s % 10 :: acc)
    }
    case (_, _)     => {
      val s = (carry + l1.last + l2.last)
      sum(l1.init, l2.init, s / 10, s % 10 :: acc )
    }
  }

  println(sum(a1, a2))
}
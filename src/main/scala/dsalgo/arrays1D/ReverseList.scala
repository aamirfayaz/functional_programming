package dsalgo.arrays1D


/**
 * this is faster than O(n)
 * Imperative Algorithm
 * while(StartIndex < EndIndex) {
 * val temp = collection(StartIndex)
 * collection(StartIndex) = collection(EndIndex)
 * collection(EndIndex) = temp
 * }
 */
object ReverseList1 extends App {
 //O(n)
  def reverse(list: List[Int], acc: List[Int] = Nil): List[Int] = list match {
    case Nil       => acc
    case h :: tail => reverse(tail, h :: acc)
  }

  val l = List(1, 2, 3, 4, 5, 6)
  println(reverse(l))
}

object ReverseList2 extends App {
  val l = List(1, 2, 3, 4, 5, 6)
  val result = l.foldLeft(List[Int]()) { (acc, elem) => elem :: acc }
  println(result)
}
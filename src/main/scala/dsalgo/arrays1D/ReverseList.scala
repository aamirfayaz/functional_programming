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
object ReverseList1_Tail_Recursion extends App {
 //O(n)
  def reverse(list: List[Int], acc: List[Int] = Nil): List[Int] = list match {
    case Nil       => acc
    case h :: tail => reverse(tail, h :: acc)
  }

  val l = List(1, 2, 3, 4, 5, 6)
  println(reverse(l))
}

object ReverseList2_Fold extends App {

  def reverse(l: List[Int] =  List(1, 2, 3, 4, 5, 6)): List[Int] = {
    l.foldLeft(List[Int]()) { (acc, elem) => elem :: acc }
  }
  val result = reverse()
  println(result)
}

object Array_Reverse extends App {

   def arrayReverse(a: Array[Int], start: Int, end: Int): Array[Int] = {
    var i = start
    var j = end
    while(i < j) {
      val temp = a(i)
      a(i) = a(j)
      a(j) = temp
      i += 1
      j -= 1
    }
    a
  }
  val a = Array(1,2,3,4,5,6)
  println(arrayReverse(a,0, a.length - 1).toList)

}
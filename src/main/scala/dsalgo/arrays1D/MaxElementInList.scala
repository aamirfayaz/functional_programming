package dsalgo.arrays1D

object MaxElementInList1 extends App {

  val list = List(2,3,22,55,61,76,54,87,33,22,2,12)
  val maxelement = list.reduceLeft((a, b) => if(a > b)a else b)
  println(maxelement)
}

//max element in list generic
object MaxElementInList2 extends App {
  val list = List(2,3,22,55,61,76,54,87,33,22,2,12)

  def max[A](list: List[A])(implicit cmp: Ordering[A]): Int = {
    list.reduceLeft{ (a, b) =>
      cmp.gteq(a, b)
    }
  }
}

//max element in list recursive
object MaxElementInList3 extends App {

}

package dsalgo.arrays1D

object MaxElementInList1 extends App {

  val list = List(2, 3, 22, 55, 61, 76, 54, 87, 33, 22, 2, 12)
  val maxelement = list.reduceLeft((a, b) => if (a > b) a else b)
  println(maxelement)
}

//max element in list generic
object MaxElementInList2 extends App {
  val list = List(2, 3, 22, 55, 61, 76, 54, 87, 33, 22, 2, 12)

  def max[A](list: List[A])(implicit cmp: Ordering[A]): A = {
    list.reduceLeft { (a, b) =>
      if (cmp.gteq(a, b)) a else b
    }
  }

  sealed case class Integ(value: Int)

  val l = List(Integ(2), Integ(4), Integ(12), Integ(1))
  implicit val valueOrdering = Ordering.by { f: Integ => f.value }
  println(max(l))
}

//max element in list recursive
object MaxElementInList3 extends App {

  def max[A](list: List[A])(implicit cmpr: Ordering[A]): Option[A] = list match {
    case Nil                  => None
    case head :: Nil          => Some(head)
    case a :: b :: rest => max((if(cmpr.gt(a, b)) a else b) :: rest)
  }
  println(max(List(1,2,3,4,5,8,6)))
}

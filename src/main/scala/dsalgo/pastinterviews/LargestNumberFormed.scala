import scala.math.Ordering.comparatorToOrdering

case class Num(str: String) extends Ordered[Num] {
  override def compare(that: Num) = {
    val s1 = str + that.str
    val s2 = that.str + str
    if(s1.compareTo(s2) > 0) -1 else 1

  }
}


val l: List[Num] = List(1,34,3,98,9,76,45,4).map(x => Num(x.toString))
val x = l.sorted
val str = ""
x.foldLeft(str){(a, b) => a.concat(b.str)}


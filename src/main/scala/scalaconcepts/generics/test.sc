
trait Box[-T] {

  def add(t: T):Unit = println()
  def get[B <: T]:B
}


trait Combine[+T] {
  def item: T
  def combineWith[B >: T](t: B)(implicit n: Numeric[B]):B
}

case class CombineInt(x: Int) extends Combine[Int] {
  def item: Int = x
  def combineWith[B >: Int](t: B)(implicit n: Numeric[B]):B = item + t
}

val c1 = CombineInt(10)
c1.combineWith(20)
c1.item


trait Combine1[+T] {
  def item: T
  def combineWith[B >: T](t: B):B
}

trait Combine2[-T] {
  def item[B <: T]: B
  def combineWith[B <: T](t: B):B
}

case class CombineInt(x: Int) extends Combine1[Int] {

  override def item:Int = x

  override def combineWith[B >: Int](t: B) = {
    item
  }
}


 val c: Combine1[Int] = CombineInt(10)
 val d = c.item




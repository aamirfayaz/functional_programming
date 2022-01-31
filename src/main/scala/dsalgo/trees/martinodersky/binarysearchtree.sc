import cats.data.NonEmptyVector

trait InSet {
  def contains(x: Int):Boolean
  def incl(x: Int): InSet
  def union(other: InSet): InSet
}
case class NonEmpty(elem: Int, left: InSet, right: InSet) extends InSet {
  override def contains(x: Int) = {
    if(x < elem) left.contains(x)
    else if(x > elem) right.contains(x)
    else true
  }

  override def incl(x: Int) = {
    if(x < elem) NonEmpty(elem, left.incl(x), right)
    else if(x > elem) NonEmpty(elem, left, right.incl(x))
    else this
  }

  override def union(other: InSet) = other
}

case object Empty extends InSet {
  override def contains(x: Int) = false

  override def incl(x: Int) = NonEmpty(x, Empty, Empty)

  override def union(other: InSet) = ???
}


val tree = NonEmpty(10, NonEmpty(8, Empty, Empty), NonEmpty(12, Empty, Empty))
val tree2 = tree.incl(6)
val tree3 = tree2.incl(9)


sealed trait BinTree[+A]
case object Leaf extends BinTree[Nothing]
case class Branch[A](value: A, left: BinTree[A], right: BinTree[A]) extends BinTree[A]


object BinTree {
  def buildTree[A](list: List[A]): BinTree[A] = list match {
    case Nil => Leaf
    case x :: xs =>
      val k = xs.length / 2
      Branch(x, buildTree(xs.take(k)), buildTree(xs.drop(k)))
  }

  def size[A](tree: BinTree[A]): Int = tree match {
    case Leaf => 0
    case Branch(_, left, right) => 1 + size(left) + size(right)
  }
}
List(1,2,3,4).drop(0)
List(1,2,3,4).take(0)

val tree = BinTree.buildTree(List(1,2,3,4,5))
BinTree.size(tree)


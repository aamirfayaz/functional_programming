sealed trait BinTree[+A]
case object Leaf extends BinTree[Nothing]
case class Branch[A](value: A, left: BinTree[A], right: BinTree[A]) extends BinTree[A]


object BinTreeUtil {
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
//if we don't take leaf nodes into account, root to any node
  def depth1[A](tree: BinTree[A]): Int = tree match {
    case Leaf => 0
    case Branch(_, Leaf, Leaf) => 0
    case Branch(_, left, right) => 1 + (depth(left) max depth(right))
  }

  //if we take leaf node into account
  //the height of the binary tree is the longest path from the root node to any leaf node in the tree
  def depth[A](tree: BinTree[A]): Int = tree match {
    case Leaf => 0
    case Branch(_, left, right) => 1 + math.max(depth(left) , depth(right))
  }

  /**
   * Building a Perfect Binary Tree
              18
           /       \
         15         30
        /  \        /  \
      40    50    100   40

  In a Perfect Binary Tree, the number of leaf nodes is the number of internal nodes plus 1
   L = I + 1 Where L = Number of leaf nodes, I = Number of internal nodes.
  A Perfect Binary Tree of height h (where the height of the binary tree is the longest path from the root node to any
  leaf node in the tree, height of root node is 1) has 2^h – 1 node.
  Above tree has height of 3, so 7 nodes
   **/

  def buildPerfectBT[A](v:Int = 1, depth: Int):BinTree[Int] = {
    if(depth == 0) Leaf
    else Branch(v, buildPerfectBT(2 * v, depth - 1), buildPerfectBT(2 * v + 1, depth - 1))
  }
}
List(1,2,3,4).drop(0)
List(1,2,3,4).take(0)

val tree = BinTreeUtil.buildTree(List(1,2,3,4,5,6,7,8))
BinTreeUtil.size(tree)
BinTreeUtil.depth(tree)
BinTreeUtil.buildPerfectBT(1, 3)


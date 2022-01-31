sealed trait BinTree[+A]

case object Leaf extends BinTree[Nothing]

case class Branch[A](value: A, left: BinTree[A], right: BinTree[A]) extends BinTree[A]

def buildPerfectBT[A](v: Int = 1, depth: Int): BinTree[Int] = {
  if (depth == 0) Leaf
  else Branch(v, buildPerfectBT(2 * v, depth - 1), buildPerfectBT(2 * v + 1, depth - 1))
}
val tree = buildPerfectBT(1, 3)

/**
 *     1
 * /       \
 * 2          3
 * /  \
 * 4    5
 * Time Complexity: O(n)

 * Depth First Traversals:
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 * Breadth-First or Level Order Traversal: 1 2 3 4 5
 */

  //without accumulator
def inOrder[A](tree: BinTree[A]): List[A] = tree match {
  case Leaf                   => Nil
  case Branch(v, left, right) => inOrder(left) ++ (v ::  inOrder(right))
}

def preOrder[A](tree: BinTree[A]): List[A] = tree match {
  case Leaf                   => Nil
  case Branch(v, left, right) => v :: (preOrder(left) ++ preOrder(right))
}

def postOrder[A](tree: BinTree[A]): List[A] = tree match {
  case Leaf                   => Nil
  case Branch(v, left, right) => (postOrder(left) ++ postOrder(right)) ++ List(v)
}

inOrder(tree)
preOrder(tree)
postOrder(tree)


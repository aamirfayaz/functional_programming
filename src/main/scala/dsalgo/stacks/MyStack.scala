package dsalgo.stacks

class MyStack[+A](self: List[A]) {

  def push[B >: A](elem: B):MyStack[B] = new MyStack[B](elem :: self)

  def pop(): (Option[A], MyStack[A]) = self match {
    case Nil =>(None, new MyStack[A](Nil))
    case _   =>(Some(self.head), new MyStack[A](self.tail))
  }

  def peek: Option[A] = self.headOption

  def size: Int = self.size

  def isEmpty: Boolean = self.isEmpty
}

object MyStack {
  def empty[A]: MyStack[A] = new MyStack[A](Nil)
  def apply[A](elems: A*): MyStack[A] = {
    elems.foldLeft(MyStack.empty[A])((stk, elem) => stk.push(elem))
  }
}
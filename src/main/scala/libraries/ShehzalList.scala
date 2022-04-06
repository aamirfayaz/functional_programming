package libraries

trait ShehzalList[+A] {
  def isEmpty: Boolean
  def head:A
  def tail: ShehzalList[A]
  def map[B >: A](f: A => B): ShehzalList[B] = ???
  def flatMap[B >: A](f: A => ShehzalList[B]):ShehzalList[B] = ???
  def filter(f: A => Boolean): ShehzalList[A] = ???
  def foreach(f: A => Unit): Unit = ???
}

case class ShehzalCons[+A](head:A, tail: ShehzalList[A]) extends ShehzalList[A] {
   def isEmpty: Boolean = false
}
case object ShehzalEmpty extends ShehzalList[Nothing] {
   def isEmpty: Boolean = true
  def head: Nothing = throw new Exception("head.empty")
  def tail: Nothing = throw new Exception("tail.empty")
}

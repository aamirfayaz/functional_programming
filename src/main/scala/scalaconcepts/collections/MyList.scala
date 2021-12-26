package scalaconcepts.collections

trait MyList[+A] {
  def isEmpty: Boolean
  def head: A
  def tail: MyList[A]
  //0(1)
  def prepend[B >: A](item: B): MyList[B]
  //0(n)
  def append[B >: A](item: B): MyList[B]
  def map[B](f: A => B):MyList[B]
  def filter(f: A => Boolean):MyList[A]
}

case class MyCons[+A](head: A, tail: MyList[A]) extends MyList[A] {
   def isEmpty: Boolean = false
   def prepend[B >: A](item: B): MyList[B] = MyCons(item, this)
   def append[B >: A](item: B): MyList[B] = MyCons(head, tail.append(item))
   def map[B](f: A => B):MyList[B] = MyCons(f(head), tail.map(f))
   def filter(f: A => Boolean):MyList[A] = {
     if(f(head)) MyCons(head, tail.filter(f)) else tail.filter(f)
   }
}

case object EmptyList extends MyList[Nothing] {
   def isEmpty: Boolean = true

   def head: Nothing = throw new NoSuchElementException("head.empty")

   def tail: MyList[Nothing] = throw new UnsupportedOperationException("tail.empty")

   def prepend[B >: Nothing](x: B): MyList[B] = MyCons(x, EmptyList)

   def append[B >: Nothing](item: B): MyList[B] = MyCons(item, EmptyList)

}
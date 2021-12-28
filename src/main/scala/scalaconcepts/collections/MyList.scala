package scalaconcepts.collections


trait MyPredicate[-T] {
  def check(elem: T): Boolean
}

trait MyTransformer[-A, +B] {
  def transform(elem: A):B
}

class EvenPredicate extends MyPredicate[Int] {
  override def check(elem: Int): Boolean = elem % 2 == 0
}

class IncrementTransformer extends MyTransformer[Int, Int] {
  override def transform(elem: Int): Int = elem + 1
}

trait MyList[+A] {

  def isEmpty: Boolean
  def head: A
  def tail: MyList[A]
  def prepend[B >: A](item: B): MyList[B] //0(1)
  def append[B >: A](item: B): MyList[B] //0(n)
  def map[B](transformer: MyTransformer[A, B]):MyList[B]
  def filter(predicate: MyPredicate[A]):MyList[A]
  def getList: String

  override def toString: String = "[" + getList + "]"
}

case class MyCons[+A](head: A, tail: MyList[A]) extends MyList[A] {

   def isEmpty: Boolean = false
   def prepend[B >: A](item: B): MyList[B] = MyCons(item, this)
   def append[B >: A](item: B): MyList[B] = MyCons(head, tail.append(item))

  def map[B](transformer: MyTransformer[A, B]):MyList[B] = {
    MyCons(transformer.transform(head), tail.map(transformer))
  }
   def filter(predicate: MyPredicate[A]):MyList[A] = {
     if(predicate.check(head)) MyCons(head, tail.filter(predicate)) else tail.filter(predicate)
   }

  override def getList: String = {
    if(tail.isEmpty) head.toString else head + " " + tail.getList
  }
}

case object EmptyList extends MyList[Nothing] {
   def isEmpty: Boolean = true

   def head: Nothing = throw new NoSuchElementException("head.empty")

   def tail: Nothing = throw new UnsupportedOperationException("tail.empty")

   def prepend[B >: Nothing](x: B): MyList[B] = MyCons(x, EmptyList)

   def append[B >: Nothing](item: B): MyList[B] = MyCons(item, EmptyList)

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = EmptyList

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = EmptyList

  override def getList: String = ""
}

object TestList extends App {

  val l = MyCons(1, MyCons(2, MyCons(4, MyCons(5, MyCons(6, EmptyList)))))

  println(l.getList)

  val l2 = l.map(new IncrementTransformer)
  println(l2.getList)

  val l3 = l.filter(new EvenPredicate)
  println(l3.getList)

}
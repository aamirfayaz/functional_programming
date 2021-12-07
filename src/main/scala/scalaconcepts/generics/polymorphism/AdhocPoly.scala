package scalaconcepts.generics.polymorphism

object AdhocPoly extends App {

  /**
    https://dev.to/jmcclell/inheritance-vs-generics-vs-typeclasses-in-scala-20op
    Because of runtime type erasure, the JVM, at runtime, can't tell the difference between List[Int] and List[Double]
    so we can't use overloading to implement our mean function.
    It's also a bit repetitious/monotonous to implement the function over and over again for every type we care about.
   */
  //def mean(xs: List[Double]): Double = xs.reduce(_ + _) / xs.size
  //def mean(xs: List[Int]): Double = xs.reduce(_ + _) / xs.size

 //  mean(List(1,2))
}

/**
 * This is the classic OOP solution to the problem of ad-hoc polymorphism-adapter pattern
 */
/**
trait NumberLike[A] {
   def get: A
   def plus(y: NumberLike[A]): NumberLike[A]
   def divide(y: Int): NumberLike[A]
}

case class NumberLikeDouble(x: Double) extends NumberLike[Double] {
  override def get: Double = x

  override def plus(y: NumberLike[Double]): NumberLike[Double] = NumberLikeDouble(x + y.x)

  override def divide(y: Int): NumberLike[Double] = NumberLikeDouble(x / y)
}

case class NumberLikeInt(x: Int) extends NumberLike[Int] {
  override def get: Int = x

  override def plus(y: NumberLike[Int]): NumberLike[Int] = NumberLikeInt(x + y.get)

  override def divide(y: Int): NumberLike[Int] = NumberLikeInt(x / y)
}

object NumberLikeOOPs extends App {

  def mean[T](list: List[NumberLike[T]]): NumberLike[T] = {
    //list.reduce(_.plus(_)).divide(list.size)
    list.reduce{ (a, b) => a.plus(b)}.divide(list.size)
  }
  //The downside to this approach, however, is the performance hit of having to convert every Int in a List[Int]
  // to a NumberLike[Int] before the mean function can use it
  val l: List[NumberLikeDouble] = List(1.2,2.9,3.0).map(NumberLikeDouble)
  println(mean[Double](l).get)
}*/

//type classes to the rescue
trait NumberLike[T] {
  def plus(x: T, y: T): T
  def divide(x: T, y: Int): T
}

object NumberLikeInstances {
  implicit object NumberLikeInt extends NumberLike[Int] {
    def plus(x: Int, y: Int): Int = x + y
    def divide(x: Int, y: Int): Int = x / y
  }

  //extensibility, we added plus and divide method to Double/Int class
  implicit object NumberLikeDouble extends NumberLike[Double] {
    def plus(x: Double, y: Double): Double = x + y
    def divide(x: Double, y: Int): Double = x / y
  }
}

object NumberLikeInterface {
  def mean[T](list: List[T])(implicit ev: NumberLike[T]) = {
    ev.divide(list.reduce{(a, b) => ev.plus(a,b)}, list.size)
  }
}

object NumberLikeSyntax {
  implicit class NumberLikeOps[T](list: List[T]) {
    def mean(implicit ev: NumberLike[T]):T = {
      ev.divide(list.reduce{(a, b) => ev.plus(a,b)}, list.size)
    }
  }
}

object TestNumberLike extends App {
  val list1: List[Int] = List(1,2,3,4,5)
  val list2: List[Int] = (1 to 10).toList
  import NumberLikeInterface._
  import NumberLikeInstances._

  println {
    mean(list1)
  }

  println {
    mean(list2)
  }
}
object TestNumberLikeSyntax extends App {
  val list1: List[Int] = List(1,2,3,4,5)
  val list2: List[Int] = (1 to 10).toList
  import NumberLikeSyntax._
  import NumberLikeInstances._

  println {
    list1.mean
  }

  println {
    list2.mean
  }
}



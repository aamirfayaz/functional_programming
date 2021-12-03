package scalaconcepts.generics.polymorphism

object AdhocPoly extends App {

  /**
    Because of runtime type erasure, the JVM, at runtime, can't tell the difference between List[Int] and List[Double]
    so we can't use overloading to implement our mean function.
    It's also a bit repetitious/monotonous to implement the function over and over again for every type we care about.
   */
  //def mean(xs: List[Double]): Double = xs.reduce(_ + _) / xs.size
  //def mean(xs: List[Int]): Double = xs.reduce(_ + _) / xs.size

 //  mean(List(1,2))
}

/**
 * This is the classic OOP solution to the problem of ad-hoc polymorphism
 */
trait NumberLike[A] {
   def get: A
   def plus(y: NumberLike[A]): NumberLike[A]
   def divide(y: Int): NumberLike[A]
}

case class NumberLikeDouble(x: Double) extends NumberLike[Double] {
  override def get: Double = x

  override def plus(y: NumberLike[Double]): NumberLike[Double] = NumberLikeDouble(x + y.get)

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
}
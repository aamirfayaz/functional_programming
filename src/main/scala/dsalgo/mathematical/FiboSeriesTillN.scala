package dsalgo.mathematical

object FiboSeriesTillN1 extends App {

  val n = 10

  def fibo(index: Int = 1, current: Int = 0, next: Int = 1, sum: Int=1, acc: List[Int]=Nil): List[Int] = index > n match {
    case true  => acc
    case false => {
      val c = next
      val n = sum
      fibo(index + 1, c, n, c+n, current :: acc)
    }
  }

  println(fibo())

  def fibo = 1

}

object FiboSeriesTillN2 extends App {

   def fibs(a: Int = 0, b: Int = 1): LazyList[Int] = {
     LazyList.cons(a, fibs(b, a + b))
   }
  println(fibs().take(10).toList)
}

object FiboSeriesTillN3 extends App {

  val fibs: LazyList[Int] = LazyList.iterate((0, 1)) { case (a, b) =>
    (b, a + b)
  }.map(_._1)
  println(fibs.take(10).toList)
}

object FiboSeriesTillN4 extends App {

  // check internals of scanLeft for Streams , you will understand the working
   def fibs: LazyList[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
  println(fibs.take(10).toList)


}
package dsalgo.recursion

object Factorial extends App {

  val n = 5

  def fact(n: Int, acc: Int = 1): Int = n match {
    case 0 => acc
    case _ => fact(n - 1, n * acc)
  }
  println(fact(n))
}
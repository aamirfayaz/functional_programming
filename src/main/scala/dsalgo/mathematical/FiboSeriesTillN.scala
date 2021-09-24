package dsalgo.mathematical

object FiboSeriesTillN extends App {

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
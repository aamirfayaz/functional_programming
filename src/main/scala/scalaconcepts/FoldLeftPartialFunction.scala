package scalaconcepts

object FoldLeftPartialFunction extends App {


  val l: List[Int] = List(3, 6, 9)

  val startFold: Int = 0
  val r1: Int = l.foldLeft(startFold)((a, b) => a + b)
  assert(r1 == 18, r1)

  val factor: Int = 2

  def isEven(n: Int): Boolean = n % factor == 0

  val r2: List[Int] = l.foldLeft(List.empty[Int]) {
    case (accumulator, n) if isEven(n)  => accumulator :+ (n / factor)
    case (accumulator, n) if !isEven(n) => accumulator :+ (n * factor)
  }
  assert(r2 == List(6, 3, 18), r2)

}
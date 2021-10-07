package dsalgo.arrays2D

///https://rosettacode.org/wiki/Matrix_multiplication#Scala
import Array2DUtils._

object MatrixMultiplication_Functional {
  def mult(a: Array[Array[Int]], b: Array[Array[Int]]) = {
    for (row <- a)
      yield for (col <- b.transpose)
        yield (row zip col map Function.tupled(_ * _)).sum
  }

  val a = Array(Array(1, 2), Array(3, 4))
  val b = Array(Array(-3, -8, 3), Array(-2, 1, 4))
  println(mult(a, b).map(_.toList).toList)
}

object MatrixMultiplication extends App {

  val r1 = 3; val c1 = 3
  val r2 = 3; val c2 = 2
  val a1 = Create2dArray(r1, c1)
  val a2 = Create2dArray(r2, c2)
  val a3 = Array.ofDim[Int](r1, c2)
  require(c1 != r2, "matrix multiplication validation failed")

  for(i <- 0 until r1) {
    for(j <- 0 until c2) {
      for(k <- 0 until c1) {
        a3(i)(j) = a3(i)(j) + (a1(i)(k) * a2(k)(j))
      }
    }
  }

  Print2dArray(a3, r1, c2)


}
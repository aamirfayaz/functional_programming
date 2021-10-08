package dsalgo.arrays2D

///https://rosettacode.org/wiki/Matrix_multiplication#Scala
import Array2DUtils._
import dsalgo.mathematical.RotateANumber.mul


object MatrixMultiplication_Functional  extends App {

  def matrixMultiply(a: Array[Array[Int]], b: Array[Array[Int]]) = {
       for(row <- a)
         yield for(col <- b.transpose)
           yield (row zip col map Function.tupled(_ * _)).sum
  }

  val a = Create2dArray(3, 3)
  val b = Create2dArray(3, 3)
  //val r: Array[Array[Int]] = matrixMultiply(a, b)
  //val c: Array[List[Int]] = r.map(_.toList)
  //val d: List[List[Int]] = c.toList
  println(matrixMultiply(a, b).map(_.toList).toList)
}

object MatrixMultiplication extends App {

  val r1 = 3; val c1 = 3
  val r2 = 3; val c2 = 2
  val a1 = Create2dArray(r1, c1)
  val a2 = Create2dArray(r2, c2)
  val a3 = Array.ofDim[Int](r1, c2)
  require(c1 == r2, "matrix multiplication validation failed")

  for(i <- 0 until r1) {
    for(j <- 0 until c2) {
      for(k <- 0 until c1) {
        a3(i)(j) = a3(i)(j) + (a1(i)(k) * a2(k)(j))
      }
    }
  }

  Print2dArray(a3)


}
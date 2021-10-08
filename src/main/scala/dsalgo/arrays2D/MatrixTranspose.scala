package dsalgo.arrays2D

/**
  Matrix Transpose
 1 2 3
 4 5 6
 7 8 9
 to
 1 4 7
 2 5 8
 3 6 9
 */

object MatrixTranspose extends App {
  val a1  = Array2DUtils.Create2dArray(3, 3)
  val a2 = Array.ofDim[Int](3, 3)

  for(i <- a1.indices) {
    for(j <- a1(0).indices) {
       a2(i)(j) = a1(j)(i)
    }
  }

  Array2DUtils.Print2dArray(a2)
}
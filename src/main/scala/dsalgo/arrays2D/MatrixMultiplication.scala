package dsalgo.arrays2D

///https://rosettacode.org/wiki/Matrix_multiplication#Scala


/**
  Imperative solution:
  n1, m1 -> r,c a1
  n2, m2 -> r,c a2
    if (m1 != n2) {
      System.out.print("Invalid input");
      return;
    }
    int[][] ans = new int[n1][m2];
    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < m2; j++) {
        for (int k = 0; k < m1; k++) {
          ans[i][j] = ans[i][j] + (arr1[i][k] * arr2[k][j]);
        }
      }
 */

object MatrixMultiplication extends App {

  def matrixMultiply(a: Matrix, b:Matrix): Matrix = {
       for(row <- a)
         yield for(col <- b.transpose)
           yield (row zip col map Function.tupled(_ * _)).sum
  }

  val a: Matrix = MatrixF(3, 3)((_:Int, _: Int) => scala.io.StdIn.readInt())
  val b: Matrix = MatrixF(3, 3)((_:Int, _: Int) => scala.io.StdIn.readInt())

  println(matrixMultiply(a, b))
}
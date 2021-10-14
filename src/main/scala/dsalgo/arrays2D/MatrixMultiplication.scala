package dsalgo.arrays2D

///https://rosettacode.org/wiki/Matrix_multiplication#Scala



object MatrixMultiplication extends App {

  def matrixMultiply(a: List[List[Int]], b: List[List[Int]]) = {
       for(row <- a)
         yield for(col <- b.transpose)
           yield (row zip col map Function.tupled(_ * _)).sum
  }

  val a: List[List[Int]] = MatrixF(3, 3)((_:Int, _: Int) => scala.io.StdIn.readInt())
  val b: List[List[Int]] = MatrixF(3, 3)((_:Int, _: Int) => scala.io.StdIn.readInt())

  println(matrixMultiply(a, b))
}
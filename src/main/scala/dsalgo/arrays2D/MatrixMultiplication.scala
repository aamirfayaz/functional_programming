package dsalgo.arrays2D

///https://rosettacode.org/wiki/Matrix_multiplication#Scala



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
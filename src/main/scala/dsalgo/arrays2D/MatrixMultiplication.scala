package dsalgo.arrays2D

///https://rosettacode.org/wiki/Matrix_multiplication#Scala

object MatrixMultiplication {
  def mult(a: Array[Array[Int]], b: Array[Array[Int]]) = {
    for (row <- a)
      yield for(col <- b.transpose)
        yield (row zip col map Function.tupled(_ * _)).sum
  }

  val a =  Array(Array(1, 2), Array(3, 4))
  val b = Array(Array(-3, -8, 3), Array(-2, 1, 4))
  println(mult(a, b).map(_.toList).toList)
}
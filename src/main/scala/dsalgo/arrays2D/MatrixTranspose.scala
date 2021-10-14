package dsalgo.arrays2D

/**
 * Matrix Transpose
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * to
 * 1 4 7
 * 2 5 8
 * 3 6 9
 */

object MatrixTranspose extends App {

  type Row = List[Int]
  type Matrix = List[Row]

  def transpose(m: Matrix): Matrix = {
    if(m.head.isEmpty) Nil
    else m.map(_.head) :: transpose(m.map(_.tail))
  }

  val a: Matrix = List(
    List(1, 2, 3),
    List(4, 5, 6),
    List(7, 8, 9),
  )

  val res = transpose(a)

  println(res)

}
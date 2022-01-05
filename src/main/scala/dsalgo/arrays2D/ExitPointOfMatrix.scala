package dsalgo.arrays2D

/**
 * Matrix of only 0's and 1's
 * Input is a square matrix
 */
object ExitPointOfMatrix extends App {

  val matrix = MatrixF.zeroOnesRandomList(5, 5)
  MatrixF.display(matrix)


  def exitPoint(matrix: Matrix): (Int, Int) = {
    println("1")

    def move(dir: Int, i: Int, j: Int): (Int, Int) = {
      if (i < 0) (i + 1, j)
      else if (i >= matrix.length) (i - 1, j)
      else if (j < 0) (i, j + 1)
      else if (j >= matrix.length) (i, j - 1)
      else {
        val d = (dir + matrix(i)(j)) % 4
        if (d == 0) move(d, i, j + 1)
        else if (d == 1) move(d, i + 1, j)
        else if (d == 2) move(d, i, j - 1)
        else move(d, i - 1, j)
      }
    }

    move(0, 0, 0)
  }

  val result = exitPoint(matrix)
  println(result)


}
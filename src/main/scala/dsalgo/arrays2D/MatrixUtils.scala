package dsalgo.arrays2D

object MatrixF {
  def apply(rowCount: Int, colCount: Int)(f: (Int, Int) => Int): Matrix = {
    (for(i <- 1 to rowCount)
      yield (for(j <- 1 to colCount)
      yield f(i, j)).toList).toList
  }
  def display(m: Matrix) = {
    m.foreach { row =>
      row.foreach{ elem =>
        print(elem + " ")
      }
      println()
    }
  }
}

object L extends App {

  val m = MatrixF(5, 5)((_ , _) => 0)
  MatrixF.display(m)
}
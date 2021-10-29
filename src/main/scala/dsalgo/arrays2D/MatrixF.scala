package dsalgo.arrays2D

object MatrixF {
  def apply(rowCount: Int, colCount: Int)(f: (Int, Int) => Int):Matrix = {
    (for(i <- 1 to rowCount)
      yield (for(j <- 1 to colCount)
      yield f(i, j)).toList).toList
  }
}
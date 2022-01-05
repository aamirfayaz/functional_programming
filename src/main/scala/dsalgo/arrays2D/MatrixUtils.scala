package dsalgo.arrays2D

import scala.util.Random

object MatrixF {

  def apply(rowCount: Int, colCount: Int)(f: () => Int): Matrix = {
    (for(i <- 1 to rowCount)
      yield (for(j <- 1 to colCount)
      yield f()).toList).toList
  }

  def display(m: Matrix) = {
    m.foreach { row =>
      row.foreach{ elem =>
        print(elem + " ")
      }
      println()
    }
  }

  def zeroOnesRandomList(row: Int, cols: Int): Matrix = {
     List.tabulate(5, 4)((x, y) => new Random().nextInt(2))
  }

  def randomList(row: Int, cols: Int, till: Int = 10): Matrix = {
    List.tabulate(5,4)((x, y) => new Random().nextInt(till))
  }

  def randomListF(row: Int, cols: Int)(f: () => Int): Matrix = {
    List.tabulate(row,cols)((x, y) => f())
  }
}

object L extends App {

  val m = MatrixF(5, 4)(() => 0) //Matrix of zeros
  val r = MatrixF.randomList(5,4)

   val q = MatrixF(5,4)(() => new Random().nextInt(10))
  MatrixF.display(q)
}

object K extends App {
  //val m = MatrixF(4,4)(() =>  scala.io.StdIn.readInt())
  val r = MatrixF.randomListF(4,4)(() => scala.io.StdIn.readInt())
  MatrixF.display(r)

}
package dsalgo.arrays2D

object Array2DUtils {

  object Create2dArray {

    def apply(rows: Int, cols: Int): Array[Array[Int]] = {
      val a = Array.ofDim[Int](rows, cols)
      println("\nEnter elements of 2d array: \n")
      for (i <- 0 until rows) {
        for (j <- 0 until cols) {
          a(i)(j) = scala.io.StdIn.readInt()
        }
      }
      a
    }


  }

  object Print2dArray {

    def apply(a: Array[Array[Int]], rows: Int, cols: Int): Unit = {
      println("\nElements of 2d array are:\n")
      for (i <- 0 until rows) {
        for (j <- 0 until cols) {
          print(a(i)(j) + " ")
        }
        println()
      }
    }
  }
}
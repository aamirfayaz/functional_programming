package dsalgo.arrays2D

object ExitPointOfMatrix extends App {

  val row = 4
  val col = 4
  val a: Array[Array[Int]] = Array.ofDim[Int](row, col)
  for (i <- 0 until row) {
    for (j <- 0 until col) {
      a(i)(j) = scala.io.StdIn.readInt()
    }
  }

  a.foreach { row =>
    for (elem <- row) {
      print(elem + " ")
    }
    println()
  }

  var i = 0
  var j = 0
  var dir = 0 //dir = 0(East), dir = 1(South), dir = 2(West), dir = 3(North)

  def loop(): (Int, Int) = {
    if (i < 0) (i + 1, j)
    else if (i >= a.length) (i - 1, j)
    else if (j < 0) (i, j + 1)
    else if (j >= a.length) (i, j - 1)
    else {
      dir = (dir + a(i)(j)) % 4
      if (dir == 0) j = j + 1
      else if (dir == 1) i = i + 1
      else if (dir == 2) j = j - 1
      else i = i - 1
      loop()
    }
  }
  println(loop())
}
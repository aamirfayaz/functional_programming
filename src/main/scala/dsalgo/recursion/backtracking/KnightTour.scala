import java.io._
import java.util._
import scala.annotation.tailrec
import scala.collection.immutable.List

object KnightsTour {
  @throws[Exception]
  def main(args: Array[String]): Unit = {
    val br = new BufferedReader(new InputStreamReader(System.in))
    val n = br.readLine.toInt
    val r = br.readLine.toInt
    val c = br.readLine.toInt
    val chess:Array[Array[Int]] =  Array.ofDim(n, n)
    printKnightsTour(chess, r, c, 1)
  }

  def printKnightsTour(chess: Array[Array[Int]], r: Int, c: Int, upcomingMove: Int): Unit = {
    if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess(r)(c) != 0) return
    else if (upcomingMove == chess.length * chess.length) {
      chess(r)(c) = upcomingMove
      displayBoard(chess)
      chess(r)(c) = 0
      return
    }
    chess(r)(c) = upcomingMove
    printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1)
    printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1)
    printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1)
    printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1)
    printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1)
    printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1)
    printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1)
    printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1)
    chess(r)(c) = 0
  }

  def displayBoard(chess: Array[Array[Int]]): Unit = {
    for (i <- 0 until chess.length) {
      for (j <- 0 until chess(0).length) {
        System.out.print(chess(i)(j) + " ")
      }
      System.out.println()
    }
    System.out.println()
  }
}



// Part 1 about finding and counting Knight's tours
//==================================================

object CW7a extends App {

  type Pos = (Int, Int)    // a position on a chessboard
  type Path = List[Pos]    // a path...a list of positions

  //(1a) Complete the function that tests whether the position
  //     is inside the board and not yet element in the path.

  def is_legal(dim: Int, path: Path)(x: Pos) : Boolean = {
    !(x._1 < 0 || x._1 >= dim || x._2 < 0 || x._2 >= dim || path.contains(x))
  }

  //(1b) Complete the function that calculates for a position
  //     all legal onward moves that are not already in the path.
  //     The moves should be ordered in a "clockwise" manner.

  def legal_moves(dim: Int, path: Path, x: Pos) : List[Pos] = {
    val operations = List((1,2), (2,1), (2,-1), (1,-2), (-1, -2), (-2,-1), (-2,1), (-1,2))
    for(n <- operations
      if(is_legal(dim, path)((x._1 + n._1), (x._2 + n._2)))) yield ((x._1 + n._1), (x._2 + n._2)).asInstanceOf[Pos]
  }

  //some test cases
  //
  assert(legal_moves(8, Nil, (2,2)) ==
    List((3,4), (4,3), (4,1), (3,0), (1,0), (0,1), (0,3), (1,4)))
  assert(legal_moves(8, Nil, (7,7)) == List((6,5), (5,6)))
  assert(legal_moves(8, List((4,1), (1,0)), (2,2)) ==
    List((3,4), (4,3), (3,0), (0,1), (0,3), (1,4)))
  assert(legal_moves(8, List((6,6)), (7,7)) == List((6,5), (5,6)))


  //(1c) Complete the two recursive functions below.
  //     They exhaustively search for knight's tours starting from the
  //     given path. The first function counts all possible tours,
  //     and the second collects all tours in a list of paths.

  def count_tours(dim: Int, path: Path): Int = {
    val moves = legal_moves(dim, path, path.head)
    val counts = for (n <- moves) yield count_tours(dim, n :: path)
    if(path.size == dim * dim) 1
    else if(moves.size == 0) 0
    else counts.foldLeft(0)(_ + _)
  }

 type Row = Array[Int]
 type Matrix = Array[Row]

  @tailrec
  def buildChessPath(path: Path, a: Matrix, index: Int = 1):Matrix = {
    if(path.isEmpty) a
    else {
      val head = path.head
      a(head._1)(head._2) = index
      buildChessPath(path.tail, a, index + 1)
    }
  }

  def buildMatrix(path: Path) : Unit = {
    var c:Int = 1
    val a: Array[Array[Int]] = Array.ofDim(5,5)
    val p = path.reverse
    p.foreach { x =>
      a(x._1)(x._2) = c
      c= c + 1
    }

    a.foreach { row =>
      row.foreach { elem =>
        print(elem + " ")
      }
      println()
    }


  }
   var c = 0
  def enum_tours(dim: Int, path: Path) : List[Path] = {
    val moves: List[(Int, Int)] = legal_moves(dim, path, path.head)
    val tours: List[List[Path]] = for (n <- moves) yield enum_tours(dim, n :: path)
    if (path.size == dim*dim) {
      List(path)
    }
    else if(moves.isEmpty) Nil
    else {
      tours.flatten
    }
  }

  val paths = enum_tours(5, List((1, 1)))
  println(paths)
  println(c)
/*  println(paths.head)
  val a:Matrix = Array.ofDim(5,5)
  val m: Matrix = buildChessPath(paths.head.reverse, a)

  for (elem <- m) {
    print(elem.mkString(" "))
    println()
  }*/




}









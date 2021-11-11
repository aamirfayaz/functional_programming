package dsalgo.recursion.backtracking

import scala.annotation.tailrec

object ModifiedKnightsTour extends App {

  val chessBoard: Array[Array[Int]] = Array.ofDim(10, 10)

  def isLegal(chessBoardLength: Int, x: Int, y: Int) = {
    x >= 0 && x <= chessBoardLength - 1 && y >= 0 && y <= chessBoardLength - 1 && chessBoard(x)(y) == 0
  }

  def possibleMoves(x: Int, y: Int): List[(Int, Int)] = {
    val moves = List((2, 1), (1, 2), (2, -1), (1, -2), (-2, 1), (-1, 2), (-2, -1), (-1, -2))
    @tailrec
    def legalMoves(moves: List[(Int, Int)], possibilities: List[(Int, Int)] = Nil): List[(Int, Int)] = moves match {
      case Nil          => possibilities
      case head :: tail =>
        if (isLegal(chessBoard.length, x + head._1, y + head._2)) legalMoves(tail, (x + head._1, y + head._2) :: possibilities)
        else legalMoves(tail, possibilities)
    }

    legalMoves(moves)
  }

  @tailrec
  def tour(x: Int, y: Int, counter: Int, range: Int):Unit = {
    if (range == chessBoard.length * chessBoard.length) displayChessBoard()
    else {
      val possibilities = possibleMoves(x, y)
      @tailrec
      def findMinimumPossibility(posMoves: List[(Int, Int)],
        minMove: (Int, Int)): (Int, Int) = posMoves match {
        case Nil          => minMove
        case head :: tail =>
          if (possibleMoves(head._1, head._2).size <= possibleMoves(minMove._1, minMove._2).size)
            findMinimumPossibility(tail, (head._1, head._2))
          else findMinimumPossibility(tail, minMove)
      }

      val minMOve = findMinimumPossibility(possibilities, possibilities.head)
      chessBoard(minMOve._1)(minMOve._2) = counter
      tour(minMOve._1, minMOve._2, counter + 1, range + 1)
    }
  }

  def displayChessBoard(): Unit = {
    chessBoard foreach { row =>
      row foreach { elem =>
        print(elem + " ")
      }
      println()
    }
  }

  chessBoard(2)(3) = 1
  tour(2, 3, 2, 1)

}
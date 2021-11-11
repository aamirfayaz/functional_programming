package dsalgo.recursion.backtracking

import scala.annotation.tailrec

object Assignment extends App {

  val chessBoard: Array[Array[Int]] = Array.ofDim(10, 10)
  val chessBoardLength = chessBoard.length

  def isLegal(x: Int, y: Int) = {
    x >= 0 && x <= chessBoardLength - 1 && y >= 0 && y <= chessBoardLength - 1 && chessBoard(x)(y) == 0
  }

  def possibleMoves(x: Int, y: Int): List[(Int, Int)] = {
    val moves = List((2, 2), (0, 3), (-2, 2), (-3, 0), (-2, -2), (0, -3), (2, -2), (3, 0))
    @tailrec
    def legalMoves(moves: List[(Int, Int)], possibilities: List[(Int, Int)] = Nil): List[(Int, Int)] = moves match {
      case Nil          => possibilities
      case head :: tail =>
        if (isLegal(x + head._1, y + head._2)) legalMoves(tail, (x + head._1, y + head._2) :: possibilities)
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

  val initialPosition = (0, 0) // this can be modified for where to start
  chessBoard(initialPosition._1)(initialPosition._2) = 1
  tour(initialPosition._1, initialPosition._2, 2, 1)

}
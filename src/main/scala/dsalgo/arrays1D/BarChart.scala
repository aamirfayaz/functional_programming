package dsalgo.arrays1D

/**
  if array is 6 5 0 1 2, output will be:
 *
 * *
 * *
 * *
 * *       *
 * *   *   *
 */

object BarChart extends App {

  val l = List(5, 2, 0, 1, 6)
  val maxElement = MaxElementInList2.max(l)

  def buildBarChart(list: List[Int], max: Int = 0, acc: String = ""): String = max match {
    case 0 => acc
    case _ =>
      def build(l: List[Int], acc: String = ""): String = l match {
        case Nil => buildBarChart(list, max - 1, acc + "\n")
        case _   =>
          if (l.head >= max) build(l.tail, acc + "*\t") else build(l.tail, acc + "\t")
      }

      build(list, acc)
  }

  println(buildBarChart(l, maxElement))
}
package dsalgo.mathematical

/**
 *  The inverse of a number is defined as the number created by interchanging the face value and index of digits of number.
 *  e.g. for 426135 (reading from right to left, 5 is in place 1, 3 is in place 2, 1 is in place 3, 6 is in place 4, 2 is in place 5 and 4 is in place 6),
 *  the inverse will be 416253 (reading from right to left, 3 is in place 1, 5 is in place 2,2 is in place 3, 6 is in place 4, 1 is in place 5 and 4 is in place 6)
 *  More examples - inverse of 2134 is 1243 and inverse of 24153 is 24153
 */
object InverseOfANumber extends App {


  def inverse(n: Int, place: Int = 1, acc: Int = 0):Int = n match {
    case 0 => acc
    case _ => inverse(n / 10, place + 1, acc + (place * scala.math.pow(10, n % 10 - 1).toInt))
  }

  println(inverse(2134))
  println(inverse(24153))
  println(inverse(426135))
}
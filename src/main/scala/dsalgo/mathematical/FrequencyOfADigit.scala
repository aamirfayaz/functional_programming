package dsalgo.mathematical

/**
 * how many time a is in n digit number
 * e.g 1234534, a = 4, output = 2
 */

object FrequencyOfADigit extends App {

  def frequency(num: Int, a: Int, freq: Int = 0): Int = {
    if (num <= 0) freq else {
      num % 10 match {
        case x if x == a => frequency(num / 10, a, freq + 1)
        case _ => frequency(num / 10, a, freq)
      }
    }
  }

  println(frequency(1234564, 4))
  println(frequency(1234, 2))
  println(frequency(1234, 5))
}

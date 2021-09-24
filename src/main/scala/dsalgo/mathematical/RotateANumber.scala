package dsalgo.mathematical

//right rotation
// n=12345, k=2 :- 45123
object RotateANumber extends App {

  val numString =  "12345678"
  val num = numString.toInt
  val count = numString.length
  val shift = 3
  val k = shift % count

  def rotate(index: Int = 1, mul: Int = 1, div: Int = 1): (Int, Int) = {
    if (index <= count) {
      if (index <= k) rotate(index + 1, mul * 10, div)
      else rotate(index + 1, mul, div * 10)
    } else (div, mul)
  }

  val (mul, div) = rotate()

  val rem = num % div
  val quo = num / div
  val result = (mul * rem) + quo
  println(result)
 }
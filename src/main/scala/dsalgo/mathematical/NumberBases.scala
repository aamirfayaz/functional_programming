package dsalgo.mathematical


object DecimalToAnyBase extends App {


  def convert(num: Int, base: Int, p: Int = 1, acc: Int = 0): Int = num match {
    case 0 => acc
    case _ => convert(num / base, base, 10 * p, p * (num % base))
  }

 // println(convert(13, 2)) //to binary
 // println(convert(24, 2)) // to binary
  println(convert(13, 8)) // to ocatal
}
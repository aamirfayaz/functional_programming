package dsalgo.mathematical


object DecimalToAnyBase extends App {


  def convert(num: Int, base: Int, p: Int = 1, acc: Int = 0): Int = num match {
    case 0 => acc
    case _ => convert(num / base, base, 10 * p, acc + p * (num % base))
  }

  println(convert(13, 2)) //to binary
  println(convert(24, 2)) // to binary
  println(convert(13, 8)) // to ocatal
}

object AnyBaseToDecimal extends App {

  def convert(num: Int, base: Int, p: Int = 1, acc: Int = 0): Int = num match {
    case 0 => acc
    case _ => convert(num / 10, base, base * p, acc + p * (num % 10))
  }

  println(convert(1101, 2)) //from binary to decimal
  println(convert(15, 8)) // from ocatal to decimal
  println(convert(11, 8)) // from ocatal to decimal
}

object AnyBaseToAnyBase extends App {

   val binary = 1010101
  val sourceBase = 2 // binary
  val destBase = 8 // octal
  val sourceBaseToDecimal = AnyBaseToDecimal.convert(binary, sourceBase)
  val decimalToDestinationBase = DecimalToAnyBase.convert(sourceBaseToDecimal, destBase)
  println(decimalToDestinationBase)
}
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

/**
 * There are four rules that need to be followed when adding two binary numbers. These are:
 *
 * 0 + 0 = 0
 * 1 + 0 = 1
 * 1 + 1 = 10 (ans is 0 and carry forward 1)
 * 1 + 1 + 1 = 11 (answer is 1 and carry forward 1)
 */

object AnyBaseAddition extends App {
  def sum(num1: Int, num2: Int, base: Int, carry: Int = 0, pow: Int = 1, acc: Int = 0): Int = {
    (num1 <= 0, num2 <= 0, carry <= 0) match {
      case (true, true, true) => acc
      case (_, _, _)          =>
        val d1 = num1 % 10
        val d2 = num2 % 10
        val s = (d1 + d2 + carry)
        sum(num1 / 10, num2 / 10, base, s / base, pow * 10, acc + (pow * (s % base)))

    }
  }

  println(sum("101".toInt, "111".toInt, 2))
  println(sum("100".toInt, "100".toInt, 2))
  println(sum("27".toInt, "3".toInt, 8)) // ans:32
}

/**
 * Binary Subtraction
 * 0 – 0 = 0
 * 1 – 0 = 1
 * 1 – 1 = 0
 * 0 – 1 = 1 (Borrow 1 from the next higher order digit)
 *
 * Constraints:
 * 2 <= b <= 10
 * 0 <= n1 <= 256
 * n1 <= n2 <= 256
 *
 */

object AnyBaseSubstraction extends App {
  def substraction(num1: Int, num2: Int, base: Int, carry: Int = 0, pow: Int = 1, acc: Int = 0): Int = {
    (num1 <= 0, num2 <= 0, carry <= 0) match {
      case (true, true, true) => acc
      case (_, _, _)          =>
        val d1 = num1 % 10
        val d2 = (num2 % 10) - carry
        val (next, c) = if (d2 < d1) {
          ((d2 + base) - d1, 1)
        } else {
          (d2 - d1, 0)
        }
        substraction(num1 / 10, num2 / 10, base, c, pow * 10, acc + (pow * next))

    }
  }

  println(substraction("100".toInt, "111".toInt, 2))
  println(substraction("010".toInt, "101".toInt, 2))
  println(substraction("3".toInt, "32".toInt, 8)) // ans:27
}

object AnyBaseMultiplication extends App {
  def multiply(num1: Int, num2: Int, base: Int, sumPower: Int = 1, acc: Int = 0): Int = {
    if (num2 <= 0) acc else {
      //n1 is first numbers i.e num1's digits, n2 is each digit of num2
      def mul(n1: Int, n2: Int, carry: Int = 0, pow: Int = 1, sum: Int = 0): Int = (n1 > 0, carry > 0) match {
        case (false, false) => sum
        case _              => {
          val s = carry + ((n1 % 10) * n2)
          mul(n1 / 10, n2, s / base, pow * 10, sum + (pow * (s % base)))
        }
      }
      multiply(num1, num2 / 10, base, sumPower * 10, AnyBaseAddition.sum(acc, (mul(num1, num2 % 10) * sumPower), base))
    }
  }

  println(multiply(2156, 74, 8))
  println(multiply(25, 12, 8))
}
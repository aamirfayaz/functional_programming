package dsalgo.recursion

//using normal recursion, Time Complexity = power
object BasePower1 extends App {

  def basePower(power: Int, base: Int): Int = power match {
    case 0 => 1
    case _ =>
      val result = basePower(power - 1, base)
      result * base
  }

  println(basePower(3, 3))
  println(basePower(3, 5))
}

//tail-recursive,  Time Complexity = power
object BasePower2 extends App {

  def basePower(power: Int, base: Int, acc: Int = 1): Int = power match {
    case 0 => acc
    case _ => basePower(power - 1, base, base * acc)

  }

  println(basePower(3, 3))
  println(basePower(3, 5))
}

//Time Complexity of logn (n is power)
object BasePower3 extends App {

  def basePower(power: Int, base: Int): Int = power match {
    case 0 => 1
    case _ =>
      val result = basePower(power / 2, base)
      if (power % 2 == 1) base * (result * result) else result * result
  }

  println(basePower(8, 10))
  println(basePower(3, 3))
  println(basePower(3, 5))
}
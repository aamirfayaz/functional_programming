package dsalgo.mathematical

object BasePower extends App {

   def calculate(base: Int, power: Int, acc: Int = 1):Int = {
     if(power == 0) acc else {
       calculate(base, power - 1, acc * base)
     }
   }
  println(calculate(2, 3, 1))
  println(calculate(4, 3, 1))
  println(calculate(3, 3, 1))
}

object SumBasePowerTillN extends App {
  /**
   * We can count to 1023 by just using two hands
   */
  println {
    (1 to 9).map(x => BasePower.calculate(2, x)).sum + 1
  }
}
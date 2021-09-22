package dsalgo.mathematical

object BasePower extends App {

   def calculate(base: Int, power: Int, acc: Int):Int = {
     if(power == 0) acc else {
       calculate(base, power - 1, acc * base)
     }
   }
  println(calculate(2, 3, 1))
  println(calculate(4, 3, 1))
  println(calculate(3, 3, 1))
}
package dsalgo.mathematical

object PrimeNumbersCheck extends App {

  def isPrime(n: Int): Boolean = {
    (n > 1) && !(2 to scala.math.sqrt(n).toInt).exists(n % _ == 0)
  }

  println(isPrime(12))
  println(isPrime(100))
  println(isPrime(23))
}

object PrimeFactors extends App {

  def primeFactors(n: Int, div: Int = 2, result: List[Int] = Nil): List[Int] = ((div * div) > n) match {
    case true                  => n :: result
    case false if n % div == 0 => primeFactors(n / div, div, div :: result)
    case false                 => primeFactors(n, div + 1, result)
  }

  println(primeFactors(20))
  println(primeFactors(22))
  println(primeFactors(101))
  println(primeFactors(360))
}
package dsalgo.mathematical

object GCDLCM extends App {

  val n1 = 48
  val n2 = 18

  def euclid(n1: Int, n2: Int): Int = {
    if(n2 == 0) n1 else {
      euclid(n2, n1 % n2)
    }
  }
  val gcd = euclid(n1, n2)
  val lcm = (n1 * n2) / gcd

  println(gcd)
  println(lcm)
}
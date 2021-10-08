package dsalgo.mathematical

import scala.annotation.tailrec

object ReverseANumber extends App {

  val num = 234

  @tailrec
  def reverse(num: Int, rev: Int = 0): Int = num match {
    case 0 => rev
    case _ => reverse(num / 10, num % 10 + (rev * 10))
  }

  println(reverse(234))
  println(reverse(123))
}
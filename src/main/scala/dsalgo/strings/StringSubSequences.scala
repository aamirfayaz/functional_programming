package dsalgo.strings

/*
  for s = abc, n = 3
  substrings are contagious and equal to n(n + 1) / 2, s = abc, n(substrings) = 6
  subsequences are not contagious and equal to 2 power n, s = abc, n(subsequences) = 8

  Time Complexity : O(n)
 */
object StringSubSequences extends App {

  val s = "abc"

  def subSequences(s: String, acc: List[String] = Nil): List[String] = {
    if (s.isEmpty) "" :: acc
    else {
      val ch = s.charAt(0)
      val result = subSequences(s.substring(1), acc)
      val newList = result.map { x => ch + x }
      result ++ newList
    }
  }

  val res = subSequences(s)
  println(res)
  println(res.length)
}

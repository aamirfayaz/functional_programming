package dsalgo.strings

/*
//https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get_subsequence/topic
  for s = abc, n = 3
  substrings are contagious and equal to n(n + 1) / 2, s = abc, n(substrings) = 6 [a,b,c,ab, bc, abc]
  subsequences are not contagious and equal to 2 power n, s = abc, n(subsequences) = 8 [_, a, b, c, ab, bc, abc, ac]

  Time Complexity : O(n)
 */
object StringSubSequences extends App {

  val s = "abc"

  def subSequences(s: String, acc: List[String] = Nil): List[String] = {
    if (s.isEmpty) "" :: acc
    else {
      val ch = s.charAt(0)
      val result: List[String] = subSequences(s.substring(1), acc)
      val newList: List[String] = result.map { x => ch + x }
      result ++ newList
    }
  }

  val res = subSequences(s)
  println(res)
  println(res.length)
}

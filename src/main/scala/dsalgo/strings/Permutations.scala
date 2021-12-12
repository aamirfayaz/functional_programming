package dsalgo.strings

import scala.annotation.tailrec

/**
    int len = str.length();
    int total = factorial(len);

    for (int number = 0; number < total; number++) {
      StringBuilder sb = new StringBuilder(str);
      int temp = number;

      for (int divisor = len; divisor >= 1; divisor--) {
        int q = temp / divisor;
        int r = temp % divisor;

        System.out.print(sb.charAt(r));
        sb.deleteCharAt(r);
        temp = q;
      }
      System.out.println();
    }
 */

//https://www.pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/print-all-permutations-of-a-string-iteratively-official/ojquestion
object Permutations extends App {

    val inputString = "abc"

    def factorial(n: Int, acc: Int = 1):Int = {
      if(n == 1) acc else factorial(n - 1, acc * n)
    }
   val l = inputString.length
   val f = factorial(l)


//O(n! * n)
@tailrec
def permuatations(n: Int, l: Int, acc: List[String] = Nil):List[String] = {
     if(n == f) acc else {
        def inner(index: Int, div: Int, str: String, acc: String = ""):String = {
          if(index == 0) acc else {
            val take = div % index
            val rest = str.substring(0, take) + str.substring(take + 1) //=== deleteCharAtIndex
            inner(index - 1, div / index, rest, acc + str.charAt(take).toString)
          }
        }
       permuatations(n + 1, l,  inner(l, n, inputString) :: acc)
     }
   }
  val res = permuatations(0, l)
  println(res)
}
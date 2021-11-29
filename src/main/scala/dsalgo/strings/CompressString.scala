package dsalgo.strings

/**
 * Input: aaabbccccdee
 * output: a3b2c4de2
 */

object CompressString extends App {

   def compression(s: String, acc: String = ""):String = {
       if(s.isEmpty) acc else {
         val c = s.charAt(0)
         val f: Char => Boolean = _ == c
         compression(s.dropWhile(f), acc + (c + s.count(f).toString))
       }
   }

  println(compression("aaabbccccdee"))

}
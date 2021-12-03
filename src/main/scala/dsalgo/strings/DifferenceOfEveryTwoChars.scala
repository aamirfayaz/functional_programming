package dsalgo.strings

object DifferenceOfEveryTwoChars extends App {
   //O(n)
   // I am not checking for emptiness on last
   val input = "abecd"
   val result = input.zip(input.tail).foldLeft[String]("") { (acc, tup) =>
      val diff = tup._2 - tup._1
      acc + s"${tup._1}${diff}"
   }
   println(result + input.last)

}
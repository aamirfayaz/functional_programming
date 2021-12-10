package dsalgo.strings

/**
   uc - 'A' = lc - 'a'
   so, lc = uc + 'a' - 'A'
   and, uc = 'A' + lc - 'a'
 */
object ToggleCase extends App {

   val input1 = "pepCODinG"
   val input2 = "pep123DinG"

    def toggleCase(str: String, acc: String = ""):String = {
      if(str.isEmpty) acc else {
        val c = str.charAt(0)
        if(c >= 'a' && c <= 'z') {
          val uc = 'A' + (c - 'a')
          toggleCase(str.tail, acc + uc.toChar)
        } else if(c >= 'A' && c <= 'Z') {
          val lc = 'a' + (c - 'A')
          toggleCase(str.tail, acc + lc.toChar)
        } else toggleCase(str.tail, acc + c)
      }
    }
   val result1:String = toggleCase(input1)
   val result2:String = toggleCase(input2)

   println(result1)
   println(result2)

}
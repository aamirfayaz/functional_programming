package scalaconcepts.functions.partialfunctions



object PF1 extends App {

  /**
  The main distinction between PartialFunction and Function1 is that the user of a PartialFunction
  may choose to do something different with input that is declared to be outside its domain. For example:
   */
  val sample = 1 to 10
  val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x+" is even"
  }

  // the method collect can use isDefinedAt to select which members to collect
  val evenNumbers = sample collect isEven

  val isOdd: PartialFunction[Int, String] = {
    case x if x % 2 == 1 => x+" is odd"
  }

  // the method orElse allows chaining another partial function to handle
  // input outside the declared domain
  val oddEven = isEven orElse isOdd
  println(oddEven)
}
object DiffPFF1 extends App {

  /*   val pF = new PartialFunction[String, Int] {
       override def isDefinedAt(x: String): Boolean = ???

       override def apply(v1: String): Int = v1.length

     }*/

  val pF: PartialFunction[String, String] = {
    case s: String if s.length == 3 => s
  }

  val f1: String => String = (x: String) => {
    if(x.length() == 3) x
    else throw new Exception("Match Error")
  }

  val l = List( "aaa", "l", "aaa", "def")


  println {
    l.map(f1)
  }
}
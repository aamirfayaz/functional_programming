package pastinterviews

//leon teq
//check if no is divisible by 3 or 5 or both, if 3 print hi if 5 print bye if both print hibye
//use f-values for condition check for optimisation

object IfElseTest extends App {

   val curr = System.currentTimeMillis() / 1000
  (1 to 100000000).foreach { num =>
    if(num % 3 == 0 && num % 5 ==0) println("hi")
    else if(num % 3 == 0) println("hello")
    else if(num % 5 == 0) println("hihello")
    else println(num)
  }
  val now = System.currentTimeMillis() / 1000
  //Program took 78 seconds to finish
  println(s"Program took ${now - curr} seconds to finish")
}
/*val c2 = f(num)
val c3 = g(num)
val c1 = c2 && c3*/
object IfElseOptimized extends App {

  val f = (x: Int) => x % 3 == 0
  val g = (x: Int) => x % 5 == 0

  val curr = System.currentTimeMillis() / 1000
  (1 to 100000000).foreach { num =>
   /* val c1 = f(num) && g(num)
    val c2 = f(num)  bad
    val c3 = g(num)*/
    val c2 = f(num)
    val c3 = g(num)
    val c1 = c2 && c3
    if(c1) println("hi")
    else if(c2) println("hello")
    else if(c3) println("hihello")
    else println(num)
  }
  val now = System.currentTimeMillis() / 1000
  //Program took 68 seconds to finish
   println(s"Program took ${now - curr} seconds to finish")
}


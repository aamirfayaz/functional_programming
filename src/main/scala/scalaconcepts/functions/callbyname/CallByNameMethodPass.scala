package scalaconcepts.functions.callbyname

object CallByNameMethodPass extends App {

  def method[A, B](f: B => A, x: B):A = {
    f(x)
  }

  val f = (x: String) => ((x charAt 0).toString + ".").length
  //val result = method[Int, String](f, "hello")
  //println(result)

  def lazyMethod[A](g: => A):A = {
    println("start of execution")
    println("waiting for 6 seconds, nothing is happening...")
    Thread.sleep(6000)
    val res = g
    println("end of execution")
    res
  }

  val lazyResult = lazyMethod[Int] {
    method(f, "hello")
  }
}

object CallByNameWithAwait extends App {

  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import duration._

  val f = Future { Thread.sleep(2000); 10}

  def timeTaken[A](fn: => A): A = {
    val startTime = System.currentTimeMillis()
     val r = fn
    val endTime = System.currentTimeMillis()
    println(s"time taken: ${endTime - startTime}ms")
    r
  }

  val result: Int = timeTaken {
    Await.result(f, 3.seconds)
  }
  println(result)
}
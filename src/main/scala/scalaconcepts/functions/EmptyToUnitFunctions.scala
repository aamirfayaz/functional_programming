package scalaconcepts.functions

object EmptyToUnitFunctions extends App {
  private val initCode = new scala.collection.mutable.ListBuffer[() => Unit]

  def delayExecution(body: => Unit) = {
    initCode += (() => body)
  }
 // val res:Unit = Thread.sleep(6000)
  val res = () => Thread.sleep(6000)
  delayExecution(res())

  for (proc <- initCode) proc()

  //println(sys.props("scala.time"))
}

object EmptyT1 extends App {

  val justDoSomething: () => Int = () => 3
  println(justDoSomething) // function itself
  println(justDoSomething()) // call
}
package scalaconcepts.functions

object SetAsFunction1 extends App {

  val str = "hello hi"
  val set = scala.collection.immutable.Set('a', 'e', 'i', 'o', 'u')

  def count(f: Char => Boolean) = {
    object counter extends Function1[Char, Unit] {
      var result = 0

      override def apply(v1: Char): Unit = if (f(v1)) result += 1
    }
    str.foreach(x => counter(x))
    counter.result
  }

  val result = count(set)
  println(result)
}
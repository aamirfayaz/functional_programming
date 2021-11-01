package scalaconcepts

object ListParallel extends App {

   import scala.collection.parallel.CollectionConverters._



  val from: Int = 0
  val end: Int = 12
  // have fun with the step. You know "Range" now.
  val step: Int = 2
  val expected: Int = 49

  val result1: Int = (from to end by step).map { a =>
    val adder: Int = 1
    println(s"#seq> $a + $adder")
    a + adder
  }.sum
  assert(result1 == expected, result1)

  println("With 'par':")
  val result2: Int = (from to end by step).par.map { a =>
    val adder: Int = 1
    println(s"#par> $a + $adder")
    a + adder
  }.sum
  assert(result2 == expected, result2)
}
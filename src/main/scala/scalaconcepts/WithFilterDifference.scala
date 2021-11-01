package scalaconcepts

import scalaconcepts.WithFilterDifference1.result

object WithFilterDifference1 extends App {

  val list = List(1, 2, 3)
  var go = true
  val result = for(i <- list; if(go)) yield {
    go = false
    i
  }
  println(result)
}

//Prior Scala 2.8, for-comprehension were translated into something like the following:

object WithFilterDifference2 extends App {
  val list = List(1, 2, 3)
  var go = true

  val result = list filter {
    case i => go
  } map {
    case i =>
      go = false
      i
  }
  println(result)

}

/**
 * Using filter, the value of result would be fairly different: List(1, 2, 3).
 * The fact that we're making the go flag false has no effect on the filter, because the filter is already done.
 * Again, in Scala 2.8, this issue is solved using withFilter.
 * When withFilter is used, the condition is evaluated every time an element is accessed inside a map method
 */

object WithFilterDifference3 extends App {

  val list = List(1, 2, 3)
  var go = true
  val result = list withFilter {
    case i => go
  } map {
    case i => {
      go = false
      i
    }
  }
  println(result)
}


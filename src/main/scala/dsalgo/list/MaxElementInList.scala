package dsalgo.list

import utilities.ListUtilities

//https://stackoverflow.com/questions/19044114/how-to-find-the-largest-element-in-a-list-of-integers-recursively/19045201

object MaxElementInList extends App {

  val l = ListUtilities.getUniquesList
  println(l)

  def findMax[T](l: List[T])(implicit c: Ordering[T]):T = l match {
    case h :: Nil => h
    case h :: next :: tail => {
      val m = if(c.gt(h, next)) h else next
      findMax(m :: tail)
    }
  }

  println(findMax(l))

  def maxReduce[T](l: List[T])(implicit c: Ordering[T]):T = {
    l.reduce{(a, b) => if(c.gt(a, b)) a else b}
  }

  println(maxReduce(l))
}
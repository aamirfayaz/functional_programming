package dsalgo

object Ordering1 extends App {
  sealed case class A(tag: String, load: Int)

  val l = List(A("words", 50), A("article", 2), A("lines", 7))
  //l.sorted //CTE, no implicit ordering of type Ordering[A]
}

object Ordering2 extends App {
  /**
   * we can use the sortBy method as long there is an Ordering field type in scope:
   * here tag field has default Ordering in scope
   */
  sealed case class A(tag: String, load: Int)

  val l = List(A("words", 50), A("article", 2), A("lines", 7))

  val result: List[A] = l.sortBy(_.tag)
  println(result)
}

object Ordering3 extends App {
  /**
   * Defining Ordering for sorted
   */

  sealed case class A(tag: String, load: Int) extends Ordered[A] {
    override def compare(that: A): Int = this.tag.compareTo(that.tag)
  }

  val l = List(A("words", 50), A("article", 2), A("lines", 7))
  val result: List[A] = l.sorted
  println(result)
}

object Ordering4 extends App {
  /**
   * Custom Ordering
   */

  sealed case class A(tag: String, load: Int)

  object A {
    val tagOrdering = Ordering.by { foo: A =>
      foo.tag
    }

    val loadOrdering = Ordering.by { foo: A =>
      foo.load
    }
  }

  // implicit val ord1 = A.tagOrdering
  // val l1 = List(A("words", 1), A("article", 2), A("lines", 3)).sorted
  // println(l1)
  // now in some other scope
  implicit val ord2 = A.loadOrdering
  val l2 = List(A("words", 1), A("article", 2), A("lines", 3)).sorted
  println(l2)
}

object NoOrdering extends App {
  /**
   * If we want to forget about Ordering, we can use the sortWith method,
   * which sorts elements according to the given comparison function:
   */
  sealed case class User(name: String, age: Int)

  val users = List(
    User("Mike", 43),
    User("Mike", 16),
    User("Kelly", 21)
  )
  val result: Seq[User] = users.sortWith(_.age > _.age)
  println(result)

}

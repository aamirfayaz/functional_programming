def find[A](xs: List[A], predicate: A => Boolean): Option[A] = {
  xs match {
    case Nil => None
    case head :: tail =>
      if (predicate(head)) Some(head) else find(tail, predicate)
  }
}
//find(List(1,2,3,4), x => x % 2 == 0) //CTE, not able to infer x
find(List(1,2,3,4), (x: Int) => x % 2 == 0)

  //currying to the rescue
  def find[A](xs: List[A])(predicate: A => Boolean): Option[A] = {
    xs match {
      case Nil => None
      case head :: tail =>
        if (predicate(head)) Some(head) else find(tail, predicate)
    }
  }
find(List(1,2,3,4))(x => x % 2 == 0)

/**
 * This tiny change will help the compiler resolve the type properly.
 * After passing the list of Ints into the first argument list,
 * the compiler will know that we are working with Ints and use this
 * information to infer that the predicate should have type Int => Boolean.
 */
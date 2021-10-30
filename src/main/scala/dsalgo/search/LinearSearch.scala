package dsalgo.search

object LinearSearch extends App {

  def search[A](list: List[A], elem: A): Boolean = list match {
    case Nil                    => false
    case h :: _ if h == elem => true
    case _                      => search(list.tail, elem)
  }
  println(search(List(1,2,3,4,5,6), 4))
  println(search(List(1,2,3,4,5,6), 8))
}
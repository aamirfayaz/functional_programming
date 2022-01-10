package dsalgo.list

object ListHalfElements extends App {

  def listOfLists(strings: String*) = {
    def inner(l: List[String], acc: List[List[String]]) = l match {
      case Nil              => acc
      case list@List(_) => (list.tail, list :: acc)
    }

    val l: List[String] = strings.toList
    inner(l, Nil)
  }

  println(listOfLists("hello", "world"))
  //listOfLists("Hello", "World") should be(List(List("Hello", "World"), List("World")))
  //listOfLists("Hello", "There", "World") should be(List(List("Hello", "There", "World"), List("There", "World"), List("World")))
}
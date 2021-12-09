abstract class Food {
  def name: String
}

trait Fruit extends Food

case class Apple(val name: String) extends Fruit
case class orange(val name: String) extends Fruit

val apple: Apple = Apple("apple")
val org: orange = orange("Orange")


case class Box[+T <: Fruit](f: T) {
  def fruitList: List[T] = List(f)
  //def add(i: T): List[T] = i :: fruitList
  def add[M >: T](i: M): List[M] = i :: fruitList

  /*val a: Box[Apple] = Box(Apple("apple"))
  val b: Box[Fruit] = a
  b.add(new)*/
}

/*val a: Box[Apple] = Box(Apple("apple"))
val b: Box[Fruit] = a
b.add(new Orange)*/

case class FanClub[-T](s: String)


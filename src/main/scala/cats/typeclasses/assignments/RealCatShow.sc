
import cats.Show
/*import cats.instances.string._
import cats.instances.int._*/
import cats.implicits._

case class Cat(name: String, age: Int, color: String)

implicit val showCats:Show[Cat] = Show.show[Cat] { cat =>
  val name = Show.apply[String].show(cat.name)
  val age = Show.apply[Int].show(cat.age)
  val color = Show.apply[String].show(cat.color)
  s"$name is a $age year-old $color cat"
}

import cats.syntax.show._

Cat("pussy",4, "black").show


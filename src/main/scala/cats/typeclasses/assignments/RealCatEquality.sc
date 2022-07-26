import cats.Eq

sealed case class Cat(name: String, age: Int, color: String)

implicit val catEqInstance: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) =>
  (cat1.name == cat2.name) && (cat1.age == cat2.age) && (cat1.color == cat2.color)
}

val cat1 = Cat("Garfield", 12, "black")
val cat2 = Cat("Tom", 11, "white")

import cats.syntax.eq._

cat1 === cat2
cat1 =!= cat2

val oCat1 = Option(Cat("Garfield", 12, "black"))
val oCat2 = Option.empty[Cat]

import cats.instances.option._
oCat1 === oCat2

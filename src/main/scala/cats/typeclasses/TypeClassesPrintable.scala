package cats.typeclasses

final case class Cat(name: String, age: Int, color: String)

trait Printable[A] {
  def format(a: A):String
}

object PrintableInstances {
  implicit val intInstance = new Printable[Int] {
    override def format(a: Int): String = a.toString
  }
  implicit val stringInstance = new Printable[String] {
    override def format(a: String): String = a
  }

  implicit val catInstance = new Printable[Cat] {
    override def format(c: Cat): String = {
      s"Name is ${c.name}, AGE ${c.age}, COLOR ${c.color}"
    }
  }
}

object Printable {
  def format[A](value: A)(implicit print: Printable[A]):String = print.format(value)
  def printt[A](value: A)(implicit print: Printable[A]):Unit = println(format(value))
}


object PrintableSyntax {
  implicit class PrintableOps[A](a: A) {
    def format(implicit p: Printable[A]): String = {
      p.format(a)
    }
    def print(implicit p: Printable[A]): Unit = {
      println(format)
    }
  }
}

object PrintIntefaceObjectCheck extends App {

  import Printable._
  import PrintableInstances._

  println(s"Format: ${format(10001)}")
  printt("James")
}


object PrintIntefaceSyntaxCheck extends App {
  import PrintableSyntax._
  import PrintableInstances._

  Cat("Timmy", 4, "Blue").print
}

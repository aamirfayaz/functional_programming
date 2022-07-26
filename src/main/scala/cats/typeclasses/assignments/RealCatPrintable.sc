trait Printable[A] {
  def format(a: A): String
}

implicit object IntPrintable extends Printable[Int] {
  override def format(a: Int) = a.toString
}

implicit object StringPrintable extends Printable[String] {
  override def format(a: String) = a
}

//interface object
object Printable {
  def format[A](a: A)(implicit p: Printable[A]): String = p.format(a)

  def print[A](a: A)(implicit p: Printable[A]): Unit = println(format(a))
}

case class Cat(name: String, age: Int, color: String)


//interface syntax
object PrintableSyntax {
  implicit class PrintableOps[A](a: A) {
     def format(implicit p:Printable[A]) = p.format(a)
     def print(implicit p:Printable[A]) = println(format)
  }
}

//cat TC instance
implicit val catPrintable: Printable[Cat] = new Printable[Cat] {
  override def format(a: Cat) = {
    val name = Printable.format(a.name)
    val age = Printable.format(a.age)
    val color = Printable.format(a.color)
    s"$name is a $age year-old $color cat"
  }
}

import PrintableSyntax._
Cat("pussy", 10, "blue").format


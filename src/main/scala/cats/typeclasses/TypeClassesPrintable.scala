package cats.typeclasses

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
}

object Printable {
  def format[A](value: A)(implicit print: Printable[A]):String = print.format(value)
  def print[A](value: A)(implicit print: Printable[A]):Unit = println(format(value))
}
package scalaconcepts

class Person(
              // 'val' to make the fields "public"
              val firstName: String,
              val lastName: String
            ) {
  lazy val fullName: String = s"$firstName $lastName"

  def apply(talk: String): String = s"$fullName says: '$talk'"

  override def toString: String = s"Person($firstName, $lastName)"
}

object Person {

  def apply(firstName: String, lastName: String): Person = {
    new Person(firstName, lastName)
  }

  // "enhanced" constructor
  def apply(fullName: String): Person = {
    val parts: Array[String] = fullName.split(" ")
    val firstName: String = parts.lift(0).getOrElse("N/A")
    val lastName: String = parts.lift(1).getOrElse("N/A")
    // instantiating the class
    new Person(firstName, lastName)
  }
}

object PersonApplyTest extends App {

  val tesla: Person = Person("Nikola", "Tesla")
  //val tesla: Person = Person.apply("Nikola", "Tesla")
  println(tesla)

  val eddison: Person = Person("Thomas Edison")
  //val eddison: Person = Person.apply("Thomas Edison")
  println(eddison)

  // use the apply inside the class
  println(tesla("I want to help bring free energy to the world!"))
 // println(tesla.apply("I want to help bring free energy to the world!"))
  //println(eddison("some text"))
  println(eddison.apply("some text"))
}
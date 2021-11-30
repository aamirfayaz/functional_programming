/**
class Pets[+A](val pet:A) {
  def add(pet2: A): String = "done"
}

  val pets: Pets[Animal] = Pets[Cat](new Cat)

 */

/**
class Pets[-A](val pet:A)
val pets: Pets[Cat] = Pets[Animal](new Animal)
 */

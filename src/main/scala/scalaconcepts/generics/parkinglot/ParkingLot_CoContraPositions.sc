/**
 * https://apiumhub.com/tech-blog-barcelona/scala-generics-covariance-contravariance/
class Pets[+A](val pet:A) {
  def add(pet2: A): String = "done"
}

  val pets: Pets[Animal] = Pets[Cat](new Cat)

 */

/**
class Pets[-A](val pet:A)
val pets: Pets[Cat] = Pets[Animal](new Animal) //
 we assume pets is a cat and we think we can do pets.meow(), but no, its an ANimal
 */

/**
abstract class Pets[-A] {
  def show(): A
}
*/

/**

trait Function1[-T, +R] extends AnyRef {
  def apply(v1: T): R
}

 */

class Animal
class Dog extends Animal
class Bulldog extends Dog
class Cat extends Animal

val doSomething: Bulldog => Animal = (bulldoggy) => new Animal

val doSomething:(Bulldog => Animal) = (bulldoggy) => new Cat
val doSomething:(Bulldog => Animal) = (bulldoggy) => new Dog
val doSomething:(Bulldog => Animal) = (bulldoggy) => new Bulldog
val doSomething:(Bulldog => Animal) = (bulldoggy) => new Animal

val doSomething:(Bulldog => Animal) = (doggy: Dog) => new Animal
val doSomething:(Bulldog => Animal) = (animal: Animal) => new Animal
//val doSomething:(Bulldog => Animal) = (kitty: Cat) => new Animal

def someMethod(f: Dog => Animal) = ???
val g: Bulldog => Animal = ???
val h: Animal => Animal
//someMethod(g)
someMethod(h)
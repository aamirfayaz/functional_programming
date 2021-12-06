//https://dev.to/jmcclell/inheritance-vs-generics-vs-typeclasses-in-scala-20op
/**
What is Polymorphism?
The idea behind polymorphism is always the same: we are trying to increase code re-use by writing code
in a more generic fashion.
That is to say, in a higher level of abstraction.
There are three main forms of polymorphism:

Subtype Polymorphism (Inheritance)
when a name denotes instances of many different classes related by some common superclass

Parametric Polymorphism (Generics)
when one or more types are not specified by name but by abstract symbols that can represent any type

Ad-Hoc Polymorphism (Type Classes)
defines a common interface for an arbitrary set of individually specified types
 */

/**
Example without subtype polymorphism:

class Cat {
  val meow = "meow"
}

class Dog {
  val bark = "woof!"
}

def dogSpeak(d: Dog) = println(d.bark)
def catSpeak(c: Cat) = println(c.meow)

Here, it's obvious we would like to define a singular behavior, that of the ability to speak
**/

/*class Cat {
  val meow = "meow"
}

class Dog {
  val bark = "woof!"
}*/

/**
But, we lose static type checking because all type checking is done at runtime here.
Not only that, but we also have to continually modify this method
as we add more animals that can speak to our program.
 */
/*
def speak(v: Any): String = v match {
  case v: Dog => v.bark
  case c: Cat => c.meow
}
speak(new Dog())*/

trait Animal {
  def sound: String
}
class Cat extends Animal {
  val sound: String = "meow"
}
class Dog(val sound: String = "woof") extends Animal

def speak(a: Animal) = println(a.sound)
speak(new Cat())
speak(new Dog())

/**
 * Subtype polymorphism allows us to reduce boiler-plate
 * Parametric polymorphism allows us to reduce boiler-plate by writing code that can work uniformly
   over a range of types by using type parameters
   e.g n Array type can work for any type T because its implementation doesn't depend on any type-specific behavior -
   the Array implementation is uniform across all types.

 * In subtype polymorphism, we lose type information
 */


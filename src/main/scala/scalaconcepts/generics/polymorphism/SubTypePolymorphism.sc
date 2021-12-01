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

class Cat {
  val meow = "meow"
}

class Dog {
  val bark = "woof!"
}

def speak(v: Any) = v match {
  case v: Dog => v.bark
  case c: Cat => c.meow
}
speak(new Dog())
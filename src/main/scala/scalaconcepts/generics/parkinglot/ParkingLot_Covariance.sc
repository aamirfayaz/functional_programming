/**
 * A generic class (List[T]) covariant over its abstract type(or type parameter T)
 * can receive a parameter type (List[Int], Int is parameter type) of that type or subtypes of that type.
 */
trait Thing
trait Vehicle extends Thing
class Car extends Vehicle
class Jeep extends Car
class Coupe extends Car
class Motorcycle extends Vehicle

case class Parking[+A](value: A)
val p1: Parking[Vehicle] = Parking[Car](new Car)

/**
 * But do not forget that although p1 is typed as Parking[Vehicle],
 * it is actually a Parking[Car],
 */
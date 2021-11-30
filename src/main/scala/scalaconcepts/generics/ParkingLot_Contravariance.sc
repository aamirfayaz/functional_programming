/*
A generic class contravariant over its parameter type,
can receive a parameter type of that type or supertypes of that type
 */
trait Thing
trait Vehicle extends Thing
class Car extends Vehicle
class Jeep extends Car
class Coupe extends Car
class Motorcycle extends Vehicle

case class Parking[-A]()
val p1: Parking[Car] = Parking[Vehicle]

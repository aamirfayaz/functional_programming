trait Thing
trait Vehicle extends Thing
class Car extends Vehicle
class Jeep extends Car
class Coupe extends Car
class Motorcycle extends Vehicle

case class Parking[A](value: A)

//val p1: Parking[Vehicle] = Parking[Car](new Car)
val p1 = Parking[Vehicle](new Motorcycle)
//However, once the abstract type(type-parameter) is defined,
// it can be used freely within the class,
// applying the Liskov substitution principle:
val x: Class[_ <: Vehicle] = p1.value.getClass
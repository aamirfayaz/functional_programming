
trait Thing
trait Vehicle extends Thing
class Car extends Vehicle
class Jeep extends Car
class Coupe extends Car
class Motorcycle extends Vehicle
class Vegetable
class Parking[A <: Vehicle](val place: A)

new Parking[Motorcycle](new Motorcycle)
//new Parking[Motorcycle](new Car)
new Parking[Car](new Jeep)


class Parking[A <: Vehicle](val place1: A, val place2: A)
new Parking(new Car, new Motorcycle) // LUB is Vehicle

//new Parking[Vegetable](new Vegetable())
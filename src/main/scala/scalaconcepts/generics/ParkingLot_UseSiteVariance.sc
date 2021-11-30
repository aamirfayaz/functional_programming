trait Thing
class Vehicle extends Thing
class Car extends Vehicle
class Jeep extends Car
class Coupe extends Car
class Motorcycle extends Vehicle
class Bicycle extends Vehicle
class Tricycle extends Bicycle

class Parking[A](val place: A){
  //def dosomething[B <: Vehicle](p1: Parking[B]) {}
  def dosomething(p1: Parking[_ <: Vehicle]): Unit = {}
}


val parking = new Parking(new Car())

parking.dosomething(new Parking(new Bicycle())) //
//parking.dosomething(new Parking[Jeep](new Jeep())), won't work
//if doSomething(p1: Parking[Vehicle])so we use site-variance

//parking.dosomething(new Parking(new AnyRef()))


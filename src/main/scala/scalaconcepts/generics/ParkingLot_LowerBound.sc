//https://apiumhub.com/tech-blog-barcelona/scala-type-bounds/
/**
 * Lower-Bounds: one use case:
 * They are used to put a covariant type in a contravariant position
 * and reverse for upper-bound
 */
trait Thing
class Vehicle extends Thing
class Car extends Vehicle
class Jeep extends Car
class Coupe extends Car
class Motorcycle extends Vehicle
class Bicycle extends Vehicle
class Tricycle extends Bicycle

//Can we limit Parking to all the subtypes of Vehicles,
// above Tricycle?

class Parking[A >: Bicycle <: Vehicle](val plaza: A)

//new Parking(new AnyRef)
new Parking(new Bicycle())
//new Parking[Tricycle](new Tricycle())
new Parking(new Tricycle()) //type inferred to LUB, Bicycle



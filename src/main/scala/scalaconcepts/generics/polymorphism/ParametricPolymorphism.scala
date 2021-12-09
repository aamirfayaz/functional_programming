/**
Parametric polymorphism allows us to reduce boiler-plate by writing code that can work uniformly over a range of types
by using type parameters. An Array type can work for any type T because its implementation doesn't depend on any
type-specific behavior - the Array implementation is uniform across all types.
--Java arrays are co-variant
trait Array {
  def set(index: Int, item: ???): Array
  def get(index: Int): ???
}

 trait Array {
  def set(index: Int, item: Any): Array
  def get(index: Int): Any
}
println(strings.get(0) + strings.get(1)) // strings.get(0) and strings.get(1) are both of type Any
 // ERROR!
 // type mismatch;
 //   found   : Any
 //   required: String


 trait StringArray {
  def set(index: Int, item: String): StringArray
  def get(index: Int): String
}

trait IntArray {
  def set(index: Int, item: Int): IntArray
  def get(index: Int): Int
}

 trait Array[T] {
   def set(index: Int, item: T): Array
   def get(index: Int): T
}


 */
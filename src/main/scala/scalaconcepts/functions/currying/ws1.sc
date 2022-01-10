//https://www.baeldung.com/scala/currying
//1. currying helps compiler to infer types
def find[A](xs: List[A], predicate: A => Boolean): Option[A] = {
  xs match {
    case Nil => None
    case head :: tail =>
      if (predicate(head)) Some(head) else find(tail, predicate)
  }
}
//find(List(1,2,3,4), x => x % 2 == 0) //CTE, not able to infer x
find(List(1,2,3,4), (x: Int) => x % 2 == 0)

  //currying to the rescue
  def find[A](xs: List[A])(predicate: A => Boolean): Option[A] = {
    xs match {
      case Nil => None
      case head :: tail =>
        if (predicate(head)) Some(head) else find(tail)(predicate)
    }
  }
find(List(1,2,3,4))(x => x % 2 == 0)

/**
 * This tiny change will help the compiler resolve the type properly.
 * After passing the list of Ints into the first argument list,
 * the compiler will know that we are working with Ints and use this
 * information to infer that the predicate should have type Int => Boolean.
 */

//currying makes our code flexible

def sum(f: Int => Int)(a:Int, b:Int):Int = f(a) + f(b)

//now, I can pass in any behaviour, like identity, cube
val sumF: (Int,Int) => Int = sum(identity)
val sumSquare:(Int, Int) => Int = sum(x => x * x)

println(sumF(1,2))
println(sumSquare(1,2))
//We can go even further to create the increment and decrement functions based on the sum function.

val increment: Int => Int = sumF.curried(2)
val decrement: Int => Int = sumF.curried(2)

increment(4)
decrement(-4)
//Curried functions are useful when one argument function is expected.

val l = List(1,2,3)
val s:(Int, Int) => Int = _ + _

l.map(x => s(1, x))

val s2: Int => Int => Int = x => y => x + y
l.map(s2(1))
//so, we improved our our code readability

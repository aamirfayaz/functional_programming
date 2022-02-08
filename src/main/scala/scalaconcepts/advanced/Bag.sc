//https://functional.works-hub.com/learn/understanding-functor-and-monad-with-a-bag-of-peanuts-50ec7

/**
 * Functor: the bag with unit and map makes a functor
 */
class Bag[A](content: A) {
  def map[B](f: A => B):Bag[B] = {
    Bag(f(content))
  }

  def flatMap[B](f: A => Bag[B]):Bag[B] = f(content)
  def flatten:A = content
  override def toString: String = s"Bag($content)"
}

object Bag {
  def unit[A](a: A): Bag[A] = new Bag(a)
  def apply[A](a: A):Bag[A] = unit(a)
}


case class Sugar(weight: Double)
case class Peanuts(weight: Double)
case class RoastedPeanuts(weight: Double)

//half the sugar e.g
val halfTheSugar = (x: Sugar) => Sugar(x.weight / 2)

val sugarBag: Bag[Sugar] = Bag(Sugar(100.2))
val halfSugar: Bag[Sugar] = sugarBag.map(halfTheSugar)

//laws
/** 1. identity law
 Functor[X].map(x => identity(x)) == Functor[X]
    or
Functor[X].map(identity) == Functor[X]
*/
def identity[A](a: A):A = a
val r1 = sugarBag.map(x => identity(x))

/** 2. associative law
Functor[X].map(f).map(g) == Functor[X].map(x => g(f(x))
This law allows us to chain map function calls
instead of composing multiple functions and then
applying them in a single map operation
 */

  val f1 = (x: Sugar) => Peanuts(x.weight)
  val g1 = (x: Peanuts) => RoastedPeanuts(x.weight)
val e1 = sugarBag.map(f1).map(g1)
val e2 = sugarBag.map(x => g1(f1(x)))
//e1 == e2

/**
 * Functor example in scala: List, Option, Try, Either, Future
 */
val x: Option[Int] = Some(1)
val y: Int = 2
val m: Int = 2
//val z = if(x.isDefined) Some((x.get + y) * m) else None
val z = x.map(a => (a+y) * m)
//or with the help of associative law
val z = x
  .map(_ + y)
  .map(_ * m)

/**
 * Monad: The bag with unit and flatMap makes a Monad.
 */
val triple = (x: Sugar) => Bag(Sugar(x.weight * 3))
val sBag = Bag(Sugar(2))
val x1 = sBag.map(triple)
val x2 = sBag.flatMap(triple)
val x3 = sBag.map(triple).flatten

//* Monad laws
/**
 1. Left-identity law
 unit(x).flatMap(f) = f(x)
 */
val lI1 = sBag.flatMap(triple)
val lI2 = triple(Sugar(2))

val value1 = 1
val option1: Option[Int] = Some(value1)
val of1: Int => Option[Int] = x => Option(x)
option1.flatMap(of1) == of1(value1)

/**
1. right-identity law
  Monad[X].flatMap(unit) == Monad[X]
 */

//val rI1 = sBag.flatMap(x => Bag.unit(x)) same as
val rI1 = sBag.flatMap(Bag.unit)
val rI2 = sBag

val op2:Option[Int] = Some(10)
op2.flatMap(Some(_)) == op2

/**
1. right-identity law
  Monad[X].flatMap(unit) == Monad[X]
 */

val asF = (x: Sugar) => Bag(Sugar(x.weight * 2))
val asG = (x: Sugar) => Bag(Sugar(x.weight * 3))
val as1 = sBag.flatMap(asF).flatMap(asG)
val as2 = sBag.flatMap(asF(_).flatMap(asG))

val option = Some(1)
val f: (Int => Option[Int]) = x => Some(x * 2)
val g: (Int => Option[Int]) = x => Some(x + 6)

option.flatMap(f).flatMap(g) == option.flatMap(f(_).flatMap(g))
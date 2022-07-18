import cats.Eq
import cats.instances.int._

/**
  Eq compares everything at compile-time
 */

val eqInt: Eq[Int] = Eq.apply[Int]

eqInt.eqv(12, 22)
eqInt.eqv(12, 12)
//eqInt.eqv(12, 12.2)
//eqInt.eqv(12, "str")*/

//import cats.syntax.eq._
/*12 === 12
12 === 13
12 =!= 13
12 =!= 12*/
//23 === "dyt"

// Some(1) === None ; types don't quite match up

import cats.instances.option._ // Eq instance in scope for option
import cats.instances.int._ // Eq instance in scope for option
import cats.syntax.eq._ // interface syntax for eq

(Some(1): Option[Int]) === (None: Option[Int])

Option(1) === Option.empty[Int]
Option(1) === Option(2)
Option(2) === Option(2)


import cats.syntax.option._
1.some === none[Int]
1.some === 1.some
2.some == 3.some
none == none

import java.util.Date
import cats.Eq
import cats.instances.long._
implicit val dateEq: Eq[Date] = Eq.instance[Date]((date1, date2) => date1.getTime === date2.getTime)

val date1 = new Date()
val date2 = new Date()

Eq.eqv(date1, date1)
//date1 === date1
//date1 === date2

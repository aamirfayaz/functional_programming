//python, java

/**
 * Main intention: learn Functional Programming
 * Java is OOP
 * Scala is mix of OOP and FP, I can write either in FP principles completely
   or in OOPS completely or mix of both, but try to write in FP always
 */

/**
 * imperative languages
 * variable mutate
 */

/**
 * Functional Programming Principles or FP style:
   It means set of rule to write a program or to follow a particular syntax or language feature
  List of FP principles :
 1.) Use Vals instead of Vars [reason yet to know?]
 ...to be continued
 */

/**
 * Uses of FP style:
 * 1.) Easy Debugging
 */

//expression





val xx = {
  ""
}

/**
   x,y are parameters
 Int is called type here
 so x is can say is parametric type
 */
def add(x: Int, y: Int) = x + y
def add2(x: Int, y: Int) = {
  x + y
}

add(1,2) //1, 2 arguments

/////

var n = 2
val b = true

//
val result: Unit = if(b) {
  n = 3 // this is a side effect
} else {
  n = 4
}

val result2: String = if(!b) {
  "b is not true"
} else {
  "b is false"
}

def abc1(x:Int, y: Int): Unit = {
  val z = x + y // this is a side effect
}
def abc2(x:Int, y: Int): Int = {
  val z = x + y
  z
}
//last statement of method is its return type
def abc3(x:Int, y: Int): Int = {
 x + y

}

/**
 * What is side-effecting?
 * People say side-effecting is bad in FP languages
 */

val x: Unit = println("some print")
//println is a statement
var x = 19
x = 20 // assignment has a return type of Unit, means it is a statement, means its a side effect
x
val z = x = 30
x

val x: Unit = ()

def m1() = {
  val xx = 20
}

val returnVlaue = m1()
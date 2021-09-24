package dsalgo.mathematical

object PythagoreanTriplet extends App {

   println("Enter 3 sides of a triangle: ")
   val a = scala.io.StdIn.readInt()
   val b = scala.io.StdIn.readInt()
   val c = scala.io.StdIn.readInt()

   var max = a
  if(b > max) max = b
  if(c > max) max = c

  if(a > max) {
    println((a*a) == (b*b) + (c*c))
  } else if(b > max) {
    println((b*b) == (a*a) + (c*c))
  } else {
    println((c*c) == (a*a) + (b*b))
  }
}
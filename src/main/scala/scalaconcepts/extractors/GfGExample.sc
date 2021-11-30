object GfG {
  def apply(x: Double) = x / 5

  def unapply(z: Double): Option[Double] = {

    if (z % 5 == 0) Some(z / 5) else None
  }
}

val x = GfG(25)

// Applying pattern matching
x match {

  // unapply method is called
  case GfG(y) => println("The value is: " + y)
  case _      => println("Can't be evaluated")

}


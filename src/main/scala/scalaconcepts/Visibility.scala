package scalaconcepts

import Animal._

case class Animal(numberOfLegs: Int) {
  //can access its companion objects private methods
  lazy val name: String = convertLegNumberToName(numberOfLegs)
}

object Animal {
  val BipedName = "biped"
  val QuadripedName = "quadriped"
  val CentipedName = "centiped"

  private val LegName: Map[Int, String] = Map(
    2 -> BipedName,
    4 -> QuadripedName,
    100 -> CentipedName
  )

  private def convertLegNumberToName(numberOfLegs: Int): String = {
    LegName.getOrElse(numberOfLegs, s"$numberOfLegs legged creature")
  }
}

object VisibilityTest1 extends App {

  val quadriPed: Animal = Animal(4)

  val biPed: Animal = Animal(2)

  // Try uncommenting this: (remove the '//')
  // println(Animal.convertLegNumberToName(biPed.numberOfLegs)) CTE convertLegNumberToName is inaccessible from this place

  assert(quadriPed.name == QuadripedName)
  assert(biPed.name == BipedName)
}

object Foo {
  val visibilityPublic = "a"

  private val visibilityPrivate = "b"
}

// try to use 'visibilityPrivate'.

object VisibilityTest2 extends App {

  val result: String = Foo.visibilityPublic
  //CTE, not visibile; val result: String = Foo.visibilityPrivate

  assert(result == "a")
}



package scalaconcepts

object LiftMethods extends App {

  val n = "aamir fayaz"
  val sp: Array[String] = n.split(" ")
  val opT: Option[String] = sp.lift(1)
  val finalRes = opT.getOrElse("n/a")
}
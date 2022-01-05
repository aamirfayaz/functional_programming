val f: ((Int, Int)) => Int = Function.tupled((x:Int, y: Int) => x * y) //l1 deprecated
val zipped: List[(Int, Int)] = List(1,2,3).zip(List(2,3,4))
zipped.map(f)
val g: (Int, Int) => Int = (x,y) => x * y
val k: ((Int, Int)) => Int = g.tupled //same as l1
zipped.map(f)
zipped.map(k)
zipped.map{x => x._1 * x._2}
zipped.map{case (x, y) => x * y}

//PF[(Int , Int) => Int]


val fn2 = new Function2[Int, Int, Int] {
  override def apply(a: Int, b: Int) = a + b
}

val fff:PartialFunction[String, Int] = {
  case x: String => x.toInt
}

val ggg: String => Int = {
  case x: String => x.toInt
}


val tu: ((Int, Int)) => String = {
  case ((x:Int, y:Int)) => x.toString + y.toString
}

tu((1,2))
tu(1,2)

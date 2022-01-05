val f: ((Int, Int)) => Int = Function.tupled((x:Int, y: Int) => x * y)
val zipped: List[(Int, Int)] = List(1,2,3).zip(List(2,3,4))
zipped.map(f)
val g: (Int, Int) => Int = (x,y) => x * y
val k: ((Int, Int)) => Int = g.tupled
zipped.map(f)
zipped.map(k)
zipped.map{x => x._1 * x._2}
zipped.map{case (x, y) => x * y}
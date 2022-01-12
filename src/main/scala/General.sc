def m(x: Int, b: Int) = x + b
//val mff = m(1) _ not allowed
val mf: Int => Int = m(1, _)
val gf: (Int, Int) => Int = m _

val l = List.fill(2) _
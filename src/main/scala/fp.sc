val l: List[String] = List("", "c")
l.size
val ch = 'b'
val res = l.map(x => ch + x)
val l2 = l ++ res
val ch = 'a'
val res2 = l2.map(x => ch + x)
l2 ++ res2

val x1 = List("")
val r = x1.map{ y => ch + y}
val res = x1 ++ r

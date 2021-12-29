def m(s: => String) = {
  val a = 10
  if(a == 10) println(s)
}

val s: () => String = () => "gekki"
val x = s
val y = s()
m(s())
m("ss")

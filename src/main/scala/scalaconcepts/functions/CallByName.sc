//https://stackoverflow.com/questions/28876368/scala-by-name-parameter-on-a-anonymous-function/28876771#28876771
def m(s: => String) = {
  val a = 10
  if(a == 10) println(s)
}

val s: () => String = () => "gekki"
val x = s
val y = s()
m(s())
m("ss")




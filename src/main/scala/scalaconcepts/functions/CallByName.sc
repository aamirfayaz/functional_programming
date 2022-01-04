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

println("================")

def byName(n: => Int):Int = n + 1
byName(10)
10.toString

def method:Int = 32
def parenMethod(): Int = 22
parenMethod()
parenMethod
byName(method)

val f: () => Int = () => 42
//byName(f)
byName(f())
//byName((() => Int)())
byName((() => 42)())

println("********************")
def byFunction(g: () => Int): Int = g() + 2
//byFunction(10)
//byFunction(method)
//byFunction(parenMethod())
val x:Int = parenMethod
val g: () => Int = parenMethod _ //eta-expansion
val k: () => Int = parenMethod //eta-expansion
byFunction(parenMethod) //eta-expansion by compiler
//byFunction(f
byFunction(f)
byFunction(k)
byFunction(() => 10)







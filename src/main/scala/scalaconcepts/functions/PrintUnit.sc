val fg: () => Unit = () => println("print")

/*def times2(n: Int, curr: Int = 0)(fn: => String):Unit = {
  if(curr < n) {
    fn
    times(n, curr + 1)(fn)
  }
}
val ff: String => Unit = times2(10)
ff("")*/

def times(n: Int, curr: Int = 0)(fn: => Unit):Unit = {
  if(curr < n) {
    fn
    times(n, curr + 1)(fn)
  }
}

val gg: ( => Unit) => Unit = times(2)
gg(println("hi"))
times(4, 1) {
  println("hello")
}

def add(x: Int)(y: Int) = x + y

val f: Int => Int = add(2)
val g = add(2)_
val k: Int => Int = add(2)
f(3)
g(4)
k(5)

println("===============================")
def method(x: Any): Unit = println(x)
def printlnT(x: Any): Unit = Console.println(x)
val mF: Any => Unit = method _
val mF2: Any => Unit = printlnT _
val gF: Any => Unit = method
val gF2: Any => Unit = printlnT

val gg: Unit = printlnT("t")
val gg2: Unit = println("")

val d = () => println("hi")

def m(x: Int)(fn: => Unit) = {

  if(x == 10) fn
}

m(10)(println("hi"))

def fff(x: Unit) = {
  x
}
fff(println("hi"))

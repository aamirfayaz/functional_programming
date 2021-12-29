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
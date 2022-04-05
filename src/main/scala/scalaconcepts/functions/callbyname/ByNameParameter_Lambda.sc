val f:(=> String) => String = s => {
  println("Delaying execution...")
  Thread.sleep(3000)
  s + s
} // compiles
//val f:(=> String) => String = (s: => String) => s +s // does not compile

f("Abc")

//by-name parameter on an anonymous function
val fun: (Boolean, => Int) => Int = {
  (x, y) => if(x) y else 0
}

fun(false, {println("!"); 2})

fun(true, {println("!"); 2})

def ff(g: Unit) = {
  println("inside ff")
  g
}

def gg(g: => Unit) = {
  println("inside gg")
  g
}
val r: Unit = println("unit p;rint")
r
println("---1--")
ff(r)
println("---2--")
gg(r)
println("---3--")
ff(println("hi"))
println("---4--")
gg(println("hi"))


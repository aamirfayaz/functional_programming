class Person(val name: String, val age: Int) {
  def unary_! :String = s"from unary, name is $name"
  def isAlive: Boolean = true
  def apply(): String = "some random string"
  def apply(n: Int) = s"age increaed by $n"
}

val p = new Person("shehzal", 2)
!p // prefix operator
p.unary_!

p.isAlive// postfix operator

p()
p.apply()
p.apply(10)
p(20)
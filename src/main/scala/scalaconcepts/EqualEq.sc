case class Person(name: String, age: Int)
val p1 = Person("aamir", 34)
val p2 = Person("aamir", 34)

p1 == p2
p1.equals(p2)
p1 eq p2

val s1: String = "hi"
val s2: String = "hi"

s1 == s2
s1.equals(s2)
s1 eq s2

val string1: String = new String("hi")
val string2: String = new String("hi")

string1 == string2
string1.equals(string2)
string1 eq string2
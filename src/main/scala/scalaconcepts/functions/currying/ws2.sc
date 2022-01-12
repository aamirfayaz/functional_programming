def m(x: Int, b: Int) = x + b
//val mff = m(1) _ not allowed coz m is not curried
val mf: Int => Int = m(1, _) //parital appllication
val gf: (Int, Int) => Int = m _ //eta expansion

//val x = List.fill(2) // won't work, fill is def not val  i.e method not function
val l = List.fill(2) _ // coz fill is curried function
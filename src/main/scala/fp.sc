val l1 = List(1,2,3)
val l2 = List(1,4,7)

(l1 zip l2).map(Function.tupled(_ * _)).sum
val l1 = List(1,2,3)
val l2 = List(1,4,7)

(l1 zip l2).map(Function.tupled(_ * _)).sum
case class Row(id: Int, list: List[Int])
val howManyInput: Int = 1
val howManyListItem: Int = 1

val input: List[Row] = (0 to howManyInput)
  .map(i => Row(i, list = (0 to howManyListItem).toList))
  .toList

val modFilter: Int = 2
val increase: Int = 1

val output1: List[Int] = input.flatMap {
  case Row(id, list) =>
    list.flatMap(n =>
      List(id, n)
        .withFilter(i => id + n % modFilter == 0)
        .map(_ + increase)
    )
}
val output1Sum = output1.sum
println(output1Sum)

List(1,2,3,4).filter(_ % 2 == 0)
List(1,2,3,4).withFilter(_ % 2 == 0).map(x => println("ss " + x))

val list = List(1, 2, 3)
var go = true
val r2 = list filter {
  case i => go
} map {
  case i => {
    go = false
    i
  }
}
var go = true
val r3 = list withFilter  {
  case i => go
} map {
  case i => {
    go = false
    i
  }
}
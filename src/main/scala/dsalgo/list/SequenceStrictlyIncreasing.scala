package dsalgo.list

object SequenceStrictlyIncreasing extends App {

     val list = List(1,2,3,4,5,6,7,8)
     val result =  (list zip list.drop(1)).forall(elem => elem._1  < elem._2)
     assert(result)
}
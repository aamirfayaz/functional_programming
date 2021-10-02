package dsalgo.arrays1D

/**
shift, k = 2
1 2 3 4 5
Right rotation: 4 5 1 2 5
left rotation: 3 4 5 1 2
also if k = -1 and n = 5, then k = -1 == k = 4
in below functions, we will be implementing left rotation.
==================================================
METHOD 1 (Using temp array)
 --Store the first d elements in a temp array
 --Shift rest of the arr[]
 --Store back the d elements
  Time complexity : O(n)
  Auxiliary Space : O(d)
==================================================
METHOD 2 (Rotate one by one)
 --leftRotate(arr[], d, n)
 start
  For i = 0 to i < d
    Left rotate all elements of arr[] by one
 end
  Time complexity : O(n * d)
  Auxiliary Space : O(1)
==================================================
METHOD 3 (A Juggling Algorithm) https://www.youtube.com/watch?v=utE_1ppU5DY
 Time complexity : O(n)
 Auxiliary Space : O(1)
==================================================
METHOD 4 (Using Reversal Algorithm)
  Time complexity : O(n)
  Auxiliary Space : O(1)
  Start:
     reverse(arr, 0, n-k-1)
     reverse(arr, k, n-1)
     reverse(arr, 0, n-1
 */

object Rotate1 extends App {
   //left rotate
    def rotate(list: List[Int], k: Int, acc: List[Int] = Nil): List[Int] = k match {
      case 0         => list ::: acc
      case _         => rotate(list.tail, k - 1, acc :+ list.head)
    }
  println(rotate(List(1,2,3,4,5), 2))
}

object Rotate2 extends App {

  //left rotate
  val l = List(1,2,3,4,5)
  val shift = 2
  val size = l.length
  val k = if(shift < 0) (size - shift) % size else shift % size
  val result = l.drop(k) ::: l.take(k)
  println(result)

}


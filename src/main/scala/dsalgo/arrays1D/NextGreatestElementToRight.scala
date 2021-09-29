package dsalgo.arrays1D



/**
 * for the array [2 5 9 3 1 12 6 8 7]
 * Next greater for 2 is 5
 * Next greater for 5 is 9
 * Next greater for 9 is 12
 * Next greater for 3 is 12
 * Next greater for 1 is 12
 * Next greater for 12 is -1
 * Next greater for 6 is 8
 * Next greater for 8 is -1
 * Next greater for 7 is -1
 */

// n^2 complexity.
object NextGreatestElementToRight extends App {

  val arr = Array(2, 5, 9, 3, 1, 12, 6, 8, 7)
  var cond: Boolean = _
  var next: Int = _

  for (i <- arr.indices) {
    var j = i + 1
    cond = true
    next = -1
    while (j < arr.length && cond) {
      if (arr(i) < arr(j)) {
        next = arr(j)
        cond = false
      }
      if (cond) j = j + 1
    }
    println(arr(i) + "-------> " + next)
  }

}


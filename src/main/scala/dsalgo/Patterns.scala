package dsalgo

/**

*
*	*
*	* *
*	* * *

*/
object Pattern1 extends App {

  val n = 5
  for (i <- 1 to n) {
    for (_ <- 1 to i) {
      print("*" + " ")
    }
    println()
  }
}

/**

 * *	*	*	*
 * *	*	*
 * *	*
 * *
 *

 * */
object Pattern2 extends App {

  val n = 5

  for (i <- 1 to n) {
    for (_ <- i to n) {
      print("*" + " ")
    }
    println()
  }
}
/**
         *
       * *
     * * *
   * * * *
*  * * * *
 **/

object Pattern3 extends App {

  val n = 5
  for (i <- 1 to n) {
    //add spaces
    for (_ <- i until n) {
      print("\t")
    }
    for (_ <- 1 to i) {
      print("*" + "\t")
    }
    println()
  }
}

/**

*	*	*	*	*
	*	*	*	*
		*	*	*
			*	*
				*

*/

object Pattern4 extends App {
  val n = 5
  for(i <- 1 to n) {
    //for spaces
    for(_ <- 1 until i) {
        print("\t")
    }
    for(_ <- i to n) {
      print("*" + "\t")
    }
    println()
  }
}

/**
       *
    *	 *	*
*   *	 *	*	 *
    *	 *	*
       *
*/

object Pattern5 extends App {
  val n = 5
  var sp = n / 2
  var st = 1

  for(i <- 1 to n) {
    for(_ <- 1 to sp) {
      print("\t")
    }
    for(_ <- 1 to st) {
      print("*" + "\t")
    }
    if(i <= n / 2) {
      sp-=1
      st+=2;
    } else {
      sp+=1
      st-=2
    }
    println()
  }
}

/**
 * * *   * * *
 * *       * *
 *           *
 * *       * *
 * * *   * * *
 **/

object Pattern6 extends App {

  val n = 5
  var st = n / 2 + 1
  var sp = 1

  for(i <- 1 to n) {

    for(_ <- 1 to st) {
      print("*\t")
    }

    for(_ <- 1 to sp) {
      print("\t")
    }

    for(_ <- 1 to st) {
      print("*\t")
    }

    if(i <= n / 2) {
      sp+=2
      st-=1
    } else {
      sp-=2
      st+=1
    }
    println()
  }


}
/**
 *
    *
      *
        *
          *
 **/
object Pattern7 extends App {

  val n = 5
  for (i <- 1 to n) {
    for (j <-  1 to n ) {
      if(i == j) print("*")
      else print("\t")
    }
    println()
  }
}

/**
Sample Output
           *
         *
      *
    *
  *
 **/
object Pattern8 extends App {

  val n = 5
  for (i <- 1 to n) {
    for (j <- i to n ) {
      if(j == n) print("*")
      else print("\t")
    }
    println()
  }
}

/**

 *       *
   *   *
     *
  *    *
*        *
 **/

object Pattern9 extends App {
  val n = 5
  for (i <- 1 to n) {
    for (j <- 1 to n) {
      if(j == i || (i + j) == n + 1) print("*\t")
      else print("\t")
    }
    println()
  }
}

/**

/*
       *
   *        *
 *             *
    *      *
       *
*/

 */
object Pattern10 extends App {

  val n = 5
  var sp1 = n / 2
  var sp2 = -1

  for (i <- 1 to n) {

    for(_ <- 1 to sp1) {
      print("\t")
    }
    print("*\t")
    if(sp2 > 0) {
      for (_ <- 1 to sp2) {
        print("\t")
      }
      print("*")
    }

    if(i <= n/2) {
      sp1 -= 1
      sp2  += 2
    } else {
      sp1 += 1
      sp2 -= 2
    }
    println()
  }

}

/**
1
2	3
4	5	6
7	8	9	10
11	12	13	14	15
*/

object Pattern11 extends App {

   def outer(i: Int, num:Int, acc: String = ""): String = i match {
     case 0 => acc
     case _ =>
     def inner(j: Int, num: Int, acc: String=""): String = j match {
       case 0 => outer(i + 1, num, acc + "\n")
       case _ => inner(j - 1, num + 1, acc + s"$num\t")
     }
     inner(i + 1, num)
   }
  outer(5, 1)
}
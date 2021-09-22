package dsalgo

/*
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
/*
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

/*

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

/*
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
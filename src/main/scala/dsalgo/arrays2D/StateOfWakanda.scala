package dsalgo.arrays2D

object StateOfWakanda extends App {

  /**
   * Imperative algorithm

    for (int j = 0; j < arr[0].length; j++) {
      if (j % 2 == 0) {
        for (int i = 0; i < arr.length; i++)
          System.out.println(arr[i][j]);
      } else {
        for (int i = arr.length - 1; i >= 0; i--)
          System.out.println(arr[i][j]);
      }
    }

   */
  val a: Matrix = List(
    List(1, 2, 3),
    List(4, 5, 6),
    List(7, 8, 9),
  )

  def display(m: Matrix, index: Int = 0): Matrix = {
    if(m.head.isEmpty) m else {
      if(index % 2 == 0) {
        m.map(_.head).foreach(println)
        display(m.map(_.tail), index + 1)
      } else {
        m.map(_.head).reverse.foreach(println)
        display(m.map(_.tail), index + 1)
      }
    }
  }


  display(a)
}
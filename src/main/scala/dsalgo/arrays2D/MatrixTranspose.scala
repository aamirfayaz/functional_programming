package dsalgo.arrays2D

/**
 * Matrix Transpose
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * to
 * 1 4 7
 * 2 5 8
 * 3 6 9

  imperative solution:
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
      }
    }

  // reverse columns, row by row
    for (int i = 0; i < arr.length; i++) {
      int li = 0;
      int ri = arr[0].length - 1;
      while (li <= ri) {
        int temp = arr[i][li];
        arr[i][li] = arr[i][ri];
        arr[i][ri] = temp;

        li++;
        ri--;
      }
    }
 */
object MatrixTranspose extends App {

  def transpose(m: Matrix): Matrix = {
    if(m.head.isEmpty) Nil
    else m.map(_.head) :: transpose(m.map(_.tail))
  }

  val a: Matrix = List(
    List(1, 2, 3),
    List(4, 5, 6),
    List(7, 8, 9),
  )

  MatrixF.display(a)
  println("--transpose--")
  val res = transpose(a)

  MatrixF.display(res)

}
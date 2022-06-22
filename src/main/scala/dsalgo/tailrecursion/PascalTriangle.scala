object PascalTriangle extends App { 

 def pascalTill(n: Int) = {
    var row = 0
    var col = 0

    while (row <= n) {

      //space logic here
      var space = row
      while (space < n - 1) {
        print(" ")
        space = space + 1
      }

      //calculate next numbers
      col = 0
      while (col <= row) {
        val result = pascal(row, col)
        print(result + " ")
        col = col + 1
      }
      println()
      row = row + 1
    }

    def pascal(row: Int, col: Int): Int = {
      if (col == 0 || row == col) 1 else {
        pascal(row - 1, col - 1) + pascal(row - 1, col)
      }
    }

    /** tail recursion
     * --> try to reverse a string
     * --> calculate head of a list
     * --> find the penultimate (second last) element of a list
     * --> find the Kth element of a list def kth(list: List, k: Int)
     * e.g List(1,3,4,5,5,6), k = 2, output as 4
     * --> Find the number of a list, list.size() function
     */


  }

  def pascalTill2(n: Int) = {

    for (row <- 0 to n) {
      for (col <- 0 to row) {
        print(pascal2(row, col) + " ")
      }
      println()
    }

    def pascal2(row: Int, col: Int): Int = {
      if (col == 0 || row == col) 1 else {
        pascal2(row - 1, col - 1) + pascal2(row - 1, col)
      }
    }
  }
}

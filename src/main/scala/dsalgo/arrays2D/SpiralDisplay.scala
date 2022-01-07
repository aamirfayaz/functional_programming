package dsalgo.arrays2D
//TODO: convert to FP code
object SpiralDisplay extends App {

  val rows = 6
  val cols = 6
  val matrix = MatrixF.apply(rows, cols)(() => scala.io.StdIn.readInt())
  MatrixF.display(matrix)
  println("-" * 20)

  val totalElements = rows * cols
  var left = 0
  var top = 0
  var bottom = matrix.size - 1
  var right = matrix.head.size - 1
  var count = 0

  def loop(): Unit = {

     if(count < totalElements) {
       var i = top
       var j = left
       while(i <= bottom && count < totalElements) {
         print(matrix(i)(j) + " ")
         i = i + 1
         count = count + 1
       }

       left = left + 1
        i = bottom
        j = left
       while(j <= right && count < totalElements) {
         print(matrix(i)(j) + " ")
         j = j + 1
         count = count + 1
       }

       bottom = bottom - 1
       i = bottom
       j = right
       while(i >= top && count < totalElements) {
         print(matrix(i)(j) + " ")
         i = i - 1
         count = count + 1
       }

       right = right - 1
       i = top
       j = right
       while(j >= left && count < totalElements) {
         print(matrix(i)(j) + " ")
         j = j - 1
         count = count + 1
       }
       top = top + 1
       loop()
     } else return
  }
  loop()

/*  def spiralString(m: Matrix): String = {
    val totalElements = m.size * m.head.size //row * col
    var left = 0
    var top = 0
    var bottom = matrix.size - 1
    var right = matrix.head.size - 1
     def spiralLoop(acc: String = "", count: Int): String = {
       if(count >= totalElements) acc else {

       }
     }
    spiralLoop()
  }*/
}
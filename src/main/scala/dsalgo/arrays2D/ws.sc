import dsalgo.arrays2D.MatrixF

import scala.util.Random

List.tabulate(6)(identity)
val r = List.tabulate(5,4)((x, y) => new Random().nextInt(2))
MatrixF.display(r)
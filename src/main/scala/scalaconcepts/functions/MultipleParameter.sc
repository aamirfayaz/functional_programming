def myLoop(start: Int, end: Int)
(callback: Int => Unit) = {
  for (i <- Range(start, end)) {
    callback(i)
  }
}

/*
myLoop(1,5) { (i: Int) =>
  println("range value : " + i)
}*/

myLoop(1,5) {  i =>
  println("range value : " + i)
}
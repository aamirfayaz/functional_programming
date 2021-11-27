trait Combine1[+T] {
  def item: T
  def combineWith[B >: T](t: B):B
}

trait Combine2[-T] {
  def item[B <: T]: B
  def combineWith[B <: T](t: B):B
}
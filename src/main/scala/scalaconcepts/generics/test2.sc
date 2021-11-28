trait Box[-T] {

  def add(t: T):Unit = println()
  def get[B <: T]:B
}



trait Collection[A] {
  def fold[B](x: A)(op: (A, B) => B):B
}

class MyList[A] extends Collection[A] {
  override def fold[B](z: B)(op: (B, A) => B):B = {
    if(l.isEMpty) {
      z
    }  else {
      fold(op(h, z),op)
    }
  }
}
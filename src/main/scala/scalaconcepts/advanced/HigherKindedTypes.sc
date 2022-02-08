/**
  F[_] simply means that F is a type parameter,
  which is itself a type constructor
 */

abstract class SomeHigherKindedType[F[_]] {
  def map[A, B](ty: F[A])(f: A => B):F[B]
}

abstract class My47Degrees[F[_]] {
  def map[A, B](fa: F[A])(f:A => B): F[B]
}

val o1 = new My47Degrees[List] {
  override def map[A, B](fa: List[A])(f: A => B): List[B] = {
    fa.map(f(_))
  }
}

val o2  = new My47Degrees[Option] {
  override def map[A, B](fa: Option[A])(f: A => B) = {
    fa.map(f(_))
  }
}

o1.map(List(1,3))(_ + 1)
o2.map(Some(2))(_ + 1)


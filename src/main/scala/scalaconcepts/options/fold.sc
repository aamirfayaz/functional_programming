val optionalSeq:Option[Seq[Int]] = Some(Seq(1,2))

val r:Option[String] = Some("10")
r.fold("Hi") {
    x =>
    x + "hello"
}

optionalSeq.fold(Seq[Int]()) {
    x =>
    x.map(_ + 2)
}

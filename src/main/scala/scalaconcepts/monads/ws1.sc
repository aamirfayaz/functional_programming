val p1: Option[String] = sys.props.get("abc")
val p2: Option[String] = p1.flatMap(x => sys.props.get(x))
val p3: Option[String] = p1.flatMap(sys.props.get)

val res: Option[String] = for {
  q1 <- sys.props.get("abc")
    q2 <- sys.props.get(q1)
} yield q2
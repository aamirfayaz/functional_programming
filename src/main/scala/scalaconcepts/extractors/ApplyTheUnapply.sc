object FullName {

  def apply(firstName: String, lastName: String): FullName = {
    new FullName(firstName, lastName)
  }

  def unapply(fN: FullName): Some[(String, String)] = {
    Some((fN.first, fN.last))
  }

}

/*case class FullName(val first: String, val last: String) {
  override def toString: String = s"FullName($first, $last)"
}*/
/*
 They must be val otherwise they won't be accessed from
 companion object. val makes them instance variable with
 public modifier but immutable
 */

class FullName(val first: String, val last: String) {
  override def toString: String = s"FullName:($first, $last)"
}

val fN = FullName("aamir", "fayaz") // construction
val FullName(firstName, lastName) = fN //deconstruction/ extraction

import java.time.{LocalDate, LocalTime, LocalDateTime}

//omitting local keyword to avoid name collisions
object DateTime {
  def unapply(dt: LocalDateTime): Some[(LocalDate, LocalTime)] = {
    Some((dt.toLocalDate, dt.toLocalTime))
  }
}

object Date {
  def unapply(d: LocalDate): Some[(Int, Int, Int)] = {
    Some(d.getYear, d.getMonthValue, d.getDayOfMonth)
  }
}

object Time {
  def unapply(t: LocalTime): Some[(Int, Int, Int)] = {
    Some(t.getHour, t.getMinute, t.getSecond)
  }
}

val Date(year, month, day) = LocalDate.now()
val Time(h, m, s) = LocalTime.now()
val Date(_, m, d) = LocalDate.now()

val DateTime(Date(y, mo, d), Time(h, m, s)) = LocalDateTime.now()

val dt@DateTime(date@Date(y, m, d), time@Time(h, mi, s)) = LocalDateTime.now()

object DateTimeSeq {
  def unapplySeq(dT: LocalDateTime): Option[Seq[Int]] = {
    Some(Seq(dT.getYear, dT.getMonthValue, dT.getDayOfMonth,
      dT.getHour, dT.getMinute, dT.getSecond))
  }
}

val DateTimeSeq(y, m, d, h, mi, sec) = LocalDateTime.now()
val DateTimeSeq(y, m, d, h, rest@_*) = LocalDateTime.now()

object AM {
  def unapply(t: LocalTime): Option[(Int, Int, Int)] = t match {
    case Time(h, m, s) if h < 12 => Some((h, m, s))
    case _                       => None // this is if guard fails above
  }
}

object PM {
  def unapply(t: LocalTime): Option[(Int, Int, Int)] = t match {
    case Time(12, m, s)            => Some((12, m, s))
    case Time(h, m, s) if (h > 12) => Some((h - 12, m, s))
    case _                         => None //omit this, it won't throw error
  }
}

LocalTime.now match {
  case t@AM(h, m, s) => println("GM")
  case t@PM(h, m, s) => println("GE")
}

LocalTime.now match {
  case t @ AM(h, m, _) =>
    f"$h%2d:$m%02d AM ($t precisely)"
  case t @ PM(h, m, _) =>
    f"$h%2d:$m%02d PM ($t precisely)"
}



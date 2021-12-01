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
  def unapply(t: LocalTime):Some[(Int, Int, Int)] = {
    Some(t.getHour, t.getMinute, t.getSecond)
  }
}

val Date(year, month, day) = LocalDate.now()
val Time(h, m, s) = LocalTime.now()
val Date(_, m, d) = LocalDate.now()

val DateTime(Date(y,mo,d), Time(h,m,s)) = LocalDateTime.now()

val dt @ DateTime(date @ Date(y,m,d), time @ Time(h, mi, s)) = LocalDateTime.now()

object DateTimeSeq {

    def unapplySeq(dT: LocalDateTime):Option[Seq[Int]] = {
      Seq(dT.getY)
    }
}


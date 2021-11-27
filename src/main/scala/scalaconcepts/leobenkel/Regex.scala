package scalaconcepts.leobenkel

import java.util.regex.{Matcher, Pattern}
import scala.util.Try
import scala.util.matching.Regex

/**
 * The example Regex1 is a simple case to check for a match.
 * However the compilation of the regex into an actionable test can be costly.
 * It is recommended to compile the regex once before using it several times. This is when the Regex2 example come into play.
 */
object Regex1 extends App {

  val testPhoneNumber: String = "123-333-3212"
  val isPhoneNumber: Boolean = "[0-9]{3}-[0-9]{3}-[0-9]{4}".r.matches(testPhoneNumber)
  println(s"is phone number: $isPhoneNumber")

}

object Regex2 extends App {

  object FindEmail {
    private val regex: Regex = new Regex("([a-z]+)@([a-z]+)\\.([a-z]+)")
    private val pattern: Pattern = regex.pattern

    def apply(input: String): RegexFind = RegexFind(pattern.matcher(input))

    case class RegexFind(private val m: Matcher) {
      private lazy val find: Boolean = m.find()
      private lazy val groupCount: Int = m.groupCount()

      private lazy val matches: List[String] = (for {
        n <- 1 to groupCount
        group = Try(m.group(n))
        if group.isSuccess
      } yield group.get).toList

      override lazy val toString: String = s"match: $find, matches: $matches"
    }
  }

  val testEmail: String = "abc@gmail.com"
  val matches = FindEmail(testEmail)
  println(s"Matches: $matches")
}

//using pattern matching
object Regex3 extends App {

  val testAddress: String = "123 bangalore st."
  val isAddress: Regex = "([0-9]+) ([a-z]+) (st|blvd)\\.".r

  testAddress match {
    case isAddress(number, streetName, streetType) =>
      println(s"streetName: $streetName $streetType , at: $number")
      assert(number.toInt == 123, number)
  }
}
import cats.data.EitherT

import scala.util.Try
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import cats.implicits._
/** https://typelevel.org/cats/datatypes/eithert.html * */

def parseDouble(s: String): Either[String, Double] = {
  Try(s.toDouble).map(Right(_)).getOrElse(Left(s"$s is not a number"))
}

def divide(a: Double, b: Double): Either[String, Double] = {
  Either.cond(b != 0, a / b, "cannot divide by zero")
}

def divisionProgram(inputA: String, inputB: String): Either[String, Double] = {
  for {
    a <- parseDouble(inputA)
    b <- parseDouble(inputB)
    result <- divide(a, b)
  } yield {
    result
  }
}

divisionProgram("12", "kk")

//assume parseDouble and divide are asynchronous


def parseDoubleAsync(s: String): Future[Either[String, Double]] =
  Future.successful(parseDouble(s))

def divideAsync(a: Double, b: Double): Future[Either[String, Double]] =
  Future.successful(divide(a, b))


def divisionProgramAsync(inputA: String, inputB: String) = {

  parseDoubleAsync(inputA).flatMap { eitherA =>
    parseDoubleAsync(inputB).flatMap { eitherB =>
      (eitherA, eitherB) match {
        case (Right(a), Right(b)) => divideAsync(a, b)
        case (Left(err), _) => Future.successful(Left(err))
        case (_ , Left(err)) => Future.successful(Left(err))
      }
    }
  }

}

def divisionProgramAsyncEitherT(inputA: String, inputB: String) = {
  for {
    a <- EitherT(parseDoubleAsync(inputA))
  } yield ()
}









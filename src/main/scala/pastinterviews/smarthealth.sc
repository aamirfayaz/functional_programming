
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

import scala.concurrent.ExecutionContext.Implicits.global
case class DiagnosisCode(
  rootCode: String,
  uniqueCode: String,
  description: Option[String] = None
)

object DataBase {

  private val data:  List[DiagnosisCode] = List(
    DiagnosisCode("A00", "A001", Some("Cholera due to Vibrio cholerae")),
    DiagnosisCode("A00", "A009", Some("Cholera, unspecified")),
    DiagnosisCode("A08", "A080", Some("Rotaviral enteritis")),
    DiagnosisCode("A08", "A083", Some("Other viral enteritis")),
    DiagnosisCode("B15", "B150", Some("Hepatitis A with hepatic coma")),
    DiagnosisCode("B15", "B159", Some("Hepatitis A without hepatic coma")),
    DiagnosisCode("H26", "H26001", Some("Other cataract right eye")),
    DiagnosisCode("H26", "H26002", Some("Other cataract left eye"))
  )

  def getDiagnosisCode(code: String): Future[Option[DiagnosisCode]] = Future {
    data.find(_.uniqueCode.equalsIgnoreCase(code))
  }

  def getAllCodes: Future[List[String]] = Future(data.map(_.uniqueCode))

}

//TODO: implement without using FOR comprehension
def getAllDiagnosisCode1: Future[List[DiagnosisCode]] = {
  DataBase.getAllCodes.flatMap { codesList =>
    Future.sequence(codesList.map { uniqueCode =>
      DataBase.getDiagnosisCode(uniqueCode)
    })
  }.map(_.flatten)
}

def getAllDiagnosisCode: Future[List[DiagnosisCode]] = {
  for {
    codeList <- DataBase.getAllCodes
      res <-  Future.sequence(codeList.map { uQ =>
        for {
          diagnosisCode <- DataBase.getDiagnosisCode(uQ)
        } yield diagnosisCode
      })
  } yield res.flatten
}

/*
  A00 -> List(A001, A009)
  H26 -> List(H26001, H26002)
  A08 -> List(A080, A083)
  B15 -> List(B150, B159)
 */
//TODO
def getDiagnosisCodeByHierarchy:Future[Map[String, List[String]]] = {
  getAllDiagnosisCode.map { listOfDiagnosisCode =>
    listOfDiagnosisCode.groupBy(_.rootCode).map { case (k, v) =>
      (k, v.map(_.rootCode))
    }
  }
}

Await.result(getAllDiagnosisCode, 2.seconds).map(println)
//println("")
//Await.result(getDiagnosisCodeByHierarchy, 2.seconds).map(println)
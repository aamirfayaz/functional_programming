import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

def config(b: Boolean) = {

  if(b) Future(10) else {
    throw new Exception("failed config")
  }
}

def service(): Future[Int] = {
  for {
    x <- config(true)
  } yield x
}

def main() = {
  val res = service().map { x=>
    println("success " + x)
  }
  res
}
main()
Thread.sleep(5000)




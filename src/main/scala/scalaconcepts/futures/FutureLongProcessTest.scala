package scalaconcepts.futures

import scala.concurrent._
import ExecutionContext.Implicits.global
import duration._

object FutureLongProcessTest1 extends App {

  def longRunningProcess(x: Int) = {
    Thread.sleep(100000)
    "result of long running process"
  }

  def shortRunningProcess(x: Int) = {
    "result of short running process"
  }

  val f1 = Future(longRunningProcess(10))
  val f2 = Future(shortRunningProcess(20))

  val result = for {
    shortResult <- f2
     _= f1
  } yield shortResult

  //won't wait for f1 to finish
  val res = Await.result(result, 3.seconds)
  println("Result is : " + res)
  Thread.sleep(20000)
}

object FutureLongProcessTest1B extends App {

  def longRunningProcess(x: Int) = {
    Thread.sleep(100000)
    "result of long running process"
  }

  def shortRunningProcess(x: Int) = {
    "result of short running process"
  }

  val f1 = Future(longRunningProcess(10))
  val f2 = Future(shortRunningProcess(20))

  val result = for {
    shortResult <- f2
    _<- f1
  } yield shortResult

  //waits for f1 to finish
  val res = Await.result(result, 10.seconds)
  println("Result is : " + res)
  Thread.sleep(20000)
}

object FutureLongProcessTest2 extends App {

  def longRunningProcess(x: Int) = {
    Thread.sleep(100000)
    "result of long running process"
  }

  def shortRunningProcess(x: Int) = {
    "result of short running process"
  }

  val f1 = Future(longRunningProcess(10))
  val f2 = Future(shortRunningProcess(20))

  val result = for {
    shortResult <- f2
     longResult <- f1
    //it waits for longResult to finish
  } yield shortResult

  //Future timeout

  val res = Await.result(result, 5.seconds)
  println("Result is : " + res)
  Thread.sleep(20000)
}

object FutureLongProcessTest3 extends App {

  def longRunningProcess(x: Int) = {
    Thread.sleep(100000)
    "result of long running process"
  }

  def shortRunningProcess(x: Int) = {
    "result of short running process"
  }

  val f1 = Future(longRunningProcess(10))
  val f2 = Future(shortRunningProcess(20))

  val result = for {
    longResult <- f1
    shortResult <- f2
    //it waits for longResult to finish
  } yield shortResult

  //Future timeout, simple, duh

  val res = Await.result(result, 5.seconds)
  println("Result is : " + res)
  Thread.sleep(20000)
}

object FutureLongProcessTest4 extends App {

  def longRunningProcess(x: Int) = {
    Thread.sleep(100000)
    "result of long running process"
  }

  def shortRunningProcess(x: Int) = {
    "result of short running process"
  }

  val f1 = Future(longRunningProcess(10))
  val f2 = Future(shortRunningProcess(20))

  val result = for {
     _<- f1
    shortResult <- f2
    //it waits for longResult to finish
  } yield shortResult

  //Future timeout, simple, duh

  val res = Await.result(result, 5.seconds)
  println("Result is : " + res)
  Thread.sleep(20000)
}
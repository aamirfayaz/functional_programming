package utilities

object StringUtilities {

    //def isEmpty(s: String): Boolean = Option(s).forall(_.isEmpty)
    def isEmpty(s: String): Boolean = s == null || s.trim.isEmpty

  //Todo: implement this method for string emptiness
  //look out: https://www.google.com/search?q=pattern+match+unapply+method+scala&oq=pattern+match+unapply+method+scala&aqs=chrome..69i57j33i22i29i30.4405j0j7&sourceid=chrome&ie=UTF-8
   object EmptyString {
     def unapply(s: String): Option[String] = {
       if(isEmpty(s)) None else Some(s)
     }
   }


}

object ListUtilities {
  def getUniquesList:List[Int] = {
    import util.Random.nextInt
    LazyList.continually(nextInt(20)).take(15).toSet.toList
  }
}
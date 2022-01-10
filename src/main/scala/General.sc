import scala.collection.mutable

val m = new mutable.HashMap[String, String]()
m.put("1", "one")
m.put("2", "two")
m.put("3", "three")
m.put("2", "twoloo")
m
m.remove("2")
m
m.put("2", "two")
m
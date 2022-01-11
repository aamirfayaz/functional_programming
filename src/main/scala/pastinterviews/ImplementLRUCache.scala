package pastinterviews

import scala.collection.mutable.HashMap

/**
LRU cache stand for Least Recently Used Cache, which evict least recently used entry.
As Cache purpose is to provide fast and efficient way of retrieving data,
it need to meet certain requirement.
Some of the Requirement are
Fixed Size: Cache needs to have some bounds to limit memory usages.
Fast Access: Cache Insert and lookup operation should be fast , preferably O(1) time.

When we think about O(1) lookup , obvious data structure comes in our mind is HashMap.
HashMap provide O(1) insertion and lookup. but HashMap does not has mechanism of tracking
which entry has been queried recently and which not.
To track this we require another data-structure which provide fast insertion ,
deletion and updation , in case of LRU we use Doubly Linkedlist .
Reason for choosing doubly LinkList is O(1) deletion , updation and insertion
if we have the address of Node on which this operation has to perform


 */
case class Cache[V](key: String, value: V)
//todo: buy from https://www.scala-algorithms.com/ and check FP implementation
//LRU remove

object LRU {
  def apply[V]() =  new LRU[V]()
}
class LRU[V] {

  private val map = new HashMap[String, Cache[V]]()
  var list = List[String]()

  val capacity = 4

  def put(key: String, value: V) = {

     if (map.contains(key)) {
      val cache = map(key)
      list = list.filterNot(_ == cache.key)
    } else {
      if (list.size.equals(capacity)) {
        map.remove(list.last)
         list = list.init
      }
    }
    map.put(key, Cache(key, value))
    list = key :: list

  }

  def get(key: String) = {
    if (map.contains(key)) {
      val cache: Cache[V] = map(key)
      list = list.filterNot(_ == cache.key)
      list = cache.key :: list
      cache.value
    } else "key not found"
  }
}

case class Employee(id: Int, name: String)
object LRU_Cache_Test extends App {

  val cache: LRU[String] = LRU[String]()
  cache.put("1", "Value_1")
  cache.put("2", "Value_1")
  cache.put("3", "Value_1")
  cache.put("4", "Value_1")
  cache.put("5", "Value_1")

  println(cache.list)
  cache.put("4", "Value_1")
  cache.put("9", "Value_1")
  println(cache.list)

  val cache2: LRU[Employee] = LRU[Employee]()
  cache2.put("1", Employee(1, "abc"))
  cache2.put("2", Employee(2, "def"))
  cache2.put("3", Employee(3, "ghi"))
  cache2.put("4", Employee(4, "ret"))
  cache2.put("5", Employee(5, "wsx"))
  println(cache2.list)


}

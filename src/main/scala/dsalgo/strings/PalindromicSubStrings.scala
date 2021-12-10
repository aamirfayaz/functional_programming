package dsalgo.strings

import scala.annotation.tailrec

object PalindromicSubStrings extends App {
//O(n * n)

    /*
       abc = a, b, c, ab, bc, abc
       i = 0, j = 1 ,2, 3
       i = 1, j = 2, 3
       i = 2, j = 3
     */
    def printSubStrings(s: String): Unit = {
        for(i <- 0 until s.length) {
            for(j <- i + 1 to s.length) {
                println(s.substring(i, j))
            }
        }
    }

    def isPalindrome(s: String): Boolean = {
        @tailrec
        def rec(s: String, start: Int = 0, end: Int): Boolean = {
            if(start < end) {
                if(s(start) != s(end)) false else rec(s, start + 1, end - 1)
            } else true
        }
        rec(s, end = s.length - 1)
    }

    def printPalindromicSubStrings(s: String):Unit = {
        for(i <- 0 until s.length) {
            for(j <- i + 1 to s.length) {
                if(isPalindrome(s.substring(i, j))) println(s.substring(i, j))
            }
        }
    }

    //println(isPalindrome("arora"))
    //println(isPalindrome("madam"))
    //println(isPalindrome("hello"))
    //printSubStrings("abc")
    printPalindromicSubStrings("abac")
}
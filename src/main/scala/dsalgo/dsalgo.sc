val s = "aaaabbcddefff"
val c = s.charAt(0)
s.dropWhile(_ == c)
s.count(_ == c)
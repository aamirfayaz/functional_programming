package dsalgo.stacks

object BalancedParenthesis extends App {

  def areParenthesisBalanced(str: String): Boolean = {
    def checkBalanceRec(str: String, stk: MyStack[Char]): Boolean = {
      if (str.isEmpty) {
        if (stk.isEmpty) true else false
      } else {
        val headChar = str.head
        if (headChar == '{' || headChar == '[' || headChar == '(')
          checkBalanceRec(str.tail, stk.push(headChar))
        else {
          if (headChar == '}' || headChar == ']' || headChar == ')') {
            if (stk.isEmpty) false else {
              if (!areCharsMatching(stk.peek.getOrElse(' '), headChar)) false
              else checkBalanceRec(str.tail, stk.pop()._2)
            }
          } else checkBalanceRec(str.tail, stk)
        }
      }
    }

    checkBalanceRec(str, MyStack.empty)
  }

  def areCharsMatching(c1: Char, c2: Char): Boolean = (c1, c2) match {
    case ('(', ')') => true
    case ('{', '}') => true
    case ('[', ']') => true
    case _          => false
  }

  println(areParenthesisBalanced("[{()}]"))
  println(areParenthesisBalanced("()[]{}"))
  println(areParenthesisBalanced("[(a+b)+{(c+d)*(e/f)]}"))
  println(areParenthesisBalanced("[(a+b)+{(c+d)*(e/f)}]"))
  println(areParenthesisBalanced("[(){()()}]"))

}
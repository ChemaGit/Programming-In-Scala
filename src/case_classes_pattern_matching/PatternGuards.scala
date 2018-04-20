package case_classes_pattern_matching

object PatternGuards extends App{
  /**
   * A match expression with a pattern guard
   */
  def simplifyAdd(e: Expr) = e match {
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
    case _ => e
  }
  /**
   * Some other examples of guarded patterns are:
   */
  // match only positive integers
  def onlyPositiveInt(x: Int) = x match {
    case n: Int if 0 < n => "It's must be positive"
    case _ => "Whatever...."
  }
  //match only strings starting with the letter 'a'
  def startWithA(s: String) = s match {
    case s: String if s(0) == 'a' => "I found it"
    case _ => "who knows....."
  }
  
}
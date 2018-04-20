package case_classes_pattern_matching

object PatternOverlaps extends App{
  
  /**
   * Match expression in which case order matters
   */
  def simplifyAll(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => simplifyAll(e) //'-' is its own inverse
    case BinOp("+", e, Number(0)) => simplifyAll(e) // '0' is a neutral element for '+'
    case BinOp("*", e, Number(1)) => simplifyAll(e) // '1' is a neutral element for '*'
    case UnOp(op, e) => UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
  }
  
  /**
   * that won’t compile because the first case will match anything that would be matched by the second case.
   * <console>:21: warning: unreachable code
   * case UnOp("",UnOp("",e)) => e  
   */
  def simplifyBad(expr: Expr): Expr = expr match {
    case UnOp(op, e) => UnOp(op, simplifyBad(e))
    case UnOp("", UnOp("",e)) => e
  }   
}
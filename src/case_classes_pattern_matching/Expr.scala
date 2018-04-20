package case_classes_pattern_matching

abstract class Expr 
/**
 * Defining case classes
 */
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object Expr {
  
  /**
   * The simplifyTop function, 
   * which does a pattern match.
   */
  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e  //Double negation
    case BinOp("+", e, Number(0)) => e // Adding zero
    case BinOp("*", e, Number(1)) => e //Multiplying by one
    case _ => expr
  }
  
  def main(args: Array[String]) {
    val v: Expr = Var("x")
    val op: Expr = BinOp("+", Number(1), v)
    println(v + " -- " + op)
    
    /**
     * A pattern match with an empty "default" case.
     */
    v match {
      case BinOp(op, left, right) =>
        println(v + " is a binary operation.")
      case _ =>  // handle the default case.
    }
  }
}
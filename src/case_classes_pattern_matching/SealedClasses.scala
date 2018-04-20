package case_classes_pattern_matching

/**
 * A sealed class cannot have any new subclasses except the ones in same file.
 * This is very useful for pattern matching because it means you only
 * need to worry about the subclasses you already know about.
 */

object SealedClasses extends App{
  /**
   * A sealed hierarchy of case classes
   */
  sealed abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
  
  /**
   * Now define a pattern match where some of the possible cases are left out:
   * You will get a compiler warning like the following:
	 *	warning: match is not exhaustive!
	 *	missing combination UnOp
	 *	missing combination BinOp  
   */
  def describe(e: Expr): String = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }
  
  /**
   * To make the warning go away, you could add a third catch-all
   * case to the method, like this:
   */
  def describeB(e: Expr): String = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
    case _ => throw new RuntimeException // Should not happen
  }  
  
  /**
   * A more lightweight alternative is to add an @unchecked annotation to
   * the selector expression of the match. This is done as follows:
   */
  def describeC(e: Expr): String = (e: @unchecked) match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }  
}
package case_classes_pattern_matching

import Element.elem
/**
 * The proposed task is to write an expression formatter
 * class that displays an arithmetic expression in a two dimensional layout.
 * x / (x + 1) =>    x
 *                --------
 *                x  +  1
 *                
 * ((a / (b * c) + 1 / n) / 3)  =>  a      1
 *                                ----- + ----        
 *                                b * c    n
 *                                ------------
 *                                     3        
 */

object Element {
  
  //Listing 10.3 - Defining ArrayElement as a subclass of Element.
  private class ArrayElement(val contents: Array[String]) extends Element {
    //Listing 10.4 - Overriding a parameterless method with a field.
    //Listing 10.5 - Defining contents as a parametric field.
  }  
  
  private class LineElement(s: String)extends Element {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
  }  
  
  private class UniformElement(ch: Char, override val width: Int, override val height: Int)extends Element {
    private val line = ch.toString * width 
    def contents = Array.fill(height)(line)
  }
  
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)
  
  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)
  
  def elem(line: String): Element =
    new LineElement(line)
}

//Listing 10.1 - Defining an abstract method and class.
abstract class Element {
  def contents: Array[String]
  //Listing 10.2 - Defining parameterless methods width and height.
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length()
  
  //10.12 Implementing above, beside, and toString 
  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    assert(this1.width == that1.width) //Listing 14.1 - Using an assertion.
    elem(this1.contents ++ that1.contents)
  }
  
  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem( 
        for ((line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )  
  }
    
  def widen(w: Int): Element =
    if(w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      var right = elem(' ', w - width - left.width, height)
      left beside this beside right
    } ensuring (w <= _.width) //Listing 14.2 - Using ensuring to assert a function's result.
  
  def heighten(h: Int): Element =
    if(h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      var bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
  
  override def toString = contents mkString "\n"
}

object ALargerExample extends App{
  sealed abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String,left: Expr, right: Expr) extends Expr
  class ExprFormatter {
    // Contains operators in groups of increasing precedence
     private val opGroups = Array(
      Set("|", "||"),
      Set("&", "&&"),
      Set("ˆ"),
      Set("==", "!="),
      Set("<", "<=", ">", ">="),
      Set("+", ""),
      Set("*", "%")
    )
    // A mapping from operators to their precedence
    private val precedence = {
      val assocs =
        for {
          i <- 0 until opGroups.length 
          op <- opGroups(i) 
          } yield op -> i
				assocs.toMap
		}
		private val unaryPrecedence = opGroups.length
		private val fractionPrecedence = 1    
		
    private def format(e: Expr, enclPrec: Int): Element =
      e match {
        case Var(name) => elem(name)
        case Number(num) =>
          def stripDot(s: String) =
            if (s endsWith ".0") s.substring(0, s.length - 2)
            else s
          elem(stripDot(num.toString))
        case UnOp(op, arg) => elem(op) beside format(arg, unaryPrecedence)
        case BinOp("/", left, right) =>
          val top = format(left, fractionPrecedence)
          val bot = format(right, fractionPrecedence)
          val line = elem('-', top.width max bot.width, 1)
          val frac = top above line above bot
          if (enclPrec != fractionPrecedence) frac
          else elem(" ") beside frac beside elem(" ")
        case BinOp(op, left, right) =>
          val opPrec = precedence(op)
          val l = format(left, opPrec)
          val r = format(right, opPrec + 1)
          val oper = l beside elem(" " + op + " ") beside r
          if (enclPrec <= opPrec) oper
          else elem("(") beside oper beside elem(")")
      }
    def format(e: Expr): Element = format(e, 0)		        
  }
  
  /**
   * An application that prints formatted expressions.
   */
  val f = new ExprFormatter
  
  val e1 = BinOp("*", BinOp("/", Number(1), Number(2)),BinOp("+", Var("x"), Number(1)))
  val e2 = BinOp("+", BinOp("/", Var("x"), Number(2)),BinOp("/", Number(1.5), Var("x")))
  val e3 = BinOp("/", e1, e2)
  
  def show(e: Expr) = println(f.format(e)+ "\n\n")
  
  for (e <- Array(e1, e2, e3)) show(e)  
  /**  This will give the following output:
    1
    - *(x + 1)
    2
    
    
    x   1.5
    - + ---
    2    x
        
    
    1
    - * (x + 1)
    2
    ----------
     x   1.5
     - + ---
     2    x  
  
  */
}
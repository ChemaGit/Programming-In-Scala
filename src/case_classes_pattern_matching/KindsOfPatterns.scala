package case_classes_pattern_matching

object KindsOfPatterns extends App{
  val v: Expr = Var("x")
  val op: Expr = BinOp("+", Number(1), v)
  val ex: Expr = BinOp("-", Number(5), v)
  val ex2 = List("Pepe", "Philip")
  
  /**
   * Wildcard patterns
   * A pattern match with an empty "default" case.
   * The wildcard pattern (_) matches any object.
   */
  v match {
    case BinOp(op, left, right) =>
      println(v + " is a binary operation.")
    case _ =>  // handle the default case.
  }   
  //A pattern match with wildcard patterns
  op match {
    case BinOp(_,_,_) => println(op + " is a binary operation.")
    case _ => println("It's something else.")
  }
  
  /**
   * Constants patterns.
   * A constant pattern matches only itself.
   * Any literal may be used as a constant.
   */
  def describe(x: Any): String = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }
  val expr: AnyVal = ""
  /**
   * Variable patterns.
   * A variable pattern matches any object.
   * Scala binds the variable to whatever the object is.
   */
  expr match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }
  
  import math.{E, Pi}
  E match {
    case Pi => "strange math? Pi = " + Pi
    case _ => "OK"
  }  
  
  val pi = math.Pi
  E match {
    case pi => "strange math? Pi = " + pi //res45: String = strange math? Pi = 2.718281828459045
  }
  
  //`pi` would again be interpreted as a constant, not as a variable
  E match {
    case `pi` => "strange math? Pi = " + pi
    case _ => "OK" //res25: String = OK
  }
  
  /**
   * Constructor patterns
   */
  //a pattern match with a constructor pattern
  ex match {
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ => 
  }
  
  /**
   * Sequence patterns
   */
  //A sequence pattern with a fixed length
  ex2 match {
    case List("Ramon", _, _) => println("found it")
    case _ =>
  }
  //A sequence pattern with an arbitrary length
  ex2 match {
    case List("Pepe",_*) => println("found it")
    case _ =>
  }
  
  /**
   * Tuple patterns
   */
  //A pattern match with a tuple pattern
  def tupleDemo(expr: Any)= 
    expr match {
      case (a, b, c) => println("matched " + a + b + c)
      case _ =>
  }
  
  /**
   * Typed patterns
   */
  //A pattern match with typed patterns
  def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case l: List[_] => l.length
    case _ => -1
  }
  
  //another for of typed patterns
  //Using isInstanceOf and asInstanceOf (poor style)
  val x: Any = "dogs and cats"
  if(x.isInstanceOf[String]) {
    val s = x.asInstanceOf[String]
    s.length
  } else {
    println("whatever")
  }
  
  /**
   * Type erasure
   */
  def isIntIntMap(x: Any) = x match { //it's not working well
    case m: Map[Int, Int] => true
    case _ => false
  }
  
  def isStringArray(x: Any) = x match {  //it is working well
    case a: Array[String] => "yes"
    case _ => "no"
  }
  
  /**
   * Variable binding
   */
  //A pattern with a variable binding (via the @ sign)
  def variableBindind(expr: Any) = {
    expr match {
      case UnOp("abs", e @ UnOp("abs", _)) => e
      case _ =>
    }
  }
}
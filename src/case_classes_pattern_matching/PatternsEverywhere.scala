package case_classes_pattern_matching

object PatternsEverywhere extends App{
  /**
   * Patterns in variable definitions
   */
  //Defining multiple variables with one assignment
  val myTuple = (123, "abc") //myTuple: (Int, String) = (123, "abc")
  val (number, string) = myTuple //number: Int = 123; string: String = abc  
  
  //If you know the precise case class you are working with, then you can deconstruct it with a pattern
  val exp = new BinOp("*", Number(5), Number(1)) //exp: BinOp = BinOp(*,Number(5.0),Number(1.0))
  val BinOp(op, left, right) = exp //op: String = *, left: Expr = Number(5.0), right: Expr = Number(1.0)  
  
  /**
   * Case sequences as partial functions
   */
  val withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }  
  withDefault(Some(10)) //res28: Int = 10
  withDefault(None) //res29: Int = 0  
  
  val second: List[Int] => Int = { //<console>:17: warning: match is not exhaustive! missing combination Nil
    case x :: y :: _ => y
  }   
  second(List(5, 6, 7)) //res24: Int = 6
  second(List()) //scala.MatchError: List()

  //Here is the second function again, this time written with a partial function type
  val second2: PartialFunction[List[Int],Int] = {
    case x :: y :: _ => y
  }  
  second2.isDefinedAt(List(5,6,7)) //res30: Boolean = true
  second2.isDefinedAt(List()) //res31: Boolean = false  
  
  /**
   * Patterns in for expressions
   */
  //A for expression with a tuple pattern.
  val capitals = Map("España" -> "Madrid", "Francia" -> "Paris", "Japon" -> "Tokyo")
  for ((country, city) <- capitals)
		println("The capital of " + country + " is " + city)  
	//Picking elements of a list that match a pattern	
  //the second element None in the results list does not match the pattern Some(fruit)
  val results = List(Some("apple"),None,Some("orange"))	
  for (Some(fruit) <- results)
    println(fruit)
}
package functions_and_closures

object FirstClassFunctions {
  
  val increase = (x: Int) => x + 1
  
  val increaseB = (x: Int) => {
    println("We")
    println("are")
    println("here!")
    x + 52
  }
  
  /**
   * SHORT FORMS OF FUNCTION LITERALS
   */
  /**
   * PLACEHOLDER SYNTAX
   */    
  val f = (_: Int) + (_: Int)  
  /**
   * PARTIALLY APPLIED FUNCTIONS
   */   
  def sum (a: Int, b: Int, c: Int) = a + b + c 
  
  def main(args: Array[String]) {
    println(increase(10))
    println(increaseB(10))
    
    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.foreach((x: Int) => println(x))
    println(someNumbers.filter((x: Int) => x > 0))
    println("**************************")
  /**
   * SHORT FORMS OF FUNCTION LITERALS
   */
    println(someNumbers.filter((x) => x > 0))
    println(someNumbers.filter(x => x > 0))
    println("**************************")
  /**
   * PLACEHOLDER SYNTAX
   */    
    println(someNumbers.filter(_ > 0))   
    println(f(6,9))
    println("**************************")
  /**
   * PARTIALLY APPLIED FUNCTIONS
   */      
    someNumbers.foreach(println _)
    println(sum(1,2,3))
    val a = sum _
    println(a(3,2,5))
    val b = sum(1, _: Int, 3)
    println(b(32))
    someNumbers.foreach(println)
   
  }
}
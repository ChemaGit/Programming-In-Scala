package functions_and_closures

object TailRecursion {
  
  /**
   * This function is not a tail recursive, because it performs an increment operation
   * after the recursive call
   */
  def boom(x: Int): Int =
    if (x == 0) throw new Exception("boom!")
    else boom(x - 1) + 1
    
  /**
   * A tail recursive function  
   */
  def bang(x: Int): Int =
    if(x == 0) throw new Exception("bang!")
    else bang(x - 1)
    
  /**
   * Limits of tail recursion  
   * If the recursion is indirect, as in the example of two 
   * mutually recursive functions, no optimization is possible.
   */
  def isEven(x: Int): Boolean =
    if (x == 0) true else isOdd(x - 1)
    
  def isOdd(x: Int): Boolean =
    if (x == 0) false else isEven(x - 1)
  
  /**
   * won't get a tail-call optimization if the final call goes to a function
   * value  
   */
  def funValue = nestedFun _
  def nestedFun(x: Int): Unit = {
    if(x != 0) {println(x); funValue(x - 1)}    
  }
  
  def main(args: Array[String]) {
    //boom(3)
    //bang(5)
  }
}
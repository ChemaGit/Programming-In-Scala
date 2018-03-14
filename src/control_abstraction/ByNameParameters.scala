package control_abstraction

object ByNameParameters {
  
  var assertionsEnabled = true
  
  def myAssert(predicate: () => Boolean) =
    if(assertionsEnabled && !predicate())
      throw new AssertionError
      
  def byNameAssert(predicate: => Boolean) =
    if(assertionsEnabled && !predicate)
      throw new AssertionError
      
  def boolAssert(predicate: Boolean) =
    if(assertionsEnabled && !predicate)
      throw new AssertionError
  
  def main(args: Array[String]) {
    println(myAssert(() => 5 > 3))
    println(byNameAssert(5 > 3))
    println(boolAssert(5 > 3))
  }
}
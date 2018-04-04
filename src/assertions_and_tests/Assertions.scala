package assertions_and_tests

object Assertions {
  //Listing 14.1 - Using an assertion.
  def testAssert(num: Int): String = {
    if(num < 0) {
      assert(num < 0)
    }
    "Love"
  }
  
  //Listing 14.1 - Using an assertion with explanation
  def testAssertExplanation(num: Int): String = {
    if(num < 0) {
      assert(num < 0, "Julia")
    }
    "Bella"    
  }
  
  //Listing 14.2 - Using ensuring to assert a function's result.
  def testEnsuring(num: Int): String = {
    if(num < 0) {
      println("Dillion")
    } ensuring(num >= 0) 
    "Ava"
  }  
  
  def main(args: Array[String]) {
    val num = -1
    testAssert(num)    
  }
  
}
package control_abstraction

object SimplifyingClientCode {
  
  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
    for(num <- nums)
      if(num < 0)
        exists = true
    exists    
  }
  
  def containsOdd(nums: List[Int]): Boolean = {
    var exists = false
    for(num <- nums)
      if (num % 2 == 1)
        exists = true
    exists    
  }
  
  /**
   * A more concise way to define the method, is calling the higher-order
   * function exists on the passed List
   */
  def containsNegB(nums: List[Int]) = nums.exists(_ < 0)
  
  def constainsOddB(nums: List[Int]) = nums.exists(_ %2 == 1)
  
  def main(args: Array[String]) {
    println(containsNeg(List(1,2,3,4)))
    println(containsNeg(List(1,2,-3,4)))
    println("*************")
    println(containsNegB(List(1,2,3,4)))
    println(containsNegB(List(1,2,-3,4)))    
  }
}
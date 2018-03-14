package control_abstraction

object Currying {
  
  def plainOldSum(x: Int, y: Int) = x + y
  
  def curriedSum(x: Int)(y: Int) = x + y
  
  def first(x: Int) = (y: Int) => x + y
  
  def main(args: Array[String]) {
    val second = first(1)    
    println(second(5))
    
    val onePlus = curriedSum(1)_
    println(onePlus(15))
    
    val twoPlus = curriedSum(2)_
    println(twoPlus(25))
  }
}
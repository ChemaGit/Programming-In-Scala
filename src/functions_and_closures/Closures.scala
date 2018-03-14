package functions_and_closures

object Closures {
  /**
   * CLOSURES
   */
  var more = 10
  //this function is a closure
  val a = (x: Int) => x + more
  
  val someNumbers = List(-11, -10, -5, 0, 5, 10)
  var sum = 0
  
  def makeIncreaser(more: Int) = (x: Int) => x + more
  val inc1 = makeIncreaser(1)
  val inc2 = makeIncreaser(594)
  
  /**
   * SPECIAL FUNCTIONS CALL FORM
   */
  def echo(args: String*) =
    for(arg <- args) println(arg)
  
  val arr = Array("Julia Ann", "Brandi Love", "Kendra Lust", "Ava Addams")  
  
  def speed(distance: Float, time: Float): Float =
    distance / time
    
  /**
   * A method with a default value  
   */
  def printTime(out: java.io.PrintStream = Console.out) =
    out.println("time = " + System.currentTimeMillis())
    
  def printTime2(out: java.io.PrintStream = Console.out, divisor: Int = 1) =
    out.println("time = " + System.currentTimeMillis() / divisor)
  
  def main(args: Array[String]) {
    /**
     * CLOSURES
     */    
    println(a(10))
    more = 30
    println(a(10))
    someNumbers.foreach(sum += _)
    println(sum)
    println("***********************")
    println(inc1(10))
    println(inc1(15))
    println(inc2(30))
    /**
     * SPECIAL FUNCTIONS CALL FORM
     */    
    println("*****SPECIAL FUNCTIONS CALL FORM******************")
    echo()
    echo("Ava Devine")
    //passing Strings
    echo("Ava Devine","Mercedes","Deauxma")
    //passing an Array
    echo(arr: _*)
    println(speed(100,10))
    //named arguments
    println(speed(time = 10, distance = 100))
    //Default parameter values
    println(printTime())
    println(printTime2(divisor = 1000))
  }
}
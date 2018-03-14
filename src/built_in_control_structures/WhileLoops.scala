package built_in_control_structures

object WhileLoops extends App{
  
  def greet() = {println("Hi")}
  println(()== greet())
  
  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while(a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }  
  
  def gcd(x: Long, y: Long): Long =
    if(y == 0) x else gcd(y, x % y)
  
  var line = ""
  do {
    line = readLine()
    println("Read: " + line)
  } while(line != "")
}
package built_in_control_structures

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

import java.net.URL
import java.net.MalformedURLException

//TODO: Yielding a value
object ExceptionHandlingWithTryExpressions extends App{
  val n = 10
  val half =
    if (n % 2 == 0)
      n / 2
    else
      throw new RuntimeException("n must be even")
  println(half)
  
  def f(): Int = try return 1 finally return 2  
  println(f)  
  
  def g(): Int = try 1 finally 2
  println(g) 
 
  
  def fileException() {
    val file = new FileReader("input.txt")
    try {    
      // Use and close file
    } catch {
      case ex: FileNotFoundException => // Handle missing file
      case ex: IOException => // Handle other I/O error  
    } finally {
      file.close()  // Be sure to close the file
    }    
  }
  
  def urlFor(path: String) =
    try {
      new URL(path)
    } catch {
      case e: MalformedURLException => new URL("http://www.scala-lang.org")
    }
}
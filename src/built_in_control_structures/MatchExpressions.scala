package built_in_control_structures

import scala.util.control.Breaks._
import java.io._

object MatchExpressions extends App{
  
  def food(firstArg: String): String = {
    firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "What the fuck?"
    }
  }
  
  /**
   * LIVING WITHOUT BREAK AND CONTINUE
   */
  //Bad code in Scala
  def search(arg: Array[String]): Boolean = {
    var i = 0
    var foundIt = false
    
    while(i < arg.length && !foundIt) {
      if(!arg(i).startsWith("-")) {
        if(arg(i).endsWith(".scala"))
          foundIt = true
      }
    }
    foundIt
  }
  
  def searchFrom(i: Int): Int = 
    if(i >= args.length) -1
    else if(args(i).startsWith("-")) searchFrom(i + 1)
    else if(args(i).endsWith(".scala")) i
    else searchFrom(i + 1)
  /**
   * Using Break in Scala, though it is not a good style
   */
  def readSystem() {
      val in = new BufferedReader(new InputStreamReader(System.in))
      breakable {
        while(true) {
          println("? ")
          if(in.readLine() == "") break
        }
      }
  }
  
  /**
   * VARIABLE SCOPE
   */
  def printMultiTable() = {
    var i = 1
    //only i in scope here
    while(i <= 10) {
      var j = 1
      //both i and j in scope here
      while(j <= 10) {
        val prod = (i * j).toString
        //i, j and prod in scope here
        var k = prod.length
        //i, j, prod, and k in scope here
        while(k < 4) {
          print(" ")
          k += 1
        }
        print(prod)
        j += 1
      }
      //i and j still in scope: prod and k out of scope
      println()
      i += 1
    }
    //i still in scope: j, prod, and k out of scope
  }
  
  def yesCompile() = {
    val a = 1;
    {
      val a = 2 //compile just fine
      println(a)
    }
    println(a)
  }
  
  /**
   * REFACTORING IMPERATYVE-STYLE CODE
   */
  /**
   * A functional way to create a multiplication table.
   */
  //Returns a row as a sequence
  def makeRowSeq(row: Int) =
    for(col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod      
    }
  
  //Returns a row as a string
  def makeRow(row: Int) = makeRowSeq(row).mkString
  
  //Returns a table as a string with one row per line
  def multiTable() = {
    val tableSeq = //a sequence of row strings
      for(row <- 1 to 10)
        yield makeRow(row)
    tableSeq.mkString("\n")
  }
  
  println(multiTable)
}
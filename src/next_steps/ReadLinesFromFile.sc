package next_steps
import scala.io.Source
object ReadLinesFromFile {
  val args = Array("C:\\Users\\chema\\mymooc-workspace\\ProgrammingInScala\\src\\text.txt")
                                                  //> args  : Array[String] = Array(C:\Users\chema\mymooc-workspace\ProgrammingInS
                                                  //| cala\src\text.txt)
  def widthOfLength(s: String) = s.length.toString.length
                                                  //> widthOfLength: (s: String)Int
  def readFile(args: Array[String]): Unit = {
    val lines = Source.fromFile(args(0)).getLines.toList
    val longestLine = lines.reduceLeft( (a,b) => if(a.length > b.length) a else b)
    val maxWidth = widthOfLength(longestLine)
    if(args.length > 0) {
      for(line <- lines) {
        val numSpaces = maxWidth - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + " : " + line)
      }
    }
  }                                               //> readFile: (args: Array[String])Unit
  
  readFile(args)                                  //>  1 : K
                                                  //|  8 : caracola
                                                  //| 13 : Hola caracola
                                                  //| 20 : que pasa con tu cola
                                                  //| 26 : que no desayunas coca cola
}
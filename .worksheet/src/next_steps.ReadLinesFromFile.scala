package next_steps
import scala.io.Source
object ReadLinesFromFile {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(160); 
  val args = Array("C:\\Users\\chema\\mymooc-workspace\\ProgrammingInScala\\src\\text.txt");System.out.println("""args  : Array[String] = """ + $show(args ));$skip(58); 
  def widthOfLength(s: String) = s.length.toString.length;System.out.println("""widthOfLength: (s: String)Int""");$skip(450); 
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
  };System.out.println("""readFile: (args: Array[String])Unit""");$skip(20); 
  
  readFile(args)}
}

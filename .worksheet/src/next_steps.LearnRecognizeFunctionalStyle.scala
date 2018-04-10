package next_steps

object LearnRecognizeFunctionalStyle {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(118); 
  val args = Array("Ava", "Ann", "Brandi", "Lust", "Timea");System.out.println("""args  : Array[String] = """ + $show(args ));$skip(94); 
  
  def printArgs(args: Array[String]): Unit = {
    for(arg <- args)
      println(arg)
  };System.out.println("""printArgs: (args: Array[String])Unit""");$skip(81); 
  
  def printArgsB(args: Array[String]): Unit = {
    args.foreach(println)
  };System.out.println("""printArgsB: (args: Array[String])Unit""");$skip(61); 
 
  def formatArgs(args: Array[String]) = args.mkString(",");System.out.println("""formatArgs: (args: Array[String])String""");$skip(19); 
  printArgsB(args);$skip(31); 
  
  println(formatArgs(args));$skip(32); 
  
  val res = formatArgs(args);System.out.println("""res  : String = """ + $show(res ));$skip(45); 
  assert(res == "Ava,Ann,Brandi,Lust,Timea")}
  
  
}

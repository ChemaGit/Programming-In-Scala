package basic_types_and_operations

object StringInterpolation {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(98); 
  println("String Interpolation");$skip(22); 
  val name = "reader";System.out.println("""name  : String = """ + $show(name ));$skip(28); 
  println(s"Hello, $name!");$skip(42); 
  val answer = s"The answer is ${6 * 7}.";System.out.println("""answer  : String = """ + $show(answer ));$skip(18); 
  println(answer);$skip(35); 
  val noScape = raw"No\\\\escape!";System.out.println("""noScape  : String = """ + $show(noScape ));$skip(19); 
  println(noScape);$skip(35); 
  val formatPi = f"${math.Pi}%.5f";System.out.println("""formatPi  : String = """ + $show(formatPi ));$skip(20); 
  println(formatPi);$skip(16); 
  val pi = "Pi";System.out.println("""pi  : String = """ + $show(pi ));$skip(53); 
  val piApp = f"$pi is approximately ${math.Pi}%.8f";System.out.println("""piApp  : String = """ + $show(piApp ));$skip(17); 
  println(piApp)}
  
}

package next_steps

object Tuples {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
  val pair = (99, "Luftballons");System.out.println("""pair  : (Int, String) = """ + $show(pair ));$skip(19); 
  println(pair._1);$skip(19); 
  println(pair._2);$skip(40); 
  val tuple1 = ('u','r',"the",1,4,"me");System.out.println("""tuple1  : (Char, Char, String, Int, Int, String) = """ + $show(tuple1 ))}
}

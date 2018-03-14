package basic_types_and_operations

object OperatorsAreMethods {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  println("Operators are Methods");$skip(18); 
  val sum = 1 + 2;System.out.println("""sum  : Int = """ + $show(sum ));$skip(20); 
  val sum1 = 1.+(2);System.out.println("""sum1  : Int = """ + $show(sum1 ));$skip(23); 
  val longSum = 1 + 2L;System.out.println("""longSum  : Long = """ + $show(longSum ));$skip(26); 
  val s = "Hello, world!";System.out.println("""s  : String = """ + $show(s ));$skip(25); 
  println(s indexOf 'o');$skip(30); 
  println(s indexOf ('o', 5));$skip(25); 
  println(s toLowerCase)}
}

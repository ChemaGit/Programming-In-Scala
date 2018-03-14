package basic_types_and_operations

object BitwiseOperations {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
  println("Bitwise Operations");$skip(20); 
  val and = (1 & 2);System.out.println("""and  : Int = """ + $show(and ));$skip(19); 
  val or = (1 | 2);System.out.println("""or  : Int = """ + $show(or ));$skip(20); 
  val cir = (1 ^ 3);System.out.println("""cir  : Int = """ + $show(cir ));$skip(15); 
  val n = (~1);System.out.println("""n  : Int = """ + $show(n ));$skip(21); 
  val s = (-1 >> 31);System.out.println("""s  : Int = """ + $show(s ));$skip(22); 
  val s1 = (-1 >>>31);System.out.println("""s1  : Int = """ + $show(s1 ));$skip(20); 
  val s3 = -1 >>> 1;System.out.println("""s3  : Int = """ + $show(s3 ));$skip(20); 
  val s2 = (1 << 2);System.out.println("""s2  : Int = """ + $show(s2 ))}
  
}

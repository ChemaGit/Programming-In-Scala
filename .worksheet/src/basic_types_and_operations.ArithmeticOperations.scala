package basic_types_and_operations

object ArithmeticOperations {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  println("ArithmeticOperations");$skip(12); val res$0 = 
  1.2 + 2.3;System.out.println("""res0: Double(3.5) = """ + $show(res$0));$skip(8); val res$1 = 
  3 - 1;System.out.println("""res1: Int(2) = """ + $show(res$1));$skip(12); val res$2 = 
  'b' - 'a';System.out.println("""res2: Int(1) = """ + $show(res$2));$skip(9); val res$3 = 
  2 * 3L;System.out.println("""res3: Long(6L) = """ + $show(res$3));$skip(9); val res$4 = 
  11 / 4;System.out.println("""res4: Int(2) = """ + $show(res$4));$skip(9); val res$5 = 
  11 % 4;System.out.println("""res5: Int(3) = """ + $show(res$5));$skip(15); val res$6 = 
  11.0f / 4.0f;System.out.println("""res6: Float(2.75) = """ + $show(res$6));$skip(13); val res$7 = 
  11.0 % 4.0;System.out.println("""res7: Double(3.0) = """ + $show(res$7));$skip(32); val res$8 = 
  math.IEEEremainder(11.0, 4.0);System.out.println("""res8: Double = """ + $show(res$8));$skip(19); 
  val neg = 1 + -3;System.out.println("""neg  : Int = """ + $show(neg ));$skip(13); 
  val y = +3;System.out.println("""y  : Int = """ + $show(y ));$skip(7); val res$9 = 
  -neg;System.out.println("""res9: Int = """ + $show(res$9))}
}

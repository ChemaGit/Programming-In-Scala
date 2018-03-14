package basic_types_and_operations

object ObjectEquality {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 
  println("Object Equality");$skip(9); val res$0 = 
  1 == 2;System.out.println("""res0: Boolean(false) = """ + $show(res$0));$skip(9); val res$1 = 
  1 != 2;System.out.println("""res1: Boolean(true) = """ + $show(res$1));$skip(9); val res$2 = 
  2 == 2;System.out.println("""res2: Boolean(true) = """ + $show(res$2));$skip(29); val res$3 = 
  List(1,2,3) == List(1,2,3);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(29); val res$4 = 
  List(1,2,3) == List(4,5,6);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(11); val res$5 = 
  1 == 1.0;System.out.println("""res5: Boolean(true) = """ + $show(res$5));$skip(25); val res$6 = 
  List(1,2,3) == "Hello";System.out.println("""res6: Boolean = """ + $show(res$6));$skip(22); val res$7 = 
  List(1,2,3) == null;System.out.println("""res7: Boolean = """ + $show(res$7));$skip(22); val res$8 = 
  null == List(1,2,3);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(28); val res$9 = 
  ("he" + "llo") == "hello";System.out.println("""res9: Boolean = """ + $show(res$9))}
  
}

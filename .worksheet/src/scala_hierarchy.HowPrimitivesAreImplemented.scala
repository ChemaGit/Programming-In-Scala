package scala_hierarchy

object HowPrimitivesAreImplemented {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(105); 
  println("How primitives are implemented");$skip(163); 
  
  //The equality operation == in Scala is designed to be transparent with respect to the type's representation
  def isEqual(x: Int, y: Int): Boolean = x == y;System.out.println("""isEqual: (x: Int, y: Int)Boolean""");$skip(20); val res$0 = 
  isEqual(421, 421);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(48); 
  def isEqualA(x: Any, y: Any):Boolean = x == y;System.out.println("""isEqualA: (x: Any, y: Any)Boolean""");$skip(21); val res$1 = 
  isEqualA(421, 421);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(81); 
  //In Scala, string comparison works as it should
  val x = "abcd".substring(2);System.out.println("""x  : String = """ + $show(x ));$skip(30); 
  val y = "abcd".substring(2);System.out.println("""y  : String = """ + $show(y ));$skip(9); val res$2 = 
  x == y;System.out.println("""res2: Boolean = """ + $show(res$2));$skip(31); 
  
  val z = new String("abc");System.out.println("""z  : String = """ + $show(z ));$skip(28); 
  val p = new String("abc");System.out.println("""p  : String = """ + $show(p ));$skip(32); val res$3 = 
  //equality reference
  z eq p;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(44); val res$4 = 
  //negation of equality reference
  z ne p;System.out.println("""res4: Boolean = """ + $show(res$4))}
}

package basic_types_and_operations

object OperatorPrecedenceAndAssociativity {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(130); 
  println("Operator Precedence And Associativity");$skip(12); val res$0 = 
  2 + 2 * 7;System.out.println("""res0: Int = """ + $show(res$0));$skip(14); val res$1 = 
  (2 + 2) * 7;System.out.println("""res1: Int = """ + $show(res$1));$skip(13); val res$2 = 
  2 << 2 + 2;System.out.println("""res2: Int = """ + $show(res$2));$skip(13); val res$3 = 
  2 + 2 << 2;System.out.println("""res3: Int = """ + $show(res$3));$skip(27); 
  println("Rich Wrappers");$skip(10); val res$4 = 
  0 max 5;System.out.println("""res4: Int = """ + $show(res$4));$skip(10); val res$5 = 
  0 min 5;System.out.println("""res5: Int = """ + $show(res$5));$skip(17); 
 
  val x = -2.7;System.out.println("""x  : Double = """ + $show(x ));$skip(8); val res$6 = 
  x.abs;System.out.println("""res6: Double = """ + $show(res$6));$skip(10); val res$7 = 
  x.round;System.out.println("""res7: Long = """ + $show(res$7));$skip(17); val res$8 = 
  1.5.isInfinity;System.out.println("""res8: Boolean = """ + $show(res$8));$skip(21); val res$9 = 
  (1.0/0).isInfinity;System.out.println("""res9: Boolean = """ + $show(res$9));$skip(9); val res$10 = 
  4 to 6;System.out.println("""res10: scala.collection.immutable.Range.Inclusive = """ + $show(res$10));$skip(19); val res$11 = 
  "bob".capitalize;System.out.println("""res11: String = """ + $show(res$11));$skip(19); val res$12 = 
  "robert".drop(2);System.out.println("""res12: String = """ + $show(res$12))}
  
  
}

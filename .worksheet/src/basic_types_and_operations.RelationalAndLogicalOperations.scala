package basic_types_and_operations

object RelationalAndLogicalOperations {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(123); 
  println("Relational and logical operations.");$skip(8); val res$0 = 
  1 > 2;System.out.println("""res0: Boolean(false) = """ + $show(res$0));$skip(8); val res$1 = 
  1 < 2;System.out.println("""res1: Boolean(true) = """ + $show(res$1));$skip(13); val res$2 = 
  1.0 <= 1.0;System.out.println("""res2: Boolean(true) = """ + $show(res$2));$skip(15); val res$3 = 
  3.5f >= 3.6f;System.out.println("""res3: Boolean(false) = """ + $show(res$3));$skip(13); val res$4 = 
  'a' >= 'A';System.out.println("""res4: Boolean(true) = """ + $show(res$4));$skip(21); 
  val untrue = !true;System.out.println("""untrue  : Boolean = """ + $show(untrue ));$skip(18); 
  val toBe = true;System.out.println("""toBe  : Boolean = """ + $show(toBe ));$skip(31); 
  val question = toBe || !toBe;System.out.println("""question  : Boolean = """ + $show(question ));$skip(30); 
  val paradox = toBe && !toBe;System.out.println("""paradox  : Boolean = """ + $show(paradox ));$skip(40); 
  def salt() = {println("salt"); false};System.out.println("""salt: ()Boolean""");$skip(43); 
  def pepper() = {println("pepper"); true};System.out.println("""pepper: ()Boolean""");$skip(21); val res$5 = 
  pepper() && salt();System.out.println("""res5: Boolean = """ + $show(res$5));$skip(21); val res$6 = 
  salt() && pepper();System.out.println("""res6: Boolean = """ + $show(res$6));$skip(20); val res$7 = 
  salt() & pepper();System.out.println("""res7: Boolean = """ + $show(res$7))}
 
 
}

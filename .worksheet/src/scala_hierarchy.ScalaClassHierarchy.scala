package scala_hierarchy

object ScalaClassHierarchy {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(90); 
  println("Scala's class hierarchy")
  
  abstract class ClassHierarchy {
  //Overriding methods of superclass Any
    override def ==(that: Any): Boolean
    override def !=(that: Any): Boolean
    override def equals(that: Any): Boolean
    override def ##(): Int
    override def hashCode: Int
    override def toString: String
  };$skip(370); val res$0 = 
  
  //The type Int supports all of the operations below
  42.toString;System.out.println("""res0: String = """ + $show(res$0));$skip(14); val res$1 = 
  42.hashCode;System.out.println("""res1: Int = """ + $show(res$1));$skip(15); val res$2 = 
  42 equals 42;System.out.println("""res2: Boolean = """ + $show(res$2));$skip(12); val res$3 = 
  42 max 43;System.out.println("""res3: Int = """ + $show(res$3));$skip(12); val res$4 = 
  42 min 43;System.out.println("""res4: Int = """ + $show(res$4));$skip(12); val res$5 = 
  1 until 5;System.out.println("""res5: scala.collection.immutable.Range = """ + $show(res$5));$skip(9); val res$6 = 
  1 to 5;System.out.println("""res6: scala.collection.immutable.Range.Inclusive = """ + $show(res$6));$skip(8); val res$7 = 
  3.abs;System.out.println("""res7: Int = """ + $show(res$7));$skip(11); val res$8 = 
  -(3.abs);System.out.println("""res8: Int = """ + $show(res$8))}
  
  
  
}

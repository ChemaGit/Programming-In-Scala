package scala_hierarchy

object BottomTypes {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(71); 
  println("Bottom types");$skip(202); 
  //Class null is the type of the null reference
  //Null is not compatible with value types: val i: Int = null => it doesn't work
  def error(message: String): Nothing =
    throw new RuntimeException;System.out.println("""error: (message: String)Nothing""");$skip(196); 
    
  //Because Nothing is a subtype of Int, the type of the whole conditional is Int, as required
  def divide(x: Int, y: Int): Int =
    if(y != 0) x / y
    else error("can't divide by zero");System.out.println("""divide: (x: Int, y: Int)Int""")}
}

package scala_hierarchy

object BottomTypes {
  println("Bottom types")                         //> Bottom types
  //Class null is the type of the null reference
  //Null is not compatible with value types: val i: Int = null => it doesn't work
  def error(message: String): Nothing =
    throw new RuntimeException                    //> error: (message: String)Nothing
    
  //Because Nothing is a subtype of Int, the type of the whole conditional is Int, as required
  def divide(x: Int, y: Int): Int =
    if(y != 0) x / y
    else error("can't divide by zero")            //> divide: (x: Int, y: Int)Int
}
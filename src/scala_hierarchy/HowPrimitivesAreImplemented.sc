package scala_hierarchy

object HowPrimitivesAreImplemented {
  println("How primitives are implemented")       //> How primitives are implemented
  
  //The equality operation == in Scala is designed to be transparent with respect to the type's representation
  def isEqual(x: Int, y: Int): Boolean = x == y   //> isEqual: (x: Int, y: Int)Boolean
  isEqual(421, 421)                               //> res0: Boolean = true
  def isEqualA(x: Any, y: Any):Boolean = x == y   //> isEqualA: (x: Any, y: Any)Boolean
  isEqualA(421, 421)                              //> res1: Boolean = true
  //In Scala, string comparison works as it should
  val x = "abcd".substring(2)                     //> x  : String = cd
  val y = "abcd".substring(2)                     //> y  : String = cd
  x == y                                          //> res2: Boolean = true
  
  val z = new String("abc")                       //> z  : String = abc
  val p = new String("abc")                       //> p  : String = abc
  //equality reference
  z eq p                                          //> res3: Boolean = false
  //negation of equality reference
  z ne p                                          //> res4: Boolean = true
}
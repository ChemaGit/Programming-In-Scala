package scala_hierarchy

object ScalaClassHierarchy {
  println("Scala's class hierarchy")              //> Scala's class hierarchy
  
  abstract class ClassHierarchy {
  //Overriding methods of superclass Any
    override def ==(that: Any): Boolean
    override def !=(that: Any): Boolean
    override def equals(that: Any): Boolean
    override def ##(): Int
    override def hashCode: Int
    override def toString: String
  }
  
  //The type Int supports all of the operations below
  42.toString                                     //> res0: String = 42
  42.hashCode                                     //> res1: Int = 42
  42 equals 42                                    //> res2: Boolean = true
  42 max 43                                       //> res3: Int = 43
  42 min 43                                       //> res4: Int = 42
  1 until 5                                       //> res5: scala.collection.immutable.Range = Range 1 until 5
  1 to 5                                          //> res6: scala.collection.immutable.Range.Inclusive = Range 1 to 5
  3.abs                                           //> res7: Int = 3
  -(3.abs)                                        //> res8: Int = -3
  
  
  
}
package basic_types_and_operations

object ObjectEquality {
  println("Object Equality")                      //> Object Equality
  1 == 2                                          //> res0: Boolean(false) = false
  1 != 2                                          //> res1: Boolean(true) = true
  2 == 2                                          //> res2: Boolean(true) = true
  List(1,2,3) == List(1,2,3)                      //> res3: Boolean = true
  List(1,2,3) == List(4,5,6)                      //> res4: Boolean = false
  1 == 1.0                                        //> res5: Boolean(true) = true
  List(1,2,3) == "Hello"                          //> res6: Boolean = false
  List(1,2,3) == null                             //> res7: Boolean = false
  null == List(1,2,3)                             //> res8: Boolean = false
  ("he" + "llo") == "hello"                       //> res9: Boolean = true
  
}
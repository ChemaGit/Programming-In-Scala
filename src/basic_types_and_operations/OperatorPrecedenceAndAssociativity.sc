package basic_types_and_operations

object OperatorPrecedenceAndAssociativity {
  println("Operator Precedence And Associativity")//> Operator Precedence And Associativity
  2 + 2 * 7                                       //> res0: Int = 16
  (2 + 2) * 7                                     //> res1: Int = 28
  2 << 2 + 2                                      //> res2: Int = 32
  2 + 2 << 2                                      //> res3: Int = 16
  println("Rich Wrappers")                        //> Rich Wrappers
  0 max 5                                         //> res4: Int = 5
  0 min 5                                         //> res5: Int = 0
 
  val x = -2.7                                    //> x  : Double = -2.7
  x.abs                                           //> res6: Double = 2.7
  x.round                                         //> res7: Long = -3
  1.5.isInfinity                                  //> res8: Boolean = false
  (1.0/0).isInfinity                              //> res9: Boolean = true
  4 to 6                                          //> res10: scala.collection.immutable.Range.Inclusive = Range 4 to 6
  "bob".capitalize                                //> res11: String = Bob
  "robert".drop(2)                                //> res12: String = bert
  
  
}
package basic_types_and_operations

object ArithmeticOperations {
  println("ArithmeticOperations")                 //> ArithmeticOperations
  1.2 + 2.3                                       //> res0: Double(3.5) = 3.5
  3 - 1                                           //> res1: Int(2) = 2
  'b' - 'a'                                       //> res2: Int(1) = 1
  2 * 3L                                          //> res3: Long(6L) = 6
  11 / 4                                          //> res4: Int(2) = 2
  11 % 4                                          //> res5: Int(3) = 3
  11.0f / 4.0f                                    //> res6: Float(2.75) = 2.75
  11.0 % 4.0                                      //> res7: Double(3.0) = 3.0
  math.IEEEremainder(11.0, 4.0)                   //> res8: Double = -1.0
  val neg = 1 + -3                                //> neg  : Int = -2
  val y = +3                                      //> y  : Int = 3
  -neg                                            //> res9: Int = 2
}
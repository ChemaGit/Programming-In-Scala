package basic_types_and_operations

object OperatorsAreMethods {
  println("Operators are Methods")                //> Operators are Methods
  val sum = 1 + 2                                 //> sum  : Int = 3
  val sum1 = 1.+(2)                               //> sum1  : Int = 3
  val longSum = 1 + 2L                            //> longSum  : Long = 3
  val s = "Hello, world!"                         //> s  : String = Hello, world!
  println(s indexOf 'o')                          //> 4
  println(s indexOf ('o', 5))                     //> 8
  println(s toLowerCase)                          //> hello, world!
}
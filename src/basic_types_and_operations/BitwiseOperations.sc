package basic_types_and_operations

object BitwiseOperations {
  println("Bitwise Operations")                   //> Bitwise Operations
  val and = (1 & 2)                               //> and  : Int = 0
  val or = (1 | 2)                                //> or  : Int = 3
  val cir = (1 ^ 3)                               //> cir  : Int = 2
  val n = (~1)                                    //> n  : Int = -2
  val s = (-1 >> 31)                              //> s  : Int = -1
  val s1 = (-1 >>>31)                             //> s1  : Int = 1
  val s3 = -1 >>> 1                               //> s3  : Int = 2147483647
  val s2 = (1 << 2)                               //> s2  : Int = 4
  
}
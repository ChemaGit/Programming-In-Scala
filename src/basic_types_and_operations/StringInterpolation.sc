package basic_types_and_operations

object StringInterpolation {
  println("String Interpolation")                 //> String Interpolation
  val name = "reader"                             //> name  : String = reader
  println(s"Hello, $name!")                       //> Hello, reader!
  val answer = s"The answer is ${6 * 7}."         //> answer  : String = The answer is 42.
  println(answer)                                 //> The answer is 42.
  val noScape = raw"No\\\\escape!"                //> noScape  : String = No\\\\escape!
  println(noScape)                                //> No\\\\escape!
  val formatPi = f"${math.Pi}%.5f"                //> formatPi  : String = 3,14159
  println(formatPi)                               //> 3,14159
  val pi = "Pi"                                   //> pi  : String = Pi
  val piApp = f"$pi is approximately ${math.Pi}%.8f"
                                                  //> piApp  : String = Pi is approximately 3,14159265
  println(piApp)                                  //> Pi is approximately 3,14159265
  
}
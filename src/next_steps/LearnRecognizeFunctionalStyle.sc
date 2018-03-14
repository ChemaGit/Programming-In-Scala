package next_steps

object LearnRecognizeFunctionalStyle {
  val args = Array("Ava Addams", "Julia Ann", "Brandi Love", "Kendra Lust", "Timea Bella")
                                                  //> args  : Array[String] = Array(Ava Addams, Julia Ann, Brandi Love, Kendra Lus
                                                  //| t, Timea Bella)
  def printArgs(args: Array[String]): Unit = {
    for(arg <- args)
      println(arg)
  }                                               //> printArgs: (args: Array[String])Unit
  
  def printArgsB(args: Array[String]): Unit = {
    args.foreach(println)
  }                                               //> printArgsB: (args: Array[String])Unit
 
  def formatArgs(args: Array[String]) = args.mkString(",")
                                                  //> formatArgs: (args: Array[String])String
  printArgsB(args)                                //> Ava Addams
                                                  //| Julia Ann
                                                  //| Brandi Love
                                                  //| Kendra Lust
                                                  //| Timea Bella
  
  println(formatArgs(args))                       //> Ava Addams,Julia Ann,Brandi Love,Kendra Lust,Timea Bella
  
  val res = formatArgs(args)                      //> res  : String = Ava Addams,Julia Ann,Brandi Love,Kendra Lust,Timea Bella
  assert(res == "Ava Addams,Julia Ann,Brandi Love,Kendra Lust,Timea Bella")
  
  
}
package next_steps

object LearnRecognizeFunctionalStyle {
  val args = Array("Ava", "Ann", "Brandi", "Lust", "Timea")
  
  def printArgs(args: Array[String]): Unit = {
    for(arg <- args)
      println(arg)
  }
  
  def printArgsB(args: Array[String]): Unit = {
    args.foreach(println)
  }
 
  def formatArgs(args: Array[String]) = args.mkString(",")
  printArgsB(args)
  
  println(formatArgs(args))
  
  val res = formatArgs(args)
  assert(res == "Ava,Ann,Brandi,Lust,Timea")
  
  
}
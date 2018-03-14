package built_in_control_structures

object ForExpressions extends App{
  val filesHere = (new java.io.File(".")).listFiles()
  for(file <- filesHere)
    println(file)
    
  for(i <- 1 to 5)
    println("Iteration " + i)
    
  println("*************")   
    
  for(i <- 1 until 5)
    println("Iteration " + i)
    
  val filesScala = (new java.io.File(".\\src\\built_in_control_structures")).listFiles  
  for(file <- filesScala)
    if(file.getName.endsWith(".scala")) println(file)
    
  println("***************************")  
    
  for(file <- filesScala ++ filesHere
      if file.isFile) println(file)  
      
  println("***************************")     
      
  val list =   for(file <- filesScala ++ filesHere
      if file.isFile
      if file.getName.endsWith(".scala")) yield (file)    
      
  println(list.mkString(", "))
  
  println("***************************")   
  
  def fileLines(file: java.io.File) = 
    scala.io.Source.fromFile(file).getLines().toList
    
  def grep(pattern: String) =
    for {
        file <- filesScala
        if (file.getName.endsWith(".scala"))
          line <- fileLines(file)
          trimmed = line.trim
          if (trimmed.matches(pattern))
    } println(file + ": " + trimmed)
        
  grep(".*gcd.*")
  
  println("***************************")  
  
  def scalaFiles =
    for {
      file <- filesScala
      if file.getName.endsWith(".scala")
    } yield file
    
  println("***************************")  
  
  val forLineLengths =
    for {
      file <- filesScala
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*for.*")
    } yield trimmed.length
    
  println(forLineLengths.mkString(","))  
}
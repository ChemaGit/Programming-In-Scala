package control_abstraction

object FileMatcher {
  private def filesHere = (new java.io.File(".\\src\\built_in_control_structures")).listFiles()
  
  def filesEnding(query: String) =
    for(file <- filesHere;
    if file.getName.endsWith(query)) yield file
    
  def filesContaining(query: String) =
    for(file <- filesHere;
        if file.getName.contains(query)) yield file
        
  def filesRegex(query: String) =
    for(file <- filesHere;
    if file.getName.matches(query)) yield file
}

object FileMatcherBetter {
  private def filesHere = (new java.io.File(".\\src\\built_in_control_structures")).listFiles()
  
  def filesMatching(query: String, matcher: (String, String) => Boolean) = {
    for(file <- filesHere;
    if matcher(file.getName, query)) yield file
  }
  
  def filesEnding(query: String) =
    filesMatching(query, (fileName: String, query: String) => fileName.endsWith(query))
    
  def filesContaining(query: String) =
    filesMatching(query, (fileName, query) => fileName.contains(query))
    
  def filesRegex(query: String) =
    filesMatching(query, _.matches(_))
}

object FileMatcherEvenBetter {
  private def filesHere = (new java.io.File(".\\src\\built_in_control_structures")).listFiles()
  
  def filesMatching(matcher: (String) => Boolean) = {
    for(file <- filesHere;
    if matcher(file.getName)) yield file
  }
  
  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))
    
  def filesContaining(query: String) =
    filesMatching(_.contains(query))
    
  def filesRegex(query: String) =
    filesMatching(_.matches(query))  
}

object ReducingCodeDuplication extends App{
  println(FileMatcher.filesEnding(".scala").mkString("\n"))
  println(FileMatcher.filesContaining("For").mkString("\n"))
  println(FileMatcher.filesRegex("Expressions").mkString("\n"))
  println("********************************")
  println(FileMatcherBetter.filesEnding(".scala").mkString("\n"))
  println(FileMatcherBetter.filesContaining("For").mkString("\n"))
  println(FileMatcherBetter.filesRegex("Expressions").mkString("\n"))
  println("********************************")
  println(FileMatcherEvenBetter.filesEnding(".scala").mkString("\n"))
  println(FileMatcherEvenBetter.filesContaining("For").mkString("\n"))
  println(FileMatcherEvenBetter.filesRegex("Expressions").mkString("\n"))  
}
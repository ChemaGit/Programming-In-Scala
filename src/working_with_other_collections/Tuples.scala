package working_with_other_collections

object Tuples {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  /**
   * a tuple combines a fixed number of
   * items together so that they can be passed around as a whole. Unlike an array
   * or list, a tuple can hold objects with different types.
   * Tuples save you the tedium of defining simplistic data-heavy classes.
   * A common application of tuples is returning multiple values from a method.
   */
   (1, "hello", Console)                          //> res0: (Int, String, Console.type) = (1,hello,scala.Console$@7f690630)
   
   def longestWord(words: Array[String]): (String, Int)= {
    var word = words(0)
    var idx = 0
    for(i <- 1 until words.length)
      if(words(i).length > word.length) {
        word = words(i)
        idx = i
      }
    (word, idx)
   }                                              //> longestWord: (words: Array[String])(String, Int)
   
   val longest = longestWord("The quick brown fox".split(" "))
                                                  //> longest  : (String, Int) = (quick,1)
   longest._1                                     //> res1: String = quick
   longest._2                                     //> res2: Int = 1
   
   val (word, idx) = longest                      //> word  : String = quick
                                                  //| idx  : Int = 1
   //if you leave off the parentheses you get a different result
   val worda, idxa = longest                      //> worda  : (String, Int) = (quick,1)
                                                  //| idxa  : (String, Int) = (quick,1)
                                                  
   /*
   *  Tuples are great
   * when you combine data that has no meaning beyond “an A and a B.” However,
   * whenever the combination has some meaning, or you want to add some
   * methods to the combination, it is better to go ahead and create a class.
   */
   
}
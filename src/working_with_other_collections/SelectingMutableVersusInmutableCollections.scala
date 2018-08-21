package working_with_other_collections

object SelectingMutableVersusInmutableCollections {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  /**
   * Besides being potentially easier to reason about, immutable collections
   * can usually be stored more compactly than mutable ones if the number of elements
   * stored in the collection is small. For instance an empty mutable map
   * in its default representation of HashMap takes up about 80 bytes, and about
   * 16 more are added for each entry that’s added to it. An empty immutable
   * Map is a single object that’s shared between all references, so referring to it
   * essentially costs just a single pointer field.
   *
   * What’s more, the Scala collections library currently stores immutable
   * maps and sets with up to four entries in a single object, which typically
   * takes up between 16 and 40 bytes, depending on the number of entries stored
   * in the collection.4 So for small maps and sets, the immutable versions are
   * much more compact than the mutable ones. Given that many collections are
   * small, switching them to be immutable can bring important space savings
   * and performance advantages.
   * To make it easier to switch from immutable to mutable collections, and
   * viceversa, Scala provides some syntactic sugar. Even though immutable
   * sets and maps do not support a true += method, Scala gives a useful alternate
   * interpretation to +=. Whenever you write a += b, and a does not support a
   * method named +=, Scala will try interpreting it as a = a + b.
   * However, if you declare a variable as a var, instead of a val, then the collection
   * can be "updated" with a += operation, even though it is immutable. First, a
   * new collection will be created, and then people will be reassigned to refer
   * to the new collection:
   * every operator ending in = can be converted.
   */
   var people = Set("Nancy", "Jane")              //> people  : scala.collection.immutable.Set[String] = Set(Nancy, Jane)
   people += "Bob"
   people                                         //> res0: scala.collection.immutable.Set[String] = Set(Nancy, Jane, Bob)
   people -= "Jane"
   people ++= List("Tom", "Harry")
   people                                         //> res1: scala.collection.immutable.Set[String] = Set(Nancy, Bob, Tom, Harry)
                                                  //| 
   
   var roughlyPi = 3.0                            //> roughlyPi  : Double = 3.0
   roughlyPi += 0.1
   roughlyPi += 0.04
   roughlyPi                                      //> res2: Double = 3.14
   
  //If you want to try using mutable collections
  //instead, all that is necessary is to import the mutable version of Map,
  //thus overriding the default import of the immutable collection:
  import scala.collection.mutable.Map // only change needed!
  var capital = Map("US" -> "Washington", "France" -> "Paris")
                                                  //> capital  : scala.collection.mutable.Map[String,String] = Map(France -> Pari
                                                  //| s, US -> Washington)
  capital += ("Japan" -> "Tokyo")                 //> res3: scala.collection.mutable.Map[String,String] = Map(France -> Paris, Ja
                                                  //| pan -> Tokyo, US -> Washington)
  println(capital("France"))                      //> Paris
}
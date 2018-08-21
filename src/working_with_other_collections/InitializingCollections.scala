package working_with_other_collections

object InitializingCollections {
  /**
  * You just place the elements in parentheses
  * after the companion object name, and the Scala compiler will transform that
  * to an invocation of an apply method on that companion object:
  */
  List(1, 2, 3)                                   //> res0: List[Int] = List(1, 2, 3)
  Set('a', 'b', 'c')                              //> res1: scala.collection.immutable.Set[Char] = Set(a, b, c)
  import scala.collection.mutable
  Array(1.0, 2.0, 3.0)                            //> res2: Array[Double] = Array(1.0, 2.0, 3.0)
  
  // If you want it to have an element type of Any, you need to say so explicitly by
  // putting the element type in square brackets, like this:
  val stuff = mutable.Set[Any](42)                //> stuff  : scala.collection.mutable.Set[Any] = Set(42)
  stuff += "abracadabra"                          //> res3: example.InitializingCollections.stuff.type = Set(abracadabra, 42)
  
  // Another special situation is if you want to initialize a collection with another collection.
  import scala.collection.immutable.TreeSet
  val colors = List("blue", "yellow", "red", "green")
                                                  //> colors  : List[String] = List(blue, yellow, red, green)
  //You cannot pass the colors list to the factory method for TreeSet:
  //val treeSet = TreeSet(colors)
  //<console>:16: error: No implicit Ordering defined for List[String].
  
  //Instead, you’ll need to create an empty TreeSet[String] and add to it the
  //elements of the list with the TreeSet's ++ operator:
  val treeSet = TreeSet[String]() ++ colors       //> treeSet  : scala.collection.immutable.TreeSet[String] = TreeSet(blue, green
                                                  //| , red, yellow)
}
package example

object SetsAndMaps {
  /**
  * The Scala collections library offers both mutable and immutable versions of sets and maps.
  * By default when you write "Set" or "Map" you get an immutable object.
  * If you want the mutable variant, you need to do an explicit import.
  * If you want to use both mutable and immutable sets or maps in the same
  * source file, one approach is to import the name of the package that contains the mutable variants:
  * You can continue to refer to the immutable set as Set, as before, but can now
  * refer to the mutable set as mutable.Set.
  */
  import scala.collection.mutable
  val mutaSet = mutable.Set(1, 2, 3)              //> mutaSet  : scala.collection.mutable.Set[Int] = Set(1, 2, 3)
  val mySet = Set(3, 4, 5)                        //> mySet  : scala.collection.immutable.Set[Int] = Set(3, 4, 5)
  //Using sets
  //we’ll use a set to count the number of different words in a string.
  val text = "See Spot run. Run, Spot. Run!"      //> text  : String = See Spot run. Run, Spot. Run!
  val wordsArray = text.split("[ !,.]+")          //> wordsArray  : Array[String] = Array(See, Spot, run, Run, Spot, Run)
  //sets exclude duplicates, each distinct word will appear exactly one time in the set.
  val words = mutable.Set.empty[String]           //> words  : scala.collection.mutable.Set[String] = Set()
  for(word <- wordsArray)
    words += word.toLowerCase
    
  words                                           //> res0: scala.collection.mutable.Set[String] = Set(see, run, spot)
  
  //Common operations for sets
  //Creates an immutable set
  val nums = Set(1, 2, 3)                         //> nums  : scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  //Adds an element
  nums + 5                                        //> res1: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 5)
  //Removes an element
  nums - 3                                        //> res2: scala.collection.immutable.Set[Int] = Set(1, 2)
  //Adds multiple elements
  nums ++ List(5, 6)                              //> res3: scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3)
  //Removes multiple elements
  nums -- List(1, 2)                              //> res4: scala.collection.immutable.Set[Int] = Set(3)
  //Takes the intersection of two sets
  nums & Set(1,3,5,7)                             //> res5: scala.collection.immutable.Set[Int] = Set(1, 3)
  //Returns the size of the set
  nums.size                                       //> res6: Int = 3
  //Checks for inclusion
  nums.contains(3)                                //> res7: Boolean = true
  //Makes the mutable collections easy to access
  import scala.collection.mutable
  //Creates an empty, mutable set
  val mWords = mutable.Set.empty[String]          //> mWords  : scala.collection.mutable.Set[String] = Set()
  //Adds an element
  words += "the"                                  //> res8: example.SetsAndMaps.words.type = Set(see, the, run, spot)
  //removes an element, if it exists
  words -= "the"                                  //> res9: example.SetsAndMaps.words.type = Set(see, run, spot)
  //Adds multiple elements
  words ++= List("do","re","mi")                  //> res10: example.SetsAndMaps.words.type = Set(re, see, do, mi, run, spot)
  //Removes multiple elements
  words --= List("do","re")                       //> res11: example.SetsAndMaps.words.type = Set(see, mi, run, spot)
  //removes all elements
  words.clear
  
  /**
  * Using maps
  */
  //Maps let you associate a value with each element of a set. Using a map looks
  //similar to using an array, except instead of indexing with integers counting
  //from 0, you can use any kind of key.
  //If you import the mutable package
  //name, you can create an empty mutable map like this
  import scala.collection.mutable
  val map = mutable.Map.empty[String, Int]        //> map  : scala.collection.mutable.Map[String,Int] = Map()
  map("hello") = 1
  map("there") = 2
  map                                             //> res12: scala.collection.mutable.Map[String,Int] = Map(hello -> 1, there -> 
                                                  //| 2)
  map("hello")                                    //> res13: Int = 1
  /*
  * counts the number of times each word occurs in a string
  */
  def countWords(text: String) = {
    val counts = mutable.Map.empty[String, Int]
    for(rawWord <- text.split("[ ,!.]+")) {
      val word = rawWord.toLowerCase
      val oldCount = if (counts.contains(word)) counts(word)
                     else 0
      counts += (word -> (oldCount + 1))
    }
    counts
  }                                               //> countWords: (text: String)scala.collection.mutable.Map[String,Int]
  countWords("See Spot run! Run, Spot. Run!")     //> res14: scala.collection.mutable.Map[String,Int] = Map(spot -> 2, see -> 1, 
                                                  //| run -> 3)
  //Common operations for maps
  //Creates an immutable map
  val numsM = Map("i" -> 1, "ii" -> 2)            //> numsM  : scala.collection.immutable.Map[String,Int] = Map(i -> 1, ii -> 2)
                                                  //| 
  //Adds an entry
  numsM + ("vi" -> 6)                             //> res15: scala.collection.immutable.Map[String,Int] = Map(i -> 1, ii -> 2, vi
                                                  //|  -> 6)
  //Removes an entry
  numsM - "ii"                                    //> res16: scala.collection.immutable.Map[String,Int] = Map(i -> 1)
  //Adds multiple entries
  numsM ++ List("iii" -> 3, "v" -> 5)             //> res17: scala.collection.immutable.Map[String,Int] = Map(i -> 1, ii -> 2, ii
                                                  //| i -> 3, v -> 5)
  //Removes multiple entries
  numsM -- List("i", "ii")                        //> res18: scala.collection.immutable.Map[String,Int] = Map()
  //Returns the size of the map
  numsM.size                                      //> res19: Int = 2
  //Checks for inclusion
  numsM.contains("ii")                            //> res20: Boolean = true
  //Retrieves the value at a specified key
  numsM("ii")                                     //> res21: Int = 2
  //Returns the keys
  numsM.keys                                      //> res22: Iterable[String] = Set(i, ii)
  //Returns the keys as a set
  numsM.keySet                                    //> res23: scala.collection.immutable.Set[String] = Set(i, ii)
  //returns the values
  numsM.values                                    //> res24: Iterable[Int] = MapLike.DefaultValuesIterable(1, 2)
  //Indicates whether the map is empty
  numsM.isEmpty                                   //> res25: Boolean = false
  //Makes the mutable collections easy to access
  import scala.collection.mutable
  //Creates an empty, mutable map
  val wordsM = mutable.Map.empty[String, Int]     //> wordsM  : scala.collection.mutable.Map[String,Int] = Map()
  //Adds a map entry from "one" to 1
  wordsM += ("one" -> 1)                          //> res26: example.SetsAndMaps.wordsM.type = Map(one -> 1)
  //Removes a map entry, if it exists
  wordsM -= "one"                                 //> res27: example.SetsAndMaps.wordsM.type = Map()
  //Adds multiple map entries
  wordsM ++= List("one" -> 1, "two" -> 2, "three" -> 3)
                                                  //> res28: example.SetsAndMaps.wordsM.type = Map(one -> 1, three -> 3, two -> 2
                                                  //| )
  //Removes multiple objects
  words --= List("one", "two")                    //> res29: example.SetsAndMaps.words.type = Set()
  
  /*
  * Default sets and maps
  */
}
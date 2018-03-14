package next_steps

object MapsAndSets {
  var jetSet = Set("Boeing", "Airbus")            //> jetSet  : scala.collection.immutable.Set[String] = Set(Boeing, Airbus)
  jetSet += "Lear"
  println(jetSet.contains("Cessna"))              //> false
  println(jetSet)                                 //> Set(Boeing, Airbus, Lear)
  
  import scala.collection.mutable
  val movieSet = mutable.Set("Hitch","Poltergeist")
                                                  //> movieSet  : scala.collection.mutable.Set[String] = Set(Poltergeist, Hitch)
  movieSet += "Shrek"                             //> res0: next_steps.MapsAndSets.movieSet.type = Set(Poltergeist, Shrek, Hitch)
                                                  //| 
  println(movieSet)                               //> Set(Poltergeist, Shrek, Hitch)
  
  import scala.collection.immutable.HashSet
  val hashSet = HashSet("Tomatoes","Chilies")     //> hashSet  : scala.collection.immutable.HashSet[String] = Set(Chilies, Tomatoe
                                                  //| s)
  println(hashSet + "Coriander")                  //> Set(Chilies, Tomatoes, Coriander)
  
  import scala.collection.mutable
  val treasureMap = mutable.Map[Int, String]()    //> treasureMap  : scala.collection.mutable.Map[Int,String] = Map()
  treasureMap += (1 -> "Go to island.")           //> res1: next_steps.MapsAndSets.treasureMap.type = Map(1 -> Go to island.)
  treasureMap += (2 -> "Find big X on ground.")   //> res2: next_steps.MapsAndSets.treasureMap.type = Map(2 -> Find big X on groun
                                                  //| d., 1 -> Go to island.)
  treasureMap += (3 -> "Dig.")                    //> res3: next_steps.MapsAndSets.treasureMap.type = Map(2 -> Find big X on groun
                                                  //| d., 1 -> Go to island., 3 -> Dig.)
  println(treasureMap)                            //> Map(2 -> Find big X on ground., 1 -> Go to island., 3 -> Dig.)
  println(treasureMap(2))                         //> Find big X on ground.
  
  val romanNumeral = Map(1 -> "I",2 -> "II",3 -> "III",4 -> "IV",5 -> "V")
                                                  //> romanNumeral  : scala.collection.immutable.Map[Int,String] = Map(5 -> V, 1 -
                                                  //| > I, 2 -> II, 3 -> III, 4 -> IV)
  println(romanNumeral(4))                        //> IV
  
  
  
  
}
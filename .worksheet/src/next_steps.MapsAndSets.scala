package next_steps

object MapsAndSets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  var jetSet = Set("Boeing", "Airbus");System.out.println("""jetSet  : scala.collection.immutable.Set[String] = """ + $show(jetSet ));$skip(19); 
  jetSet += "Lear";$skip(37); 
  println(jetSet.contains("Cessna"));$skip(18); 
  println(jetSet)
  
  import scala.collection.mutable;$skip(89); 
  val movieSet = mutable.Set("Hitch","Poltergeist");System.out.println("""movieSet  : scala.collection.mutable.Set[String] = """ + $show(movieSet ));$skip(22); val res$0 = 
  movieSet += "Shrek";System.out.println("""res0: next_steps.MapsAndSets.movieSet.type = """ + $show(res$0));$skip(20); 
  println(movieSet)
  
  import scala.collection.immutable.HashSet;$skip(93); 
  val hashSet = HashSet("Tomatoes","Chilies");System.out.println("""hashSet  : scala.collection.immutable.HashSet[String] = """ + $show(hashSet ));$skip(33); 
  println(hashSet + "Coriander")
  
  import scala.collection.mutable;$skip(84); 
  val treasureMap = mutable.Map[Int, String]();System.out.println("""treasureMap  : scala.collection.mutable.Map[Int,String] = """ + $show(treasureMap ));$skip(40); val res$1 = 
  treasureMap += (1 -> "Go to island.");System.out.println("""res1: next_steps.MapsAndSets.treasureMap.type = """ + $show(res$1));$skip(48); val res$2 = 
  treasureMap += (2 -> "Find big X on ground.");System.out.println("""res2: next_steps.MapsAndSets.treasureMap.type = """ + $show(res$2));$skip(31); val res$3 = 
  treasureMap += (3 -> "Dig.");System.out.println("""res3: next_steps.MapsAndSets.treasureMap.type = """ + $show(res$3));$skip(23); 
  println(treasureMap);$skip(26); 
  println(treasureMap(2));$skip(78); 
  
  val romanNumeral = Map(1 -> "I",2 -> "II",3 -> "III",4 -> "IV",5 -> "V");System.out.println("""romanNumeral  : scala.collection.immutable.Map[Int,String] = """ + $show(romanNumeral ));$skip(27); 
  println(romanNumeral(4))}
  
  
  
  
}

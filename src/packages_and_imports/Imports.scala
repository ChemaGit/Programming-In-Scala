package packages_and_imports

abstract class Fruit(val name: String, val color: String)

object Fruits {
  object Apple extends Fruit("apple", "red")
  object Orange extends Fruit("orange", "orange")
  object Pear extends Fruit("pear", "yellowish")
  val menu = List(Apple, Orange, Pear)
}

object Show {
  def showFruit(fruit: Fruit) = {
    /**
     * Imports in Scala can appear anywhere,
     * not just at the beginning of a compilation unit and
     * they can refer to arbitrary values.
     */
    import fruit._
    println(name + "s are " + color)
  }  
}

/**
 * Importing a package name.
 */
import java.util.regex
class AStarB {
  // Accesses java.util.regex.Pattern
  val pat = regex.Pattern.compile("a*b")
}

object Imports extends App{
  //easy access to Fruit
  import packages_and_imports.Fruit
  //easy access to all members of packages_and_imports
  import packages_and_imports._
  //easy access to all members of Fruits
  import packages_and_imports.Fruits._
  //This imports just members Apple and Orange from object Fruits
  import packages_and_imports.Fruits.{Apple, Orange}
  //This imports just members Apple and Orange but the Apple object is renamed to McIntosh
  import packages_and_imports.Fruits.{Apple => McIntosh, Orange}
  //This imports the SQL date class as SDate
  import java.sql.{Date => SDate}
  //This imports the java.sql package as S, so S.Date is valid
  import java.{sql => S}
  //This imports all members from object Fruits. It is the same as packages_and_imports.Fruits._
  import packages_and_imports.Fruits.{_}
  //This imports all members from object Fruits but renames Apple to McIntosh
  import packages_and_imports.Fruits.{Apple => McIntosh, _}
  //This imports all members of Fruits except Pear
  import packages_and_imports.Fruits.{Pear => _, _}
}
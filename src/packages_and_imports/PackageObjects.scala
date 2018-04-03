package packages_and_imports
/**
 * Any definitions placed in a package object 
 * are considered members of the package itself.
 * Given that definition, any other code in any package
 * can import the method just like it would import a class.
 */
package object bobsdelights {
  object Fruits {
    object Apple extends Fruit("apple", "red")
    object Orange extends Fruit("orange", "orange")
    object Pear extends Fruit("pear", "yellowish")
    val menu = List(Apple, Orange, Pear)
  }  
  def showFruit(fruit: Fruit) = {
    import fruit._
    println(name + "s are" + color)
  }
}

package printmenu {
  import packages_and_imports.Fruits
  import bobsdelights.showFruit
  
  object PrintMenu {
    def main(args: Array[String]) = {
      for(fruit <- Fruits.menu) {
        showFruit(fruit)
      }
    }
  }
}

object PackageObjects {
  
}
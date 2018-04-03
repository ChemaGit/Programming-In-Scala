package packages_and_imports

//Long form of a simple package declaration
package next_steps {
  class Navigator
}

/**
 * Concise access to related code
 */
//Multiple packages in the same file.
package bobsrockets {
  package navigation {
    //In package bobsrockets.navigation
    class Navigator1
    package tests {
      //In package bosrockets.navigation.tests
      class NavigatorSuite
    }
  }
}

//Symbols in enclosing packages not automatically available
package bobsrockets {
  class Ship1
  package bobsrockets.fleets {
    class Fleet {
      //Doesn't compile! Ship1 in not in scope
      def addShip() = { new Ship1 }
    }
  }
}

//Concise access to classes and packages
package bobsrockets {
  package navigation {
    class Navigator2 {
      //bobsrockets.navigation.StartMap
      val map = new StartMap
    }
    class StartMap
  }
  class Ship {
    //bobsrockets.navigation.Navigator2
    val nav = new navigation.Navigator2
  }
  package fleets {
    class Fleet {
      //bobsrockets.Ship
      def addShip = {new Ship}
    }    
  }
}

//Accesing hidden package names.
package launch {
  class Booster3
}
package bobsrockets1 {
  package navigation {
    package launch {
      class Booster1
    }
    class MissionControl {
      val booster1 = new launch.Booster1
      val booster2 = new bobsrockets1.launch.Booster2
      val booster3 = new _root_.packages_and_imports.launch.Booster3
    }
  }
  package launch {
    class Booster2
  }
}

//This style of multiple package clauses without braces is called chained package clauses.
/*package bobsrockets
package fleets
class Fleet {
  def addShip() = {new Ship}
}*/

object PuttingCodeInPackages extends App{
  
}
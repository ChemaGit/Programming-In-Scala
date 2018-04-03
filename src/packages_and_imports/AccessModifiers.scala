package packages_and_imports

/**
 * Private members
 */
class Outer {
  class Inner {
    //How private access differs in Scala and Java
    private def f() = { println("f")}
    class InnerMost {
      f() // OK
    }
  }
  //(new Inner).f() //error: f is not accesible
}

/**
 * Protected members
 */
package p {
  class Super {
    protected def f() = { println("f")}
  }
  class Sub extends Super {
    f()
  }
  class Other {
    //(new Super).f() // error: f is not accessible
  }
}

/**
 * Public members
 * Scala has no explicit modifier for public members
 */

/**
 * Scope of protection
 * no access modifier              public access
 * private[packages_and_imports]   access within outer package
 * private[navigation]             same as package visibility in Java
 * private[Navigator]              same as private in Java
 * private[LegOfJourney]           same as private in Scala
 * private[this]                   access only from same object
 */
//Flexible scope of protection with access qualifiers
package navigation {
  private[packages_and_imports] class Navigator {
    protected[navigation] def useStarChart() = {}
    class LegOfJourney {
      private[Navigator] val distance = 100    
    }
    private[this] var speed = 200
    val other = new Navigator
    //other.speed //This line would not compile      
  }
}

package launch {
  import navigation._
  object Vehicle {
    private[launch] val guide = new Navigator
  }
}

/**
 * Visibility and companion objects.
 * Accessing private members of companion classes and objects.
 */
class Rocket {
  import Rocket.fuel
  private def canGoHomeAgain = fuel > 20
}

object Rocket {
  private def fuel = 10
  def chooseStragegy(rocket: Rocket) = {
    if(rocket.canGoHomeAgain)
      goHome()
    else pickAStart()  
  }
  def goHome() = {}
  def pickAStart() = {}
}

object AccessModifiers extends App{

}
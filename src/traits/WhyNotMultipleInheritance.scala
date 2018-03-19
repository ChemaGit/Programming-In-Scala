package traits

import traits.TraitsAsStackableModifications._

class Animals
trait Furry extends Animals
trait HasLeggs extends Animals
trait FourLegged extends HasLeggs
class Cat extends Animals with Furry with FourLegged

/**
 * Linearization of types in Cat's hierarchy
 * Animals --> AnyRef --> Any
 * Furry --> Animals --> AnyRef --> Any
 * FourLegged --> HasLeggs --> Animals --> AnyRef --> Any
 * HasLeggs --> Animals --> AnyRef --> Any
 * Cat --> FourLegged --> HasLeggs --> Furry --> Animals --> AnyRef --> Any
 */

object WhyNotMultipleInheritance extends App{
  //Multiple inheritance, 
  val q = new BasicIntQueue with Incrementing with Doubling
  q.put(-1)
  q.put(0)
  q.put(1)
  q.put(2)
  println("q: " + q.get())
  println("q: " + q.get())
  println("q: " + q.get())
  println("q: " + q.get())
}
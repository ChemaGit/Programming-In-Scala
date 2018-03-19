package traits

trait Philosophical {
  def philosophize() = {
    println("I consume memory, therefore I am!")
  }  
}
/**
 * Shows a class that mixes in the Philosophical trait using extends.
 */
class Frog extends Philosophical {
  override def toString = "green"
}

class Animal
trait HasLegs
/**
 * a class that extends a superclass, and with to mix in multiple traits
 */
class OtherFrog extends Animal with Philosophical with HasLegs {
  override def toString = "green light"
  //you can override philosophize
  override def philosophize() = {
    println("It ain't easy being " + toString + "!")
  }
  
}

object HowTraitsWork extends App{
  val frog = new Frog
  println(frog)
  println(frog.philosophize())
  //a trait also defines a type
  val phil: Philosophical = frog
  println(phil)
  println(phil.philosophize())
  
  val philo = new OtherFrog
  println(philo)
  println(philo.philosophize())
  
}
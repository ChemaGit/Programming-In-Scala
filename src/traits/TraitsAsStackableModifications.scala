package traits

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) = {buf += x}
}

/**
 * The Doubling stackable modification trait.
 * This declaration means that the trait can only
 * be mixed into a class that also extends IntQueue
 */
trait Doubling extends IntQueue {
  /**
   * abstract override .....
   * it means that the trait must be mixed into some class that has a concrete
   * definition of the method.
   */
  abstract override def put(x: Int) = {super.put(2 * x)}
}

/**
 * Stackable modifications traits Incrementing and Filtering
 */
trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = {super.put(x + 1)}
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if(x >= 0) super.put(x)
  }
}

/**
 * Here's how it looks to use the trait
 */
class MyQueue extends BasicIntQueue with Doubling

object TraitsAsStackableModifications extends App{
  val queue = new BasicIntQueue
  queue.put(10)
  queue.put(20)
  println("Basic queue: " + queue.get())
  println()
  val myQueue = new MyQueue
  myQueue.put(10)
  myQueue.put(15)
  myQueue.put(20)
  println("Doubling queue: " + myQueue.get())
  println()
  //Mixing in a trait when instantiating with new.
  val queueDouble = new BasicIntQueue with Doubling
  queueDouble.put(40)
  queueDouble.put(50)
  println("Doubling queue: " + queueDouble.get())
  println()
  //In this example Filtering's put is invoked first
  val queueStack = new BasicIntQueue with Incrementing with Filtering
  queueStack.put(-1)
  queueStack.put(0)
  queueStack.put(1)
  println("queueStack: " + queueStack.get())
  println("queueStack: " + queueStack.get())
  println()
  /**
   * The order of mixing is significant
   * the method in the trait furthest to the right is called first 
   * In this example Incrementing's put is invoked first
   */
  val queueStackB = new BasicIntQueue with Filtering with Incrementing
  queueStackB.put(-1)
  queueStackB.put(0)
  queueStackB.put(1)
  println("queueStackB: " + queueStackB.get())
  println("queueStackB: " + queueStackB.get())
  println("queueStackB: " + queueStackB.get())
}
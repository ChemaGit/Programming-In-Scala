package type_parameterization

/**
 * A functional queue is a data structure with three operations:
 * head returns the first element of the queue
 * tail returns a queue without its first element
 * enqueue returns a new queue with a given element
 * appended at the end.
 * 
 * Unlike a mutable queue, a functional queue does not change its contents
 * when an element is appended. Instead, a new queue is returned that contains
 * the element. Purely functional queues also have some similarity with lists. Both are
 * so called fully persistent data structures, where old versions remain available
 * even after extensions or modifications.
 */

object FunctionalQueues extends App{
  /**
   * One simple approach to implement a functional queue would be to use a
   * list as representation type. Then head and tail would just translate into the
   * same operations on the list, whereas enqueue would be concatenation.
   * The problem is that it takes time proportional to the number of elements stored in the queue.
   */
  class SlowAppendQueue[T](elems: List[T]) { // Not efficient
    def head = elems.head
    def tail = new SlowAppendQueue(elems.tail)
    def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))    
  }
  
  /**
   * If you want time constant append, you could try to reverse the order of the elements.
   * Now enqueue is constant time, but head and tail are not.
   */
  class SlowHeadQueue[T](smele: List[T]) { // Not efficient
    // smele is elems reversed
    def head = smele.last
    def tail = new SlowHeadQueue(smele.init)
    def enqueue(x: T) = new SlowHeadQueue(x :: smele)
  }
  
  /**
   * A basic functional queue.
   * Because head and tail call mirror, their complexity might be linear in the size of the queue.
   * Now, to append an element, you just cons it to the trailing list using the :: operator, so enqueue is constant time.
   */
  class Queue[T](private val leading: List[T], private val trailing: List[T]) {
    private def mirror =
      if(leading.isEmpty)
        new Queue(trailing.reverse, Nil)
      else
        this
        
    def head = mirror.leading.head
    
    def tail = {
        val q = mirror
        new Queue(q.leading.tail, q.trailing)
    }
    
    def enqueue(x: T) =
      new Queue(leading, x :: trailing)
  }
}
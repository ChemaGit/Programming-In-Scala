package type_parameterization

object LowerBounds extends App{
  
  /**
   * you can generalize enqueue
   * by making it polymorphic (i.e., giving the enqueue method itself a type parameter)
   * and using a lower bound for its type parameter.
   * A new formulation of Queue that implements this idea.
   * A type parameter with a lower bound
   */
  
  /**
   * The new definition gives enqueue a type parameter U, and with the syntax,
   * "U >: T", defines T as the lower bound for U. As a result, U is required to be a
   * supertype of T.1 The parameter to enqueue is now of type U instead of type
   * T, and the return value of the method is now Queue[U] instead of Queue[T].
   * 
   * For example, suppose there is a class Fruit with two subclasses, Apple
   * and Orange. With the new definition of class Queue, it is possible to append
   * an Orange to a Queue[Apple]. The result will be a Queue[Fruit].
   * 
   * This shows that variance annotations and lower bounds play well together.
   * They are a good example of type-driven design, where the types of
   * an interface guide its detailed design and implementation.
   * Correcting the variance error by adding a lower bound
   * makes enqueue more general and queues as a whole more usable.
   */
  class Queue[+T](private val leading: List[T], private val trailing: List[T]) {
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
    
    def enqueue[U >: T](x: U) =
      new Queue[U](leading, x :: trailing)
  }
}  
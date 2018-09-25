package type_parameterization

/**
 * The implementation of Queue is quite good with regards to efficiency, though
 * this efficiency is paid for by exposing a needlessly detailed implementation.
 * The Queue constructor, which is globally accessible, takes two lists as parameters, where one is reversed.
 * What’s needed is a way to hide this constructor from client code.
 */
object InformationHiding extends App{
  /**
   * Private constructors and factory methods.
   * 
   * In Scala, the primary constructor does not have an explicit definition; it is defined implicitly
   * by the class parameters and body. Nevertheless, it is still possible to hide
   * the primary constructor by adding a private modifier in front of the class parameter list
   */
  class Queue[T] private(private val leading: List[T], private val trailing: List[T]) {
//  The private modifier between the class name and its parameters indicates
//  that the constructor of Queue is private: it can be accessed only from
//  within the class itself and its companion object. The class name Queue is
//  still public, so you can use it as a type, but you cannot call its constructor:
//  new Queue(List(1, 2), List(3)) ==> error: constructor Queue in class Queue cannot be accessed
    
    def this(elems: T*) = this(elems.toList, Nil) //auxiliary constructor to create new queues.
  }
  
  /**
   * Another possibility is to add a factory method that builds a queue from
   * such a sequence of initial elements. A neat way to do this is to define an
   * object Queue that has the same name as the class being defined and contains an apply method.
   * By placing this object in the same source file as class Queue, you make
   * the object a companion object of the class.
   * A companion object has the same access rights as its class. Because of this, the
   * apply method in object Queue can create a new Queue object, even though
   * the constructor of class Queue is private.
   * 
   * because the factory method is called apply, clients can create
   * queues with an expression such as Queue(1, 2, 3). This expression expands
   * to Queue.apply(1, 2, 3) since Queue is an object instead of a function.
   * As a result, Queue looks to clients as if it was a globally defined factory 
   * method. In reality, Scala has no globally visible methods; every method
   * must be contained in an object or a class. However, using methods named
   * apply inside global objects, you can support usage patterns that look like
   * invocations of global methods.
   */
  object Queue {
    // constructs a queue with initial elements 'xs'
    def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
  }
}
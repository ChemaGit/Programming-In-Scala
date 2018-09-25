package type_parameterization

object InformationHiding2 extends App{
  
  /**
   * An alternative private classes
   * 
   * Another more radical way is to hide the class itself and only export a trait that reveals the public interface of the class.
   * This exposes to clients the same information as before, but using a different technique. Instead of hiding individual constructors and
   * methods, this version hides the whole implementation class.
   */
  //Type abstraction for functional queues.
  trait Queue[T] {
    def head: T
    def tail: Queue[T]
    def enqueue(x: T): Queue[T]
  }  
  
  object Queue {
    def apply[T](xs: T*): Queue[T] =
      new QueueImpl[T](xs.toList, Nil)
      
    private class QueueImpl[T](private val leading: List[T], private val trailing: List[T])extends Queue[T] {
      def mirror =
        if(leading.isEmpty) new QueueImpl(trailing.reverse, Nil)
        else this
        
      def head: T = mirror.leading.head
      
      def tail: QueueImpl[T] = {
        val q = mirror
        new QueueImpl(q.leading.tail, q.trailing)
      }
      
      def enqueue(x: T) = new QueueImpl(leading, x :: trailing)
    }
    
  }
}
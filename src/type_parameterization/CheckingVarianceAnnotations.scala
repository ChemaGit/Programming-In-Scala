package type_parameterization

object CheckingVarianceAnnotations extends App{
  trait Queue[+T] {
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
  /**
   * So far, all violations of type soundness involved some reassignable
   * field or array element. The purely functional implementation of
   * queues, on the other hand, looks like a good candidate for covariance.
   */
  class StrangeIntQueue extends Queue[Int] {
    override def enqueue(x: Int) = {
      println(math.sqrt(x))
      super.enqueue(x)
    }
  }
  /**
   * The first of these two lines is valid because StrangeIntQueue is a subclass
   * of Queue[Int] and, assuming covariance of queues, Queue[Int] is a subtype
   * of Queue[Any]. The second line is valid because you can append a
   * String to a Queue[Any]. However, taken together, these two lines have the
   * effect of applying a square root method to a string, which makes no sense.
   * Running a modified queue class like the one above through a Scala compiler would yield:
   * Queues.scala:11: error: covariant type T occurs in contravariant position in type T of value x def enqueue(x: T) =
   */
  val x: Queue[Any] = new StrangeIntQueue
  x.enqueue("abc")
}
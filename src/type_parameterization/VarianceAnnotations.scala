package type_parameterization

object VarianceAnnotations extends App{
  
  /**
   * def doesCompile(q: Queue[AnyRef]) = {}
   * Covariant
   * Covariant Queues would mean, for example, that you could pass a Queue[String] to
   * the doesCompile method shown previously, which takes a value parameter of type Queue[AnyRef].
   * In Scala, however, generic types have by default nonvariant (or "rigid") subtyping. That is, with Queue defined as in
   * InformationHiding, queues with different element types would never be in a subtype relationship.
   * However, you can demand covariant (flexible) subtyping of queues by changing
   * the first line of the definition of class Queue like this: trait Queue[+T] { ... }
   * 
   * Prefixing a formal type parameter with a + indicates that subtyping is covariant
   * (flexible) in that parameter. By adding this single character, you are
   * telling Scala that you want Queue[String], for example, to be considered a subtype of Queue[AnyRef].
   * 
   * Besides +, there is also a prefix -, which indicates contravariant subtyping.
	 * If Queue were defined like this: trait Queue[-T] { ... }
	 * 
	 * Whether a type parameter is covariant, contravariant, or nonvariant is called
   * the parameter’s variance . The + and symbols you can place next to type
   * parameters are called variance annotations.
   */
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
   * A nonvariant(rigid) Cell class
   */
  class Cell[T](init: T) {
    private[this] var current = init
    def get = current
    def set(x: T) = { current = x}
  }
  
  /**
   * Variance and arrays
   * arrays are treated as covariant in Java. this design, seems both unsafe and expensive.
   * Scala tries to be purer than Java in not treating arrays as covariant.
   * 
   * Scala treats arrays as nonvariant (rigid), so an
   * Array[String] is not considered to conform to an Array[Any]. However,
   * sometimes it is necessary to interact with legacy methods in Java that use an
   * Object array as a means to emulate a generic array.
   * Scala lets you cast an array of Ts to an array of any supertype of T:  
   */
  val a1 = Array("abc")
  val a2: Array[Object] = a1.asInstanceOf[Array[Object]] //a2: Array[Object] = Array(abc)  
}  

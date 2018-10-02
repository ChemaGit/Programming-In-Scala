package type_parameterization


/**
 * What’s different with respect to the previous version is that now leading
 * and trailing are reassignable variables, and mirror performs the reverse
 * copy from trailing to leading as a side effect on the current queue instead
 * of returning a new queue. This side effect is purely internal to the implementation
 * of the Queue operation; since leading and trailing are private
 * variables, the effect is not visible to clients of Queue.
 * The new version of Queue still defines purely functional
 * objects, in spite of the fact that they now contain reassignable fields.
 */
object ObjectPrivateData extends App{
  
  /**
   * An optimized functional queue
   * 
   * You might wonder whether this code passes the Scala type checker. After
   * all, queues now contain two reassignable fields of the covariant parameter
   * type T. Is this not a violation of the variance rules? It would be indeed,
   * except for the detail that leading and trailing have a private[this]
   * modifier, and are thus declared to be object private.
   * 
   * Scala’s variance checking rules contain a special case for object private
   * definitions. Such definitions are omitted when it is checked that a type parameter
   * with either a + or annotation
   * occurs only in positions that have the
   * same variance classification. Therefore, the code compiles
   * without error. On the other hand, if you had left out the [this] qualifiers
   * from the two private modifiers, you would see two type errors:
   * Queues.scala:1: error: covariant type T occurs in
   * contravariant position in type List[T] of parameter of
   * setter leading_=
   * class Queue[+T] private (private var leading: List[T],
   * ˆ
   * Queues.scala:1: error: covariant type T occurs in
   * contravariant position in type List[T] of parameter of
   * setter trailing_=
   * private var trailing: List[T]) {
   * ˆ
   */
  class Queue[+T] private(private[this] var leading: List[T], private[this] var trailing: List[T]) {
    private def mirror() =
      if(leading.isEmpty) {
        while(!trailing.isEmpty){
          leading = trailing.head :: leading
          trailing = trailing.tail
        }
      }
    def head: T = {
      mirror()
      leading.head
    }
    def tail: Queue[T] = {
      mirror()
      new Queue(leading.tail,trailing)
    }
    
    def enqueue[U >: T](x: U) =
      new Queue[U](leading, x :: trailing)
  }  
}
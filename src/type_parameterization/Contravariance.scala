package type_parameterization

object Contravariance extends App{
  
  /**
   * A contravariant output channel.
   * OutputChannel is defined to be contravariant in T.
   * It is safe to assume that a type T is a subtype of a type U if you can substitute
   * a value of type T wherever a value of type U is required. This is called the
   * Liskov Substitution Principle. The principle holds if T supports the same
   * operations as U, and all of T’s operations require less and provide more
   * than the corresponding operations in U. In the case of output channels, an
   * OutputChannel[AnyRef] can be a subtype of an OutputChannel[String]
   * because the two support the same write operation, and this operation requires
   * less in OutputChannel[AnyRef] than in OutputChannel[String].
   * "Less" means the argument is only required to be an AnyRef in the first case,
   * whereas it is required to be a String in the second case.
   */
  trait OutputChannel[-T] {
    def write(x: T)
  }
  
  /**
   * Covariance and contravariance of Function1.
   * Sometimes covariance and contravariance are mixed in the same type.
   * A prominent example is Scala’s function traits. For instance, whenever you
   * write the function type A => B, Scala expands this to Function1[A, B]. The
   * definition of Function1 in the standard library uses both covariance and
   * contravariance: the Function1 trait is contravariant in the function argument
   * type S and covariant in the result type T.
   * This satisfies the Liskov Substitution Principle because arguments are something
   * that’s required, whereas results are something that’s provided.
   */
  trait Function1[-S, +T] {
    def apply(x: S): T
  }
  
  
  /**
   * Demonstration of function type parameter variance.
   * This code passes the compiler because function result types are declared
   * to be covariant (the +T in Function1[-S, +T].
   * The printBookList method iterates through its book list and invokes
   * the passed function on each book. It passes the AnyRef result returned by
   * info to println, which invokes toString on it and prints the result. This
   * activity will work with String as well as any other subclass of AnyRef,
   * which is what covariance of function result types means.
   * 
   * Covariance and contravariance in function type parameters.
   * argument type                     Publication => String --> Book => AnyRef
   * Book --> Publication
   * 
   * result type
   * String --> AnyRef
   * 
   * The code compiles because Publication => String is
   * a subtype of Book => AnyRef, as shown in the center of the diagram. Because
   * the result type of a Function1 is defined as covariant, the inheritance
   * relationship of the two result types, shown at the right of the diagram, is in
   * the same direction as that of the two functions shown in the center. By contrast,
   * because the parameter type of a Function1 is defined as contravariant,
   * the inheritance relationship of the two parameter types, shown at the left of
   * the diagram, is in the opposite direction as that of the two functions.
   */
  class Publication(val title: String)
  class Book(title: String)extends Publication(title)
  
  object Library {
    val books: Set[Book] = Set(new Book("Programming in Scala"), new Book("Walden"))
    def printBookList(info: Book => AnyRef) = {
      for(book <- books) println(info(book))
    }
  }
  
  object Customer extends App {
    def getTitle(p: Publication): String = p.title
    Library.printBookList(getTitle)
  }
}
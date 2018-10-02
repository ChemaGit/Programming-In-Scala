package type_parameterization

object UpperBounds extends App{
  /**
   * A Person class that mixes in the Ordered trait.
   */
  class Person(val firstName: String, val lastName: String)extends Ordered[Person] {
    def compare(that: Person) = {
      val lastNameComparison = lastName.compareToIgnoreCase(that.lastName)
      if(lastNameComparison != 0)
        lastNameComparison
      else
        firstName.compareToIgnoreCase(that.firstName)
    }
    
    override def toString = firstName + " " + lastName
  }
  
  val robert = new Person("Robert", "Jones")
  val sally = new Person("Sally","Smith")
  println(robert < sally)
  
  /**
   * A merge sort function with an upper bound.
   * 
   * To require that the type of the list passed to your new sort function mixes
   * in Ordered, you need to use an upper bound. An upper bound is specified
   * similar to a lower bound, except instead of the >: symbol used for lower
   * bounds, you use a <: symbol.
   * 
   * With the "T <: Ordered[T]" syntax, you indicate that the type parameter,
   * T, has an upper bound, Ordered[T]. This means that the element type of
   * the list passed to orderedMergeSort must be a subtype of Ordered. Thus,
   * you could pass a List[Person] to orderedMergeSort because Person
   * mixes in Ordered.
   */
  def orderedMergeSort[T <: Ordered[T]](xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] = 
      (xs, ys) match {
        case(Nil, _) => ys
        case(_, Nil) => xs
        case(x :: xs1, y :: ys1) =>
          if(x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    
    val n = xs.length / 2
    if(n == 0) xs
    else {
      val (ys, zs) = xs.splitAt(n)
      merge(orderedMergeSort(ys), orderedMergeSort(zs))
    }
  }
  
}
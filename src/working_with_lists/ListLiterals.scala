package working_with_lists

/**
 * Lists are quite similar to arrays, but there are two important differences.
 * First, lists are immutable. That is, elements of a list cannot be changed
 * by assignment. Second, lists have a recursive structure 
 * whereas arrays are flat.
 */
object ListLiterals extends App {
  /**
   * List examples   
   */
  val fruit = List("apples", "oranges", "pears")
  val nums = List(1, 2, 3, 4)
  val diag3 = List(List(1, 0, 0),List(0, 1, 0),List(0, 0, 1))
  val empty = List()    
}
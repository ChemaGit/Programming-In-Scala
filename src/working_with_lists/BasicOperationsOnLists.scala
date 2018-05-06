package working_with_lists

/**
 * All operations on lists can be expressed in terms of the following three:
 *	head returns the first element of a list
 *	tail returns a list consisting of all elements except the first
 * 	isEmpty returns true if the list is empty
 */

object BasicOperationsOnLists extends App{
  val fruit: List[String] = List("apples", "oranges", "pears")
  val nums: List[Int] = List(1, 2, 3, 4)
  val diag3: List[List[Int]] = List(List(1, 0, 0),List(0, 1, 0),List(0, 0, 1))
  val empty: List[Nothing] = List() 
  
  empty.isEmpty //returns true
  fruit.isEmpty //returns false
  fruit.head //returns "apples"
  fruit.tail.head //returns "oranges"
  diag3.head //returns List(1, 0, 0)  
  
  /**
   * sorting the elements of a list of numbers into ascending order.
   * the insertion sort algorithm looks like
   */
  def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)  
  
}
package working_with_lists

object MethodsOfTheListObject {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  /**
  * Creating lists from their elements: List.apply
  */
  List(1, 2, 3)                                   //> res0: List[Int] = List(1, 2, 3)
  List.apply(1, 2, 3)                             //> res1: List[Int] = List(1, 2, 3)
  
  /**
  * Creating a range of numbers: List.range
  */
  List.range(1, 5)                                //> res2: List[Int] = List(1, 2, 3, 4)
  List.range(1, 9, 2)                             //> res3: List[Int] = List(1, 3, 5, 7)
  List.range(9, 1, -2)                            //> res4: List[Int] = List(9, 7, 5, 3)
  
  /**
  * Creating uniform lists: List.fill
  * The fill method creates a list consisting of zero or more copies of the same
  * element. It takes two parameters: the length of the list to be created, and the
  * element to be repeated.
  */
  List.fill(5)('a')                               //> res5: List[Char] = List(a, a, a, a, a)
  List.fill(3)("hello")                           //> res6: List[String] = List(hello, hello, hello)
  // If fill is given more than two arguments, then it will make multidimensional lists.
  List.fill(2, 3)('b')                            //> res7: List[List[Char]] = List(List(b, b, b), List(b, b, b))
  
  /**
  * Tabulating a function: List.tabulate
  */
  val squares = List.tabulate(5)(n => n * n)      //> squares  : List[Int] = List(0, 1, 4, 9, 16)
  val multiplication = List.tabulate(5,5)(_ * _)  //> multiplication  : List[List[Int]] = List(List(0, 0, 0, 0, 0), List(0, 1, 2, 
                                                  //| 3, 4), List(0, 2, 4, 6, 8), List(0, 3, 6, 9, 12), List(0, 4, 8, 12, 16))
  val sum = List.tabulate(10)(n => n + n)         //> sum  : List[Int] = List(0, 2, 4, 6, 8, 10, 12, 14, 16, 18)
  
  /**
  * Concatenating multiple lists: List.concat
  */
  List.concat(List('a', 'b'), List('c'))          //> res8: List[Char] = List(a, b, c)
  List.concat(List(), List('b'), List('c'))       //> res9: List[Char] = List(b, c)
  List.concat()                                   //> res10: List[Nothing] = List()
  
  /**
  * Processing multiple lists together
  */
  (List(10, 20), List(3, 4, 5)).zipped.map(_ * _) //> res11: List[Int] = List(30, 80)
  (List("abc", "de"), List(3, 2)).zipped.forall(_.length == _)
                                                  //> res12: Boolean = true
  (List("abc", "de"), List(3, 2)).zipped.exists(_.length != _)
                                                  //> res13: Boolean = false
}
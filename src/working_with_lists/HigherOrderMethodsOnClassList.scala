package working_with_lists

object HigherOrderMethodsOnClassList extends App{
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  /**
  * Mapping over lists: map, flatMap, and foreach.
  */
  //map: returns the list that results from applying the function (f)
  //to each list element in xs
  List(1, 2, 3).map(_ + 1)                        //> res0: List[Int] = List(2, 3, 4)
  val words = List("the", "quick", "brown", "fox")//> words  : List[String] = List(the, quick, brown, fox)
  words.map(_.length)                             //> res1: List[Int] = List(3, 5, 5, 3)
  words.map(_.toList.reverse.mkString)            //> res2: List[String] = List(eht, kciuq, nworb, xof)
  
  //flatMap: similar to map, but it takes a function returning a list
  //of elements as its right operand. It applies the function to each list
  //element and returns the concatenation of all function results.
  words.map(_.toList)                             //> res3: List[List[Char]] = List(List(t, h, e), List(q, u, i, c, k), List(b, r,
                                                  //|  o, w, n), List(f, o, x))
  words.flatMap(_.toList)                         //> res4: List[Char] = List(t, h, e, q, u, i, c, k, b, r, o, w, n, f, o, x)
  List.range(1, 5).flatMap(i => List.range(1, i).map(j => (i, j)))
                                                  //> res5: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))
  
  for(i <- List.range(1, 5);
      j <- List.range(1, i)) yield(i, j)          //> res6: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))
      
  //foreach: takes a procedure (a function with result type Unit) as right operand.
  //applies the procedure to each list element. The result is again Unit.
  var sum = 0                                     //> sum  : Int = 0
  List(1, 2, 3, 4, 5, 6, 7).foreach(sum += _)
  sum                                             //> res7: Int = 28
  
  /**
  * Filtering lists: filter, partition, find, takeWhile, dropWhile, and span.
  */
  
  //filter: takes a list and a predicate function (p) of type T => Boolean.
  //It yields the list of all elements x in xs for which p(x) is true.
  List(1, 2, 3, 4, 5, 6, 7).filter(x => x % 2 == 0)
                                                  //> res8: List[Int] = List(2, 4, 6)
  words.filter(x => x.length == 3)                //> res9: List[String] = List(the, fox)
  
  //partition:  like filter but returns a pair of lists. One list contains
  // all elements for which the predicate is true, while the other contains all elements
  // for which the predicate is false => xs.partition(p) equals (xs.filter(p), xs.filter(!p))
  List(1, 2, 3, 4, 5, 6, 7).partition(x => x % 2 == 0)
                                                  //> res10: (List[Int], List[Int]) = (List(2, 4, 6),List(1, 3, 5, 7))
  //find: similar to filter, but it returns the first element
  //satisfying a given predicate. Returns an optional values.
  List(1, 2, 3, 4, 5, 6, 7).find(x => x % 2 == 0) //> res11: Option[Int] = Some(2)
  List(1, 2, 3, 4, 5, 6, 7).find(x => x < 0)      //> res12: Option[Int] = None
  
  //takeWhile: the operation xs.takeWhile(p) takes the longest prefix of list xs
  //such that every element in the prefix satisfies (p)
  List(1, 2, 3, 4, 5, -6, 7).takeWhile(x => x > 0)//> res13: List[Int] = List(1, 2, 3, 4, 5)
  
  //dropWhile: xs.dropWhile(p) removes the longest prefix from list xs
  //such that every element in the prefix satisfies (p)
  words.dropWhile(s => s.startsWith("t"))         //> res14: List[String] = List(quick, brown, fox)
  
  //span: The span method combines takeWhile and dropWhile.
  //returns a pair of two lists, defined by the equality => xs.span(p) equals (xs.takeWhile(p), xs.dropWhile(p))
  List(1, 2, 3, 4, 5, -6, 7).span(x => x > 0)     //> res15: (List[Int], List[Int]) = (List(1, 2, 3, 4, 5),List(-6, 7))
  
  /**
  * Predicates over lists: forall and exists
  */
  //forall: xs.forall(p) Its result is true if all elements in the list satisfy p.
  //exists: xs.exists(p) returns true if there is an element in xs that satisfies (p)
  def hasZeroRow(m: List[List[Int]]) = m.exists(row => row.forall(x => x == 0))
                                                  //> hasZeroRow: (m: List[List[Int]])Boolean
  val diag3 = List(List(1, 0, 0), List(1, 1, 1), List(0, 0, 1))
                                                  //> diag3  : List[List[Int]] = List(List(1, 0, 0), List(1, 1, 1), List(0, 0, 1)
                                                  //| )
  hasZeroRow(diag3)                               //> res16: Boolean = false
  val diag4 = List(List(1, 0, 0), List(1, 1, 1), List(0, 0, 0))
                                                  //> diag4  : List[List[Int]] = List(List(1, 0, 0), List(1, 1, 1), List(0, 0, 0)
                                                  //| )
  hasZeroRow(diag4)                               //> res17: Boolean = true
  
  /**
  * Folding lists: /: and :\
  * Another common kind of operation combines the elements of a list with some operator.
  */
  val list = List(1, 2, 3, 4, 5)                  //> list  : List[Int] = List(1, 2, 3, 4, 5)
  list.fold(0)(_ + _)                             //> res18: Int = 15
  list.fold(1)(_ * _)                             //> res19: Int = 120
  
  /**
  * A fold left operation (z /: xs) (op) involves three objects: a start value
  * z, a list xs, and a binary operation op. The result of the fold is op applied
  * between successive elements of the list prefixed by z. For instance:
  * (z /: List(a, b, c)) (op) equals op(op(op(z, a), b), c)
  */
  words.foldLeft("")(_ + " " + _)                 //> res20: String = " the quick brown fox"
  words.tail.foldLeft(words.head)(_ + " " + _)    //> res21: String = the quick brown fox
  
  /**
  * The :\ operator is pronounced fold right. It involves the same three
  * operands as fold left, but the first two appear in reversed order: The first
  * operand is the list to fold, the second is the start value.
  */
  words.foldRight("")(_ + " " + _)                //> res22: String = "the quick brown fox "
  words.tail.foldRight(words.head)(_ + " " + _)   //> res23: String = quick brown fox the
  
  //List reversal using fold
  def reverseLeft[T](xs: List[T]) = {
    xs.foldLeft(List[T]()){case(ys, y) => y :: ys}
  }                                               //> reverseLeft: [T](xs: List[T])List[T]
  reverseLeft(List(1, 2, 3, 4, 5, 6, 7))          //> res24: List[Int] = List(7, 6, 5, 4, 3, 2, 1)
  
  /**
  * Sorting lists: sortWith
  * The operation xs sortWith before, where “xs” is a list and “before” is a
  * function that can be used to compare two elements, sorts the elements of list xs.
  */
  List(1, -3, 4, 2, 6).sortWith(_ < _)            //> res25: List[Int] = List(-3, 1, 2, 4, 6)
  List(1, -3, 4, 2, 6).sortWith(_ > _)            //> res26: List[Int] = List(6, 4, 2, 1, -3)
  words.sortWith(_.length > _.length)             //> res27: List[String] = List(quick, brown, the, fox)
}
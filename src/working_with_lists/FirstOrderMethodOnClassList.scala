package example

object FirstOrderMethodOnClassList {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  /**
  * Concatenating two lists
  */
  List(1, 2) ::: List(3, 4, 5)                    //> res0: List[Int] = List(1, 2, 3, 4, 5)
  List() ::: List(1, 2, 3)                        //> res1: List[Int] = List(1, 2, 3)
  List(1, 2, 3) ::: List(4)                       //> res2: List[Int] = List(1, 2, 3, 4)
  
  /**
  * The divide and conquer principle.
  * Concatenation (:::) is implemented as a method in class List. It would also
  * be possible to implement concatenation “by hand,” using pattern matching
  * on lists.
  */
	def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
	 case List() => ys
	 case x :: xs1 => x :: append(xs1, ys)
	}                                         //> append: [T](xs: List[T], ys: List[T])List[T]
	
	/**
	* Taking the length of a list: length
	*/
	List(1, 2, 3).length                      //> res3: Int = 3
	
	/**
	* Accessing the end of a list: init and last.
	* It’s a good idea to organize your data so that most accesses
  * are at the head of a list, rather than the last element.
	*/
	val abcde = List('a', 'b', 'c', 'd', 'e') //> abcde  : List[Char] = List(a, b, c, d, e)
	abcde.last                                //> res4: Char = e
	abcde.init                                //> res5: List[Char] = List(a, b, c, d)
	/**
	List().last                               java.util.NoSuchElementException
	List().init                               java.lang.UnsupportedOperationException: empty.init
  **/
                                                  
	/**
	* Reversing lists: reverse
	*/
	abcde.reverse                             //> res6: List[Char] = List(e, d, c, b, a)
	abcde.reverse.reverse == abcde            //> res7: Boolean = true
	//Reverse could be implemented using concatenation (:::), like in the following method, rev:
	def rev[T](xs: List[T]): List[T] = xs match {
		case List() => xs
		case x :: xs1 => rev(xs1) ::: List(x)
  }                                               //> rev: [T](xs: List[T])List[T]
	
	/**
	* Prefixes and suffixes: drop, take, and splitAt
	*/
	abcde                                     //> res8: List[Char] = List(a, b, c, d, e)
	abcde take 2                              //> res9: List[Char] = List(a, b)
	abcde drop 2                              //> res10: List[Char] = List(c, d, e)
	abcde splitAt 2                           //> res11: (List[Char], List[Char]) = (List(a, b),List(c, d, e))
	
	/**
	* Element selection: apply and indices
	*/
	abcde apply 2                             //> res12: Char = c
	abcde(2)                                  //> res13: Char = c
	abcde.indices                             //> res14: scala.collection.immutable.Range = Range 0 until 5
	
	/**
	* Flattening a list of lists: flatten
	*/
	List(List(1, 2), List(3), List(), List(4, 5)).flatten
                                                  //> res15: List[Int] = List(1, 2, 3, 4, 5)
	val fruit: List[String] = List("apples", "oranges", "pears")
                                                  //> fruit  : List[String] = List(apples, oranges, pears)
	fruit.flatten                             //> res16: List[Char] = List(a, p, p, l, e, s, o, r, a, n, g, e, s, p, e, a, r,
                                                  //|  s)

  //List(1, 2, 3).flatten    error: No implicit view available from Int =>
    
  /**
  * Zipping lists: zip and unzip
  */
  abcde.indices zip abcde                         //> res17: scala.collection.immutable.IndexedSeq[(Int, Char)] = Vector((0,a), (
                                                  //| 1,b), (2,c), (3,d), (4,e))
  val zipped = abcde zip List(1, 2, 3)            //> zipped  : List[(Char, Int)] = List((a,1), (b,2), (c,3))
  abcde.zipWithIndex                              //> res18: List[(Char, Int)] = List((a,0), (b,1), (c,2), (d,3), (e,4))
  zipped.unzip                                    //> res19: (List[Char], List[Int]) = (List(a, b, c),List(1, 2, 3))
  
  /**
  * Displaying lists: toString and mkString
  */
  abcde.toString                                  //> res20: String = List(a, b, c, d, e)
  abcde mkString ("[", ",", "]")                  //> res21: String = [a,b,c,d,e]
  abcde mkString ""                               //> res22: String = abcde
  abcde.mkString                                  //> res23: String = abcde
  abcde mkString ("List(", ", ", ")")             //> res24: String = List(a, b, c, d, e)
  
  val buf = new StringBuilder                     //> buf  : StringBuilder = 
  abcde addString (buf, "(", ";", ")")            //> res25: StringBuilder = (a;b;c;d;e)
  
  /**
  * Converting lists: iterator, toArray, copyToArray
  */
  val arr = abcde.toArray                         //> arr  : Array[Char] = Array(a, b, c, d, e)
  arr.toList                                      //> res26: List[Char] = List(a, b, c, d, e)
  val arr2 = new Array[Int](10)                   //> arr2  : Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  List(1, 2, 3) copyToArray (arr2, 3)
  arr2                                            //> res27: Array[Int] = Array(0, 0, 0, 1, 2, 3, 0, 0, 0, 0)
  val it = abcde.iterator                         //> it  : Iterator[Char] = non-empty iterator
  it.next                                         //> res28: Char = a
  it.next                                         //> res29: Char = b
  it.next                                         //> res30: Char = c
  
  /**
  * Example: Merge sort
  * A merge sort function for Lists.
  */
	def msort[T](less: (T, T) => Boolean) (xs: List[T]): List[T] = {
	 def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
	   case (Nil, _) => ys
	   case (_, Nil) => xs
	   case (x :: xs1, y :: ys1) =>
	     if (less(x, y)) x :: merge(xs1, ys)
	     else y :: merge(xs, ys1)
	 }
	 val n = xs.length / 2
	 if (n == 0) xs
	 else {
	   val (ys, zs) = xs splitAt n
	   merge(msort(less)(ys), msort(less)(zs))
	 }
	}                                         //> msort: [T](less: (T, T) => Boolean)(xs: List[T])List[T]
	
	msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))
                                                  //> res31: List[Int] = List(1, 3, 5, 7)

  val intSort = msort((x: Int, y: Int) => x < y) _//> intSort  : List[Int] => List[Int] = example.FirstOrderMethodOnClassList$$$L
                                                  //| ambda$23/2081853534@2a2d45ba
                                                  
  val reverseIntSort = msort((x: Int, y: Int) => x > y) _
                                                  //> reverseIntSort  : List[Int] => List[Int] = example.FirstOrderMethodOnClassL
                                                  //| ist$$$Lambda$25/551734240@68be2bc2
                                                  
  val mixedInts = List(4, 1, 9, 0, 5, 8, 3, 6, 2, 7)
                                                  //> mixedInts  : List[Int] = List(4, 1, 9, 0, 5, 8, 3, 6, 2, 7)
  
  intSort(mixedInts)                              //> res32: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  reverseIntSort(mixedInts)                       //> res33: List[Int] = List(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
  
}
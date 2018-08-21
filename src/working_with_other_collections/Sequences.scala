package working_with_other_collections

object Sequences {
  /**
  * Sequence types let you work with groups of data lined up in order. Because
  * the elements are ordered, you can ask for the first element, second element,
  * 103rd element, and so on.
  */
  
  /**
  * List
  * Perhaps the most important sequence type. See working_with_list
  * Lists support fast addition and removal of items to the beginning of the list, but they
  * do not provide fast access to arbitrary indexes because the implementation
  * must iterate through the list linearly. The immutability of lists helps you develop correct, efficient algorithms
  * because you never need to make copies of a list.
  */
  val colors = List("red", "blue", "green")       //> colors  : List[String] = List(red, blue, green)
  colors.head                                     //> res0: String = red
  colors.tail                                     //> res1: List[String] = List(blue, green)
  
  /**
  * Arrays
  * Arrays allow you to hold a sequence of elements and efficiently access an
  * element at an arbitrary position, either to get or update the element, with a
  * zero-based index.
  */
  val fiveInts = new Array[Int](5)                //> fiveInts  : Array[Int] = Array(0, 0, 0, 0, 0)
  val fiveToOne = Array(5,4,3,2,1)                //> fiveToOne  : Array[Int] = Array(5, 4, 3, 2, 1)
  //accessing and updating an array element
  fiveInts(0) = fiveToOne(4)
  fiveInts                                        //> res2: Array[Int] = Array(1, 0, 0, 0, 0)
  
  /**
  * List buffers
  * A ListBuffer is a mutable object (contained in package
  * scala.collection.mutable), which can help you build lists more efficiently
  * when you need to append. ListBuffer provides constant time append
  * and prepend operations. You append elements with the += operator, and
  * prepend them with the +=: operator. When you’re done building, you can
  * obtain a List by invoking toList on the ListBuffer.
  */
  import scala.collection.mutable.ListBuffer
  val buf = new ListBuffer[Int]                   //> buf  : scala.collection.mutable.ListBuffer[Int] = ListBuffer()
  buf += 1                                        //> res3: example.Sequences.buf.type = ListBuffer(1)
  buf += 2                                        //> res4: example.Sequences.buf.type = ListBuffer(1, 2)
  3 +=: buf                                       //> res5: example.Sequences.buf.type = ListBuffer(3, 1, 2)
  buf += 4                                        //> res6: example.Sequences.buf.type = ListBuffer(3, 1, 2, 4)
  buf.toList                                      //> res7: List[Int] = List(3, 1, 2, 4)
  
  /**
  * Array buffers
  * An ArrayBuffer is like an array, except that you can additionally add and
  * remove elements from the beginning and end of the sequence. All Array
  * operations are available, though they are a little slower due to a layer of
  * wrapping in the implementation. The new addition and removal operations
  * are constant time on average, but occasionally require linear time due to the
  * implementation needing to allocate a new array to hold the buffer’s contents.
  */
  import scala.collection.mutable.ArrayBuffer
  val arrBuf = new ArrayBuffer[Int]               //> arrBuf  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  arrBuf += 12                                    //> res8: example.Sequences.arrBuf.type = ArrayBuffer(12)
  arrBuf += 15                                    //> res9: example.Sequences.arrBuf.type = ArrayBuffer(12, 15)
  arrBuf                                          //> res10: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(12, 15)
  //All the normal array methods are available
  arrBuf.length                                   //> res11: Int = 2
  arrBuf(0)                                       //> res12: Int = 12
  
  /**
  * Strings (via StringOps)
  * StringOps implements many sequence methods. Because Predef has an implicit conversion from String
  * to StringOps, you can treat any string like a sequence.
  * Because no method named "exists" is
  * declared in class String itself, the Scala compiler will implicitly convert s to StringOps, which has the method.
  */
  def hasUpperCase(s: String) = s.exists(_.isUpper)
                                                  //> hasUpperCase: (s: String)Boolean
  hasUpperCase("Robert Frost")                    //> res13: Boolean = true
  hasUpperCase("manoloto gafotas")                //> res14: Boolean = false
}
package working_with_lists

object ListPatterns extends App {
  val fruit: List[String] = List("apples", "oranges", "pears")
  val fruit2: List[String] = List("apples", "oranges", "pears", "grapes", "bananas", "tangerines")
  
  val List(a, b, c) = fruit
  println(a)
  println(b)
  println(c)
  
  val d :: e :: rest = fruit2 //d and e are String type, rest is a List type
  println(d)
  println(e)
  println(rest.mkString(","))  
  
  /**
   * here’s insertion sort again, this time written with pattern matching
   */
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => insert(x, isort(xs1))
  }
  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs
                    else y :: insert(x, ys)
  }
  
}
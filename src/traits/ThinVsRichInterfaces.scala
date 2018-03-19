package traits
/**
 * a thin interface like Java
 */
trait CharSequence {
  def charAt(index: Int): Char
  def length: Int
  def subSequence(start: Int, end: Int): CharSequence
  def toString(): String
}

/**
 * Example: Rectangular objects
 */
class Point(val x: Int, val y: Int)

trait Rectangular {
  def topLeft: Point
  def bottomRight: Point
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  //any many mor geometric methods....
}

abstract class Component extends Rectangular {
  //other methods....
}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {
  //other methods......
}

object ThinVsRichInterfaces extends App{
  val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
  println(rect.left)
  println(rect.right)
  println(rect.width)
}
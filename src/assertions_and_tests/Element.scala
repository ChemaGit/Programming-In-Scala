package assertions_and_tests

import Element.elem

object Spiral {
  val space = elem(" ")
  val corner = elem("+")
  
  def spiral(nEdges: Int, direction: Int): Element = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
      def verticalBar = elem('|', 1, sp.height)
      def horizontalBar = elem('-', sp.width, 1)
      if(direction == 0)        
        (corner beside horizontalBar) above (sp beside space)
      else if(direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if(direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }
  
  def main(args: Array[String]) {
    val nSides = args(0).toInt
    println(spiral(nSides, 3))
  }
}

object Element {
  
  //Listing 10.3 - Defining ArrayElement as a subclass of Element.
  private class ArrayElement(val contents: Array[String]) extends Element {
    //Listing 10.4 - Overriding a parameterless method with a field.
    //Listing 10.5 - Defining contents as a parametric field.
  }  
  
  private class LineElement(s: String)extends Element {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
  }  
  
  private class UniformElement(ch: Char, override val width: Int, override val height: Int)extends Element {
    private val line = ch.toString * width 
    def contents = Array.fill(height)(line)
  }
  
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)
  
  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)
  
  def elem(line: String): Element =
    new LineElement(line)
}

//Listing 10.1 - Defining an abstract method and class.
abstract class Element {
  def contents: Array[String]
  //Listing 10.2 - Defining parameterless methods width and height.
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length()
  
  //10.12 Implementing above, beside, and toString 
  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    assert(this1.width == that1.width) //Listing 14.1 - Using an assertion.
    elem(this1.contents ++ that1.contents)
  }
  
  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem( 
        for ((line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )  
  }
    
  def widen(w: Int): Element =
    if(w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      var right = elem(' ', w - width - left.width, height)
      left beside this beside right
    } ensuring (w <= _.width) //Listing 14.2 - Using ensuring to assert a function's result.
  
  def heighten(h: Int): Element =
    if(h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      var bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
  
  override def toString = contents mkString "\n"
}
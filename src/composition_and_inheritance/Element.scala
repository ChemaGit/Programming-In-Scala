package composition_and_inheritance

import Element.elem
  /**
   * Represent layout elements.
   */
  abstract class Element {   
    /**
     * Array of Strings, where each string represents a line
     */
    def contents: Array[String]
    //Defining parameterless methods width and height.
    def height: Int = contents.length
    def width: Int = contents(0).length
    
    /**
     * Concatenating the two contents values of the elements.
     */
    def above(that: Element) = {
      val this1 = this.widen(that.width)
      val that1 = that.widen(this.width)
      elem(this1.contents ++ that1.contents)
    }
    
    /**
     * putting elements of different widths on top of each other.
     */
    def beside(that: Element): Element = {
      val this1 = this.heighten(that.height)
      val that1 = that.heighten(this.height)      
      elem(
        for((line1, line2) <- this1.contents zip that1.contents)
          yield line1 + line2)
    }
    
    /**
     * takes a width and returns an Element of that width
     */
    def widen(w: Int): Element =
      if(w <= width) this
      else {
        val left = elem(' ', (w - width) / 2, height)
        val right = elem(' ', w - width - left.width, height)
        left.beside(this).beside(right)    
      }
    
    /**
     * takes a height and returns an Element of that height
     */
    def heighten(h: Int): Element =
      if(h <= height) this
      else {
        val top = elem(' ', width, (h - height) / 2)
        val bot = elem(' ', width, h - height - top.height)
        top.above(this).above(bot)
      }
    
    /**
     * Overriding method toString
     */
    override def toString = contents.mkString("\n")
  }

  /**
   * Companion object of the clas Element
   * A factory object with factory methods
   */
  object Element {
    //Defining contents as a parametric field
    private class ArrayElement(val contents: Array[String]) extends Element 
   
    //Invoking a superclass constructor
    private class LineElement(s: String) extends Element{
      val contents = Array(s)
      override def width = s.length
      override def height = 1
    }        
    private class UniformElement (ch: Char, override val width: Int, override val height: Int) extends Element {
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

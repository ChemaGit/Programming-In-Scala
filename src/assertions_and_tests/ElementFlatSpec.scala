package assertions_and_tests

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import Element.elem

/**
 * Specifying and testing behavior with a ScalaTest FlatSpec.
 */
class ElementFlatSpec extends FlatSpec with Matchers {
  "A UniformElement" should
     "have a width equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.width should be (2)
  }
  
  it should "have a height equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.height should be (3)    
  }
  
  it should "throw an IAE if passed a negative width" in {
    an [IllegalArgumentException] should be thrownBy {
      elem('x', -2, 3)
    }
  }
}
package assertions_and_tests

import org.scalatest._
import Element.elem

/**
 * Specifying and testing behavior with the specs2 framework.
 */
object ElementSpecification extends Specification  {
    "A UniformElement" should {
    "have a width equal to the passed value" in {
      val ele = elem('x', 2, 3)
      ele.width must be_==(2)
    }
    
    "have a height equal to the passed value" in {
      val ele = elem('x', 2, 3)
      ele.height must be_==(3)
    }
    
    "throw an IAE if passed a negative width" in {
      elem('x', 2,3) must throwA[IllegalArgumentException]
    }
  }  
}
//Imports and package statements
package assertions_and_tests

import org.scalatest.FunSuite

class ElementSuite extends FunSuite{
  
  /**
   * Tests are written using the `test` operator which takes two arguments:
   *
   * - A description of the test. This description has to be unique, no two
   *   tests can have the same description.
   * - The test body, a piece of Scala code that implements the test
   *
   * The most common way to implement a test body is using the method `assert`
   * which tests that its argument evaluates to `true`. So one of the simplest
   * successful tests is the following:
   */
  test("one plus one is two")(assert(1 + 1 == 2))

  /**
   * One problem with the previous (failing) test is that ScalaTest will
   * only tell you that a test failed, but it will not tell you what was
   * the reason for the failure. The output looks like this:
   *
   * {{{
   *    [info] - one plus one is three? *** FAILED ***
   * }}}
   *
   * This situation can be improved by using a special equality operator
   * `===` instead of `==` (this is only possible in ScalaTest). So if you
   * run the next test, ScalaTest will show the following output:
   *
   * {{{
   *    [info] - details why one plus one is not three *** FAILED ***
   *    [info]   2 did not equal 3 (ListsSuite.scala:67)
   * }}}
   *
   * We recommend to always use the `===` equality operator when writing tests.
   */
  test("details why one plus one is not three") {
    assert(1 + 1 == 3) // Fix me, please!
  }  

  /**
   * In Scala, it is allowed to pass an argument to a method using the block
   * syntax, i.e. `{ argument }` instead of parentheses `(argument)`.
   *
   * This allows tests to be written in a more readable manner:
   */
  test("one plus one is three?") {
    assert(1 + 1 == 3) // This assertion fails! Go ahead and fix it.
  }
  
  /**
   * In order to test the exceptional behavior of a methods, ScalaTest offers
   * the `intercept` operation.
   *
   * In the following example, we test the fact that the method `intNotZero`
   * throws an `IllegalArgumentException` if its argument is `0`.
   */
  test("intNotZero throws an exception if its argument is 0") {
    intercept[IllegalArgumentException] {
      intNotZero(0)
    }
  }

  def intNotZero(x: Int): Int = {
    if (x == 0) throw new IllegalArgumentException("zero is not allowed")
    else x
  }  
  
  test("test the reverse of a list") {
    val list = List(1, 2, 3)
    assert(list.reverse == (3,2,1))
  }
  
  val list = List(1, 2, 3)
  assertResult(2) {    
    list.length
  }  
  
  val caught =
    intercept[ArithmeticException] {
      1 / 0
  }
  assert(caught.getMessage == "/ by zero")
}
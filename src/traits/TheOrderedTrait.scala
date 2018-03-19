package traits

/**
 * Making RationalOrd comparable
 */
class RationalOrd(n: Int, d: Int) extends Ordered[RationalOrd]{
  /**
   * precondition, d have to =! 0
   * if d == 0 then an IllegalArgumentException will be thrown
   */
  require(d != 0)
  
  private val g = gcd(n.abs, d.abs)
  
  val numer = n / g
  val denom = d / g
  
  /**
   * Auxiliary constructor
   */
  def this(n: Int) = this(n, 1)
  
  /**
   * Now RationalOrd mixes in the Ordered trait.
   * Defining a compare method for comparing two objects of RationalOrd.
   * Return zero if the objects are the same.
   * Negative if receiver is less than the argument.
   * Positive if the receiver is greater than the argument.
   * However you need to define equals yourself, even if you inherit Ordered.
   */
  def compare(that: RationalOrd) =
    (this.numer * that.denom) - (that.numer * this.denom)
  
  /**
   * The sum of Two Rationals
   */
  def + (that: RationalOrd): RationalOrd =
    new RationalOrd(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom)
  
  /**
   * The method + overloaded
   */
  def + (i: Int): RationalOrd =
    new RationalOrd(this.numer + i * denom, denom)
  
  /**
   * Substract of two Rationals
   */
  def - (that: RationalOrd): RationalOrd = 
    new RationalOrd(this.numer * that.denom - that.numer * this.denom, this.denom * that.denom)
  
  /**
   * The method - overloaded
   */
  def - (i: Int): RationalOrd =
    new RationalOrd(this.numer - i * this.denom, denom) 
  
  /**
   * The product of two Rationals
   */
  def * (that: RationalOrd): RationalOrd =
    new RationalOrd(this.numer * that.numer, this.denom * that.denom)
  
  /**
   * The method * overloaded
   */
  def * (i: Int): RationalOrd =
    new RationalOrd(this.numer * i, denom)
  
  /**
   * The division of two Rationals
   */
  def / (that: RationalOrd): RationalOrd =
    new RationalOrd(this.numer * that.denom, this.denom * that.numer)
  
  /**
   * The method / overloaded
   */
  def / (i: Int): RationalOrd =
    new RationalOrd(this.numer, this.denom * i)
  
  /**
   * Test whether the given Rational is smaller than a parameter
   */
  def lessThan(that: RationalOrd) =
    this.numer * that.denom < that.numer * this.denom
    
  /**
   * Return the max of two Rationals  
   */
  def max(that: RationalOrd) =
    if(lessThan(that)) that else this
    
  /**
   * Calculate the greatest common divisor of two numbers  
   */
  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a % b)
  
  /**
   * override the class Object's method toString
   */
  override def toString = numer + "/" + denom  
}

object TheOrderedTrait extends App{
  val half = new RationalOrd(1, 2)
  val third = new RationalOrd(1, 3)
  
  println(half < third)
  println(half >= third)
  println(third >= half)
  println(half > third)
}
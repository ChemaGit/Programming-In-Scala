package functional_objects

class Rational(n: Int, d: Int) {
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
   * The sum of Two Rationals
   */
  def + (that: Rational): Rational =
    new Rational(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom)
  
  /**
   * The method + overloaded
   */
  def + (i: Int): Rational =
    new Rational(this.numer + i * denom, denom)
  
  /**
   * Substract of two Rationals
   */
  def - (that: Rational): Rational = 
    new Rational(this.numer * that.denom - that.numer * this.denom, this.denom * that.denom)
  
  /**
   * The method - overloaded
   */
  def - (i: Int): Rational =
    new Rational(this.numer - i * this.denom, denom) 
  
  /**
   * The product of two Rationals
   */
  def * (that: Rational): Rational =
    new Rational(this.numer * that.numer, this.denom * that.denom)
  
  /**
   * The method * overloaded
   */
  def * (i: Int): Rational =
    new Rational(this.numer * i, denom)
  
  /**
   * The division of two Rationals
   */
  def / (that: Rational): Rational =
    new Rational(this.numer * that.denom, this.denom * that.numer)
  
  /**
   * The method / overloaded
   */
  def / (i: Int): Rational =
    new Rational(this.numer, this.denom * i)
  
  /**
   * Test whether the given Rational is smaller than a parameter
   */
  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom
    
  /**
   * Return the max of two Rationals  
   */
  def max(that: Rational) =
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
//TODO:
object Rational extends App{
  val n = new Rational(1, 2)
  //val non = new Rational(2,0)
  val twoThirds = new Rational(2, 3)
  val rat = new Rational(66, 42)
  println(n)
  println(n + twoThirds)
  println(rat)
  println(rat * n)
  println(n + twoThirds * rat)
  println( (n + twoThirds) * rat)
}
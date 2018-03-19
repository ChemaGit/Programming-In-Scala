package scala_hierarchy

  /**
  For a class to be a value class, it must have exactly one parameter
  and it must have nothing inside it exceptt defs.
  No other class can extend a value class, and a value class
  cannot redefine equals or hashCode
  To define a value class, make it a subclass of AnyVal and put val before the one parameter
  */
  class Dollars(val amount: Int)extends AnyVal {
    override def toString = "$" + amount
  }

  class SwissFrancs(val amount: Int)extends AnyVal {
    override def toString = amount + " CHF"
  }

object DefiningYourOwnValueClasses extends App{
  println("Defining your own value classes")
  
  val money = new Dollars(100000)  
  val dollars = new Dollars(1000)
  val francs = new SwissFrancs(1000)
  println(money)
  println(dollars)
  println(francs)
  //Avoiding a types monoculture  
    
  class Anchor(val value: String) extends AnyVal
  class Style(val value: String) extends AnyVal
  class Text(val value: String) extends AnyVal
  class Html(val value: String) extends AnyVal
  /**
   * If you try to use this with the arguments in the wrong order,
   * the compiler can now detect an error
   */
  def title(text: Text, anchor: Anchor, style: Style): Html =
    new Html(
      s"<a id='${anchor.value}'>" +
      s"<h1 class='${style.value}'>" + text.value + "</h1></a>"
    )  
  
  //title(new Anchor("chap:vcls"), new Style("bold"), new Text("Value Classes"))  
  title(new Text("Value Classes"), new Anchor("chap:vcls"), new Style("bold"))
  
}
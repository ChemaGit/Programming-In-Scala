package scala_hierarchy

object DefiningYourOwnValueClasses {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(106); 
  println("Defining your own value classes")
  
  /**
  For a class to be a value class, it must have exactly one parameter
  and it must have nothing inside it exceptt defs.
  No other class can extend a value class, and a value class
  cannot redefine equals or hashCode
  To define a value class, make it a subclass of AnyVal and put val before the one parameter
  */
  class Dollars(val amount: Int)extends AnyVal {
    override def toString = "$" + amount
  };$skip(457); 
  
  val money = new Dollars(100000)
 
  class SwissFrancs(val amount: Int)extends AnyVal {
    override def toString = amount + " CHF"
  };System.out.println("""money  : scala_hierarchy.DefiningYourOwnValueClasses.Dollars = """ + $show(money ));$skip(140); 
  
  val dollars = new Dollars(1000);System.out.println("""dollars  : scala_hierarchy.DefiningYourOwnValueClasses.Dollars = """ + $show(dollars ));$skip(37); 
  val francs = new SwissFrancs(1000);System.out.println("""francs  : scala_hierarchy.DefiningYourOwnValueClasses.SwissFrancs = """ + $show(francs ))}
  
  //Avoiding a types monoculture
}

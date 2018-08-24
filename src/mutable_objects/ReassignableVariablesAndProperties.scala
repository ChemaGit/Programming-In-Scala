package mutable_objects

object ReassignableVariablesAndProperties extends App{
  /**
   * You can perform two fundamental operations on a reassignable variable: get
   * its value or set it to a new value. In libraries such as JavaBeans, these operations
   * are often encapsulated in separate getter and setter methods, which
   * need to be defined explicitly.
   * In Scala, every var that is a non-private member of some object implicitly
   * defines a getter and a setter method with it. These getters and setters are
   * named differently from the Java convention, however. The getter of a var x
   * is just named "x", while its setter is named "x_=".
   * The field is always marked private[this], which means it can be accessed
   * only from the object that contains it. The getter and setter, on the other
   * hand, get the same visibility as the original var.
   */
  var hour = 12 //generates a getter, "hour", and setter, "hour_="
  
  class Time {
    var hour = 12
    var minute = 0
  }
  
  /**
   * you can also choose to define a getter and a setter directly, instead of
   * defining a var. By defining these access methods directly you can interpret
   * the operations of variable access and variable assignment as you like.
   */
  
  class Time2 {
    //How public vars are expanded into getter and setter methods.
    private[this] var h = 12
    private[this] var m = 0
    
    def hour: Int = h
    def hour_=(x: Int) = {h = x}
    
    def minute: Int = m
    def minute_=(x: Int) = {m = x}
  }
  
  class Time3 {
    //contains requirements that catch all assignments to hour and minute with illegal values.
    private[this] var h = 12
    private[this] var m = 0
    
    def hour: Int = h
    def hour_= (x: Int) = {
      require(0 <= x && x < 24)
      h = x
    }
    
    def minute: Int = m
    def minute_= (x: Int) = {
      require(0 <= x && x < 60)
      m = x
    }
  }
  
  /**
   * It’s also possible, and sometimes useful, to define a getter and a setter without an associated field.
   * The first line in the body of this class defines a var, celsius, which
   * will contain the temperature in degrees Celsius. The celsius variable is
   * initially set to a default value by specifying '_' as the "initializing value"
   * of the variable. More precisely, an initializer "= _" of a field assigns a zero
   * value to that field. The zero value depends on the field’s type. It is 0 for
   * numeric types, false for booleans, and null for reference types.
   * var celsius: Float --> declare an abstract variable, not an uninitialized one.
   */
  class Thermometer {
    var celsius: Float = _
    def fahrenheit = celsius * 9 / 5 + 32
    def fahrenheit_= (f: Float) = {
      celsius = (f - 32) * 5 / 9
    }
    override def toString = fahrenheit + "F/" + celsius + "C"
  }
  val t = new Thermometer //t: Thermometer = 32.0F/0.0C
  t.celsius = 100         //t.celsius: Float = 100.0
  println(t)              //212.0F/100.0C
  t.fahrenheit =  -40     //t.fahrenheit: Float = 40.0
  println(t)              //40.0F/40.0C
}
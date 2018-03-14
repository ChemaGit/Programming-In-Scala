package basic_types_and_operations

object RelationalAndLogicalOperations {
  println("Relational and logical operations.")   //> Relational and logical operations.
  1 > 2                                           //> res0: Boolean(false) = false
  1 < 2                                           //> res1: Boolean(true) = true
  1.0 <= 1.0                                      //> res2: Boolean(true) = true
  3.5f >= 3.6f                                    //> res3: Boolean(false) = false
  'a' >= 'A'                                      //> res4: Boolean(true) = true
  val untrue = !true                              //> untrue  : Boolean = false
  val toBe = true                                 //> toBe  : Boolean = true
  val question = toBe || !toBe                    //> question  : Boolean = true
  val paradox = toBe && !toBe                     //> paradox  : Boolean = false
  def salt() = {println("salt"); false}           //> salt: ()Boolean
  def pepper() = {println("pepper"); true}        //> pepper: ()Boolean
  pepper() && salt()                              //> pepper
                                                  //| salt
                                                  //| res5: Boolean = false
  salt() && pepper()                              //> salt
                                                  //| res6: Boolean = false
  salt() & pepper()                               //> salt
                                                  //| pepper
                                                  //| res7: Boolean = false
 
 
}
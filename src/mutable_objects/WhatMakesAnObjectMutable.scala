package mutable_objects

object WhatMakesAnObjectMutable extends App{
  /**
   * When you invoke a method or dereference a field on some purely functional
	 * object, you will always get the same result.
	 * an application of cs.head will always return 'a'.
	 * This is the case even if there is an arbitrary number of operations on the list cs between the point
   * where it is defined and the point where the access cs.head is made.
   */
  val cs = List('a', 'b', 'c')
  println(cs.head)
  /**
   * For a mutable object, on the other hand, the result of a method call or field
   * access may depend on what operations were previously performed on the object.
   * A good example of a mutable object is a bank account.
   */
  class BankAccount {
    private var bal: Int = 0
    def balance: Int = bal
    def deposit(amount: Int) = {
      require(amount > 0)
      bal += amount
    }
    def withdraw(amount: Int): Boolean =
      if(amount > bal) false
      else {
        bal -= amount
        true
      }
  }
  /**
   * clearly, bank accounts have mutable state, because the same operation
   * can return different results at different times.
   */
  val account = new BankAccount
  account deposit 100
  println(account withdraw 80)
  //res1: Boolean = true
  println(account withdraw 80)
  //res2: Boolean = false
  
  /**
   * Mutation and vars usually go hand in hand,
   * but things are not always so clear cut. For instance, a class
   * might be mutable without defining or inheriting any vars because it forwards
   * method calls to other objects that have mutable state. The reverse is
   * also possible: A class might contain vars and still be purely functional.
   * Keyed is purely functional,
   * then so is MemoKeyed, even though it contains a reassignable variable.
   */
  class Keyed {
    def computeKey: Int = ??? // this will take some time    
  }  
  
  class MemoKeyed extends Keyed {
    private var keyCache: Option[Int] = None
    override def computeKey: Int = {
      if(!keyCache.isDefined) keyCache = Some(super.computeKey)
      keyCache.get
    }
  }
  
}
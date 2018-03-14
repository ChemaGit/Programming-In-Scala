package next_steps

object Lists {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  List()                                          //> res0: List[Nothing] = List()
  List("Cool", "tools", "rule")                   //> res1: List[String] = List(Cool, tools, rule)
  val thrill = "Will" :: "fill" :: "until" :: Nil //> thrill  : List[String] = List(Will, fill, until)
  List("a", "b"):::List("c", "d")                 //> res2: List[String] = List(a, b, c, d)
  thrill(2)                                       //> res3: String = until
  thrill.count(s => s.length == 4)                //> res4: Int = 2
  thrill.drop(2)                                  //> res5: List[String] = List(until)
  thrill.dropRight(2)                             //> res6: List[String] = List(Will)
  thrill.exists(s => s == "until")                //> res7: Boolean = true
  thrill.filter(s => s.length == 4)               //> res8: List[String] = List(Will, fill)
  thrill.forall(s => s.endsWith("l"))             //> res9: Boolean = true
  thrill.foreach(s => println(s))                 //> Will
                                                  //| fill
                                                  //| until
  thrill.foreach(println)                         //> Will
                                                  //| fill
                                                  //| until
  thrill.head                                     //> res10: String = Will
  thrill.init                                     //> res11: List[String] = List(Will, fill)
  thrill.isEmpty                                  //> res12: Boolean = false
  thrill.last                                     //> res13: String = until
  thrill.length                                   //> res14: Int = 3
  thrill.map(s => s + "y")                        //> res15: List[String] = List(Willy, filly, untily)
  thrill.mkString(",")                            //> res16: String = Will,fill,until
  thrill.filterNot(s => s.length == 4)            //> res17: List[String] = List(until)
  thrill.reverse                                  //> res18: List[String] = List(until, fill, Will)
  thrill.sortWith((s, t) => s.charAt(0).toLower < t.charAt(0).toLower)
                                                  //> res19: List[String] = List(fill, until, Will)
  thrill.tail                                     //> res20: List[String] = List(fill, until)
}
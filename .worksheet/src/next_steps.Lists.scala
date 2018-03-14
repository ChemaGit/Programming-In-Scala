package next_steps

object Lists {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(9); val res$0 = 
  List();System.out.println("""res0: List[Nothing] = """ + $show(res$0));$skip(32); val res$1 = 
  List("Cool", "tools", "rule");System.out.println("""res1: List[String] = """ + $show(res$1));$skip(50); 
  val thrill = "Will" :: "fill" :: "until" :: Nil;System.out.println("""thrill  : List[String] = """ + $show(thrill ));$skip(34); val res$2 = 
  List("a", "b"):::List("c", "d");System.out.println("""res2: List[String] = """ + $show(res$2));$skip(12); val res$3 = 
  thrill(2);System.out.println("""res3: String = """ + $show(res$3));$skip(35); val res$4 = 
  thrill.count(s => s.length == 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(17); val res$5 = 
  thrill.drop(2);System.out.println("""res5: List[String] = """ + $show(res$5));$skip(22); val res$6 = 
  thrill.dropRight(2);System.out.println("""res6: List[String] = """ + $show(res$6));$skip(35); val res$7 = 
  thrill.exists(s => s == "until");System.out.println("""res7: Boolean = """ + $show(res$7));$skip(36); val res$8 = 
  thrill.filter(s => s.length == 4);System.out.println("""res8: List[String] = """ + $show(res$8));$skip(38); val res$9 = 
  thrill.forall(s => s.endsWith("l"));System.out.println("""res9: Boolean = """ + $show(res$9));$skip(34); 
  thrill.foreach(s => println(s));$skip(26); 
  thrill.foreach(println);$skip(14); val res$10 = 
  thrill.head;System.out.println("""res10: String = """ + $show(res$10));$skip(14); val res$11 = 
  thrill.init;System.out.println("""res11: List[String] = """ + $show(res$11));$skip(17); val res$12 = 
  thrill.isEmpty;System.out.println("""res12: Boolean = """ + $show(res$12));$skip(14); val res$13 = 
  thrill.last;System.out.println("""res13: String = """ + $show(res$13));$skip(16); val res$14 = 
  thrill.length;System.out.println("""res14: Int = """ + $show(res$14));$skip(27); val res$15 = 
  thrill.map(s => s + "y");System.out.println("""res15: List[String] = """ + $show(res$15));$skip(23); val res$16 = 
  thrill.mkString(",");System.out.println("""res16: String = """ + $show(res$16));$skip(39); val res$17 = 
  thrill.filterNot(s => s.length == 4);System.out.println("""res17: List[String] = """ + $show(res$17));$skip(17); val res$18 = 
  thrill.reverse;System.out.println("""res18: List[String] = """ + $show(res$18));$skip(71); val res$19 = 
  thrill.sortWith((s, t) => s.charAt(0).toLower < t.charAt(0).toLower);System.out.println("""res19: List[String] = """ + $show(res$19));$skip(14); val res$20 = 
  thrill.tail;System.out.println("""res20: List[String] = """ + $show(res$20))}
}

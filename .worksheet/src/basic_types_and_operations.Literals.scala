package basic_types_and_operations

object Literals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 
  println("Exadecimal Literals");$skip(16); 
  val hex = 0x5;System.out.println("""hex  : Int = """ + $show(hex ));$skip(20); 
  val hex2 = 0x00FF;System.out.println("""hex2  : Int = """ + $show(hex2 ));$skip(25); 
  val magic = 0xcafebabe;System.out.println("""magic  : Int = """ + $show(magic ));$skip(31); 
  println("Integers Literals");$skip(16); 
  val dec1 = 31;System.out.println("""dec1  : Int = """ + $show(dec1 ));$skip(17); 
  val dec2 = 255;System.out.println("""dec2  : Int = """ + $show(dec2 ));$skip(16); 
  val dec3 = 20;System.out.println("""dec3  : Int = """ + $show(dec3 ));$skip(36); 
  println("Long Integers Literals");$skip(25); 
  val prog = 0xcafebabeL;System.out.println("""prog  : Long = """ + $show(prog ));$skip(18); 
  val tower = 35L;System.out.println("""tower  : Long = """ + $show(tower ));$skip(15); 
  val of = 31l;System.out.println("""of  : Long = """ + $show(of ));$skip(37); 
  println("Short and Byte Literals");$skip(26); 
  val little: Short = 367;System.out.println("""little  : Short = """ + $show(little ));$skip(25); 
  val littler: Byte = 38;System.out.println("""littler  : Byte = """ + $show(littler ));$skip(37); 
  println("Floating point Literals");$skip(18); 
  val big = 1.235;System.out.println("""big  : Double = """ + $show(big ));$skip(24); 
  val bigger = 1.2345e1;System.out.println("""bigger  : Double = """ + $show(bigger ));$skip(27); 
  val biggerStill = 123E45;System.out.println("""biggerStill  : Double = """ + $show(biggerStill ));$skip(24); 
  val littelF = 1.2345F;System.out.println("""littelF  : Float = """ + $show(littelF ));$skip(27); 
  val littleBiggerF = 3e5f;System.out.println("""littleBiggerF  : Float = """ + $show(littleBiggerF ));$skip(26); 
  val anotherDouble = 3e5;System.out.println("""anotherDouble  : Double = """ + $show(anotherDouble ));$skip(24); 
  val yetAnother = 3e5D;System.out.println("""yetAnother  : Double = """ + $show(yetAnother ));$skip(32); 
  println("Character literals");$skip(14); 
  val a = 'A';System.out.println("""a  : Char = """ + $show(a ));$skip(19); 
  val d = '\u0041';System.out.println("""d  : Char = """ + $show(d ));$skip(19); 
  val f = '\u0044';System.out.println("""f  : Char = """ + $show(f ));$skip(24); 
  val B\u0041\u0044 = 1;System.out.println("""BAD  : Int = """ + $show(BAD ));$skip(23); 
  val backslash = '\\';System.out.println("""backslash  : Char = """ + $show(backslash ));$skip(20); 
  val slashN = '\n';System.out.println("""slashN  : Char = """ + $show(slashN ));$skip(20); 
  val slashB = '\b';System.out.println("""slashB  : Char = """ + $show(slashB ));$skip(20); 
  val slashT = '\t';System.out.println("""slashT  : Char = """ + $show(slashT ));$skip(20); 
  val slashF = '\f';System.out.println("""slashF  : Char = """ + $show(slashF ));$skip(20); 
  val slashR = '\r';System.out.println("""slashR  : Char = """ + $show(slashR ));$skip(25); 
  val slashDquote = '\"';System.out.println("""slashDquote  : Char = """ + $show(slashDquote ));$skip(24); 
  val slashQuote = '\'';System.out.println("""slashQuote  : Char = """ + $show(slashQuote ));$skip(19); 
  val slash = '\\';System.out.println("""slash  : Char = """ + $show(slash ));$skip(29); 
  println("String Literals");$skip(22); 
  val hello = "hello";System.out.println("""hello  : String = """ + $show(hello ));$skip(24); 
  val scapes = "\\\"\'";System.out.println("""scapes  : String = """ + $show(scapes ));$skip(92); 
  val rawString = """Welcome to Ultamix 3000.
                     Type "HELP" for help.""";System.out.println("""rawString  : String = """ + $show(rawString ));$skip(96); 
  val rawString2 = """|Welcome to Ultamix 3000.
                      |Type "HELP" for help.""";System.out.println("""rawString2  : String = """ + $show(rawString2 ));$skip(34); 
  println(rawString2.stripMargin);$skip(29); 
  println("Symbol Literals");$skip(19); 
  val s = 'aSymbol;System.out.println("""s  : Symbol = """ + $show(s ));$skip(18); 
  val nm = s.name;System.out.println("""nm  : String = """ + $show(nm ));$skip(30); 
  println("Boolean literals");$skip(18); 
  val bool = true;System.out.println("""bool  : Boolean = """ + $show(bool ));$skip(19); 
  val fool = false;System.out.println("""fool  : Boolean = """ + $show(fool ))}
}

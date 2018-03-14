package basic_types_and_operations

object Literals {
  println("Exadecimal Literals")                  //> Exadecimal Literals
  val hex = 0x5                                   //> hex  : Int = 5
  val hex2 = 0x00FF                               //> hex2  : Int = 255
  val magic = 0xcafebabe                          //> magic  : Int = -889275714
  println("Integers Literals")                    //> Integers Literals
  val dec1 = 31                                   //> dec1  : Int = 31
  val dec2 = 255                                  //> dec2  : Int = 255
  val dec3 = 20                                   //> dec3  : Int = 20
  println("Long Integers Literals")               //> Long Integers Literals
  val prog = 0xcafebabeL                          //> prog  : Long = 3405691582
  val tower = 35L                                 //> tower  : Long = 35
  val of = 31l                                    //> of  : Long = 31
  println("Short and Byte Literals")              //> Short and Byte Literals
  val little: Short = 367                         //> little  : Short = 367
  val littler: Byte = 38                          //> littler  : Byte = 38
  println("Floating point Literals")              //> Floating point Literals
  val big = 1.235                                 //> big  : Double = 1.235
  val bigger = 1.2345e1                           //> bigger  : Double = 12.345
  val biggerStill = 123E45                        //> biggerStill  : Double = 1.23E47
  val littelF = 1.2345F                           //> littelF  : Float = 1.2345
  val littleBiggerF = 3e5f                        //> littleBiggerF  : Float = 300000.0
  val anotherDouble = 3e5                         //> anotherDouble  : Double = 300000.0
  val yetAnother = 3e5D                           //> yetAnother  : Double = 300000.0
  println("Character literals")                   //> Character literals
  val a = 'A'                                     //> a  : Char = A
  val d = '\u0041'                                //> d  : Char = A
  val f = '\u0044'                                //> f  : Char = D
  val B\u0041\u0044 = 1                           //> BAD  : Int = 1
  val backslash = '\\'                            //> backslash  : Char = \
  val slashN = '\n'                               //> slashN  : Char = 
                                                  //| 
  val slashB = '\b'                               //> slashB  : Char = 
  val slashT = '\t'                               //> slashT  : Char = 	
  val slashF = '\f'                               //> slashF  : Char = 
  val slashR = '\r'                               //> slashR  : Char = 
  val slashDquote = '\"'                          //> slashDquote  : Char = "
  val slashQuote = '\''                           //> slashQuote  : Char = '
  val slash = '\\'                                //> slash  : Char = \
  println("String Literals")                      //> String Literals
  val hello = "hello"                             //> hello  : String = hello
  val scapes = "\\\"\'"                           //> scapes  : String = \"'
  val rawString = """Welcome to Ultamix 3000.
                     Type "HELP" for help."""     //> rawString  : String = Welcome to Ultamix 3000.
                                                  //|                      Type "HELP" for help.
  val rawString2 = """|Welcome to Ultamix 3000.
                      |Type "HELP" for help."""   //> rawString2  : String = |Welcome to Ultamix 3000.
                                                  //|                       |Type "HELP" for help.
  println(rawString2.stripMargin)                 //> Welcome to Ultamix 3000.
                                                  //| Type "HELP" for help.
  println("Symbol Literals")                      //> Symbol Literals
  val s = 'aSymbol                                //> s  : Symbol = 'aSymbol
  val nm = s.name                                 //> nm  : String = aSymbol
  println("Boolean literals")                     //> Boolean literals
  val bool = true                                 //> bool  : Boolean = true
  val fool = false                                //> fool  : Boolean = false
}
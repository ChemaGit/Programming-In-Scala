package case_classes_pattern_matching

object TheOptionType extends App{
  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
  capitals get "France" //res23: Option[String] = Some(Paris)
  capitals get "North Pole" //Option[String] = None
  
  /**
   * The most common way to take optional values apart is through a pattern match
   */
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
  show(capitals get "Japan") //res25: String = Tokyo
  show(capitals get "France") //res26: String = Paris
  show(capitals get "North Pole") //res27: String = ?  
  
}



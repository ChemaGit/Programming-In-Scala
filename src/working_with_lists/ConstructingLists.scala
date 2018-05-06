package working_with_lists

/**
 * All lists are built from two fundamental building blocks, Nil and ::
 * That is, x :: xs represents a list whose 
 * first element is x, followed by (the elements of) list xs.
 */
object ConstructingLists extends App{
  val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
  val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
  val diag3 = (1 :: (0 :: (0 :: Nil))) :: (0 :: (1 :: (0 :: Nil))) :: (0 :: (0 :: (1 :: Nil))) :: Nil
  val empty = Nil  
}
package packages_and_imports

/**
 * Scala adds some imports implicitly to every program.
 */
import java.lang._ //everything in the java.lang package
import scala._ // everything in the scala package
import Predef._ // everything in the Predef object

/**
 * The scala import overshadows the java.lang import,
 * the simple name StringBuilder will refer to scala.StringBuilder, not java.lang.StringBuilder.
 */

object ImplicitImports {
  
}
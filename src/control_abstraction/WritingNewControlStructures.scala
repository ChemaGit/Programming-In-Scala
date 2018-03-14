package control_abstraction

import java.io._

object WritingNewControlStructures {
  
  def twice(op: Double => Double, x: Double) = op(op(x))
  
  def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }
  
  def main(args: Array[String]) {
    println(twice(_ + 5, 5))
    val file = new File("date.txt")
    withPrintWriter(file){writer => writer.println(new java.util.Date)}
  }
}
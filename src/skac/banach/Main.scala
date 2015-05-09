package skac.banach
import skac.banach.dsl._
import scala.util.parsing.combinator.syntactical._

object Main {

  def main(args: Array[String]): Unit = {
    val code = "def a struct {}"    
    println(code)
    val input = new Dsl.lexical.Scanner(code)
    val res = Dsl.struct_def.apply(input)
    println(res)
  }
}
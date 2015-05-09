package skac.banach.dsl

import scala.util.parsing.combinator.syntactical._
import skac.banach._

object Dsl extends StandardTokenParsers {
//  type StructPart = Tuple2[String, StructDef]
  lexical.delimiters ++= List("(", ")", ",", "{", "}")
  lexical.reserved += ("struct", "obj", ":", "sym", "part", "def", "{", "}", "sen")  
  def symbol: Parser[String] = "sym" ~> ident
  def part: Parser[StructDef] = "part" ~> ident ~ struct_def_body ^^ {case name ~ body => new StructDef(name, body)}
  def struct_el = part | constraint
//  def structpart: Parser[StructPart] = symbol | struct_def  
  def struct_def: Parser[StructDef] = "def" ~> ident ~ struct_def_body ^^ {case name ~ body => new StructDef(name, body)}  
  def constraint: Parser[Sentence] = "sen" ^^ (_ => new Sentence())
  def struct_def_body: Parser[StructDefBody] = "struct" ~> "{" ~> repsep(struct_el, ",") <~ "}" ^^ ((elms: List[StructEl]) => (new StructDefBody(elms:_*)))  
    
//    case defs => StructDefBody(defs)}
}
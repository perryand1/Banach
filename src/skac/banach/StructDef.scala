package skac.banach

case class StructDef(Name: String, Body: StructDefBody) extends StructEl {
  def symbol(Name: String) = StructDef(Name, StructDefBody.empty)
}
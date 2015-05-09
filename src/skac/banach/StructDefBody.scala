package skac.banach

object StructDefBody {
  def empty = StructDefBody()
}

case class StructDefBody(Parts: Set[StructDef] = Set(), Constraints: Set[Sentence] = Set()) {
  def this(Elems: StructEl*) {    
    this((Elems.toSet filter {_.isInstanceOf[StructDef]}).asInstanceOf[Set[StructDef]]  , (Elems.toSet filter {_.isInstanceOf[Sentence]}).asInstanceOf[Set[Sentence]])      
  }
}
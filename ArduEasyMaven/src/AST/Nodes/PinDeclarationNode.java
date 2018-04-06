package AST.Nodes;

import visitor.Visitor;

public class PinDeclarationNode extends DefinitionNode implements RoomBlockNode
{
    public IdentifierNode Identifier;
    public PinNode Pin;
    public IoStatusNode IoStatus;

    @Override
    public String toString()
    {
        return "PinDeclaration";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

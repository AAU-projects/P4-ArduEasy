package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ArrayDeclarationNode extends DefinitionNode implements RoomBlockNode
{
    public List<IdentifierNode> Values = new ArrayList<IdentifierNode>();

    @Override
    public String toString()
    {
        return "Array Declaration";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

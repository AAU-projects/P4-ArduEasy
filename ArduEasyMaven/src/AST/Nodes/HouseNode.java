package AST.Nodes;

import visitor.Visitor;

import java.util.List;

public class HouseNode extends IdentifierNode
{
    public IdentifierNode Identifier;

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

package AST.Nodes;

import visitor.Visitor;

import java.util.List;

public class HouseNode extends ExpressionNode
{
    public List<IdentifierNode> Identifiers;

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

package AST.Nodes;

import visitor.Visitor;

public class EqualsNode extends LogicalExprNode
{
    @Override
    public String toString()
    {
        return "Equal comparison";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}
package AST.Nodes;

import visitor.Visitor;

public class GreaterOrEqualNode extends LogicalExprNode
{
    @Override
    public String toString()
    {
        return "GreaterOrEqual comparison";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}
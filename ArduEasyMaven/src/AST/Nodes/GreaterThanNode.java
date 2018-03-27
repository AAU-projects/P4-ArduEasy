package AST.Nodes;

import visitor.Visitor;

public class GreaterThanNode extends LogicalExprNode
{
    @Override
    public String toString()
    {
        return "GreaterThan comparison";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}
package AST.Nodes;

import visitor.Visitor;

public class LessThanNode extends LogicalExprNode
{
    @Override
    public String toString()
    {
        return "LessThan comparison";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}
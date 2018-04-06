package AST.Nodes;

import visitor.Visitor;

public class LogicalOrNode extends LogicalExprNode
{
    @Override
    public String toString()
    {
        return "or";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}
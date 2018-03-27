package AST.Nodes;

import visitor.Visitor;

public class LogicalAndNode extends LogicalExprNode
{
    @Override
    public String toString()
    {
        return "and";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

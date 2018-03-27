package AST.Nodes;

import visitor.Visitor;

public class LessOrEqualNode extends LogicalExprNode
{
    @Override
    public String toString()
    {
        return "LessOrEqual comparison";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

package AST.Nodes;

import visitor.Visitor;

public class NotEqualsNode extends LogicalExprNode
{
    @Override
    public String toString()
    {
        return "NotEquals comparison";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}
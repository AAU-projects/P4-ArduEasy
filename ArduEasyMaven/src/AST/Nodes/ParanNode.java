package AST.Nodes;

import visitor.Visitor;

public class ParanNode extends ExpressionNode
{
    public ExpressionNode child;

    @Override
    public Object Accept(Visitor visitor)
    {
        return visitor.Visit(this);
    }
}

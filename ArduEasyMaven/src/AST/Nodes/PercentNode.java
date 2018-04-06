package AST.Nodes;

import visitor.Visitor;

public class PercentNode extends ExpressionNode
{
    public int Value;

    @Override
    public String toString()
    {
        return String.format("%d%s", Value, "%");
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

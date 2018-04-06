package AST.Nodes;

import visitor.Visitor;

public class FloatNode extends ExpressionNode
{
    public Float Value;

    @Override
    public String toString()
    {
        return String.valueOf(Value);
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

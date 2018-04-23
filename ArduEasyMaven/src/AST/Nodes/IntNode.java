package AST.Nodes;

import visitor.Visitor;

public class IntNode extends ValueNode
{
    public int Value;

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

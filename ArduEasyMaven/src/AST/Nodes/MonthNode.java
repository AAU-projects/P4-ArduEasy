package AST.Nodes;

import visitor.Visitor;

public class MonthNode extends ValueNode
{
    public String Value;

    @Override
    public String toString()
    {
        return Value;
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

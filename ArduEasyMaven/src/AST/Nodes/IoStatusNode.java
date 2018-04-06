package AST.Nodes;

import visitor.Visitor;

public class IoStatusNode extends Node
{
    public String Value;

    @Override
    public String toString()
    {
        return "Io Status";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

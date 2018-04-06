package AST.Nodes;

import visitor.Visitor;

public class ElseIfNode extends IfNode
{
    @Override
    public String toString()
    {
        return "else if";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

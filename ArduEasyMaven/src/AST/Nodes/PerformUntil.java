package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;

public class PerformUntil extends PerformNode
{
    @Override
    public String toString()
    {
        return "perform until";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

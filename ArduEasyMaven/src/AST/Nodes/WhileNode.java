package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;

public class WhileNode extends IterationNode
{
    @Override
    public String toString()
    {
        return "while";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

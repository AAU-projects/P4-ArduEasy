package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;

public class CaseNode extends Node
{
    public String Value;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();

    @Override
    public String toString()
    {
        return "Case";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

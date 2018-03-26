package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;

public class ElseNode extends IfOrElseNode
{
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();

    @Override
    public String toString()
    {
        return "else";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

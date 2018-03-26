package AST.Nodes;

import java.util.ArrayList;

public class ElseNode extends IfOrElseNode
{
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();

    @Override
    public String toString()
    {
        return "else";
    }
}

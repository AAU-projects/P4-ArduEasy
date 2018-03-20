package Nodes;
import jdk.jshell.StatementSnippet;

import java.util.ArrayList;

public class IfNode extends IfOrElseNode
{
    public LogicalExprNode Predicate;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();
    public IfOrElseNode Alternative;

    @Override
    public String toString()
    {
        return "If";
    }
}

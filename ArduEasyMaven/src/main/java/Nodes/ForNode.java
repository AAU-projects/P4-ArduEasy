package Nodes;

import java.util.ArrayList;

public abstract class ForNode extends StatementsNode
{
    public LogicalExprNode Predicate;
    public StatementsNode Increment;
    public ArrayList<StatementsNode> body = new ArrayList<StatementsNode>();

    @Override
    public String toString()
    {
        return "For-loop";
    }
}

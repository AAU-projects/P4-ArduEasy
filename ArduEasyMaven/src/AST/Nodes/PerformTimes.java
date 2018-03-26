package AST.Nodes;

import java.util.ArrayList;

public class PerformTimes extends PerformNode
{
    public ExpressionNode value;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();

    @Override
    public String toString()
    {
        return "perform times";
    }
}

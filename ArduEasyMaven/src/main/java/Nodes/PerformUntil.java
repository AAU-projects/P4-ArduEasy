package Nodes;
import java.util.ArrayList;

public class PerformUntil extends PerformNode
{
    public LogicalExprNode Predicate;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();

    @Override
    public String toString()
    {
        return "perform until";
    }
}

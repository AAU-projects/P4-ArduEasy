package Nodes;
import java.util.ArrayList;

public class PerformUntil extends PerformNode
{
    public ExpressionNode Predicate;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();

    @Override
    public String toString()
    {
        return "perform until";
    }
}

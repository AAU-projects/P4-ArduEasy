package AST.Nodes;

import java.util.ArrayList;

public class WhenNode extends FunctionsNode
{
    public ExpressionNode Predicate;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();

    @Override
    public String toString()
    {
        return "When";
    }

}

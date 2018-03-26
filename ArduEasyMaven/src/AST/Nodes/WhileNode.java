package AST.Nodes;

import java.util.ArrayList;

public class WhileNode extends StatementsNode
{
    public ExpressionNode Predicate;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();

    @Override
    public String toString()
    {
        return "while";
    }
}

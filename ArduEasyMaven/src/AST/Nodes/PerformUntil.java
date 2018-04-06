package AST.Nodes;

import visitor.Visitor;

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

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

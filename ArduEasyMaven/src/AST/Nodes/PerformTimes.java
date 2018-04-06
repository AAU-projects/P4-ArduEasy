package AST.Nodes;

import visitor.Visitor;

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

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }

}

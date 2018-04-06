package AST.Nodes;

import visitor.Visitor;

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

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }

}

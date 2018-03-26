package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;

public class IfNode extends StatementsNode
{
    public ExpressionNode Predicate;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();
    public IfOrElseNode Alternative;
    public ElseNode Else;

    @Override
    public String toString()
    {
        return "If";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

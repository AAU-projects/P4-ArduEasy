package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;

public class SwitchNode extends StatementsNode
{
    public ExpressionNode expression;
    public ArrayList<CaseNode> Body = new ArrayList<CaseNode>();
    public CaseNode defaultCase;

    @Override
    public String toString()
    {
        return "Switch";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

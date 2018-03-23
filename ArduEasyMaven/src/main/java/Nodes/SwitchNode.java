package Nodes;

import java.util.ArrayList;

public class SwitchNode extends StatementsNode
{
    public ExpressionNode expression;
    public ArrayList<CaseNode> Body = new ArrayList<CaseNode>();

    @Override
    public String toString() { return "Switch"; }
}

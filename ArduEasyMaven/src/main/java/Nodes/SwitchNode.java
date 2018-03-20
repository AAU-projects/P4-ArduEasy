package Nodes;

import java.util.ArrayList;

public class SwitchNode extends StatementsNode
{
    public IdentifierNode Identifer;
    public ArrayList<CaseNode> Body = new ArrayList<CaseNode>();

    @Override
    public String toString() { return "Switch"; }
}

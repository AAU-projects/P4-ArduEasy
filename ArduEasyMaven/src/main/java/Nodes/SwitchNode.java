package Nodes;

import java.util.ArrayList;

public class SwitchNode extends Node
{
    public IdentifierNode Identifer;
    public ArrayList<StatementsNode> body = new ArrayList<StatementsNode>();

    @Override
    public String toString() { return "Switch"; }
}

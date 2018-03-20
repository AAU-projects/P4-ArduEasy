package Nodes;

import java.util.ArrayList;

public class CaseNode extends Node
{
    public String Value;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();

    @Override
    public String toString() { return "Case"; }
}

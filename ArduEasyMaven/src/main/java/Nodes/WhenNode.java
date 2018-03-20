package Nodes;

import java.util.ArrayList;

public class WhenNode {
    public LogicalExprNode Predicate;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();

    @Override
    public String toString() {return "When"; }

}

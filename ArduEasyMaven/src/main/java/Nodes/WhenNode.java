package Nodes;

import java.util.ArrayList;

public class WhenNode extends FunctionsNode{
    public LogicalExprNode Predicate;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();

    @Override
    public String toString() {return "When"; }

}

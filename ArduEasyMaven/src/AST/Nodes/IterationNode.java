package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;

public abstract class IterationNode extends StatementsNode
{
    public ExpressionNode Predicate;
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();
}

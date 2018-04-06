package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;

public class ForNode extends StatementsNode
{
    public ExpressionNode Predicate;
    public AssignmentNode Increment;
    public DefinitionNode Var;
    public ArrayList<StatementsNode> body = new ArrayList<StatementsNode>();

    @Override
    public String toString()
    {
        return "For-loop";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

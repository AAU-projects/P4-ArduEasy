package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;

public class MethodCallNode extends ExpressionNode {
    public IdentifierNode identifier;
    public ArrayList<ExpressionNode> expressions;

    @Override
    public String toString()
    {
        return "MethodCall";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

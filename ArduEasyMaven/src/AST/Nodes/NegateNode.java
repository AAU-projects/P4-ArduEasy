package AST.Nodes;

import visitor.Visitor;

public class NegateNode extends ExpressionNode
{
    public ExpressionNode child;

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

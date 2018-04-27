package AST.Nodes;

import visitor.Visitor;

public class NegateNode extends ValueNode
{
    public ExpressionNode child;

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

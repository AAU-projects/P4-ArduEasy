package AST.Nodes;

import visitor.Visitor;

public class BelowAndEqualNode extends LogicalExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "BelowAndEqual comparison";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}
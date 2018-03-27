package AST.Nodes;

import visitor.Visitor;

public class GreaterAndEqualNode extends LogicalExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "GreaterAndEqual comparison";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}
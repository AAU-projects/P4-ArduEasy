package Nodes;

public class BelowAndEqualNode extends LogicalExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "BelowAndEqual comparison";
    }
}
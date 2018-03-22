package Nodes;

public class BelowOrEqualNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "BelowOrEqual comparison";
    }
}
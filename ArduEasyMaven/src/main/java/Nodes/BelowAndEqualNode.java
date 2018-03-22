package Nodes;

public class BelowAndEqualNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "BelowAndEqual comparison";
    }
}
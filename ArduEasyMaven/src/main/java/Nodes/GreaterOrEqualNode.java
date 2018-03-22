package Nodes;

public class GreaterOrEqualNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "GreaterOrEqual comparison";
    }
}
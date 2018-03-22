package Nodes;

public class GreaterAndEqualNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "GreaterAndEqual comparison";
    }
}
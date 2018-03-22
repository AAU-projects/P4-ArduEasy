package Nodes;

public class GreaterThanNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "GreaterThan comparison";
    }
}
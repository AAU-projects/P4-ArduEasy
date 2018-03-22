package Nodes;

public class LessThanNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "LessThan comparison";
    }
}
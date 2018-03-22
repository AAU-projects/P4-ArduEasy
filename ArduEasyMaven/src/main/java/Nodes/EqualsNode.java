package Nodes;

public class EqualsNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "Equal comparison";
    }
}
package Nodes;

public class NotEqualsNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "NotEquals comparison";
    }
}
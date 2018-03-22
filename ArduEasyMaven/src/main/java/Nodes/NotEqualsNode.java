package Nodes;

public class NotEqualsNode extends LogicalExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "NotEquals comparison";
    }
}
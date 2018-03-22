package Nodes;

public class GreaterThanNode extends LogicalExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "GreaterThan comparison";
    }
}
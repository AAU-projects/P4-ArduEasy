package Nodes;

public class LessThanNode extends LogicalExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "LessThan comparison";
    }
}
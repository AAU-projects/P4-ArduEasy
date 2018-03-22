package Nodes;

public class LogicalOrNode extends LogicalExprNode
{
    LogicalExprNode LeftChild;
    LogicalExprNode RightChild;

    @Override
    public String toString()
        {
        return "or";
        }
}
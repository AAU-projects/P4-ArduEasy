package Nodes;

public class LogicalOrNode extends LogicalExprNode
{
    public LogicalExprNode LeftChild;
    public LogicalExprNode RightChild;

    @Override
    public String toString()
        {
        return "or";
        }
}
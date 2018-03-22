package Nodes;

public class LogicalAndNode extends LogicalExprNode
{
    LogicalExprNode LeftChild;
    LogicalExprNode RightChild;

    @Override
    public String toString()
        {
        return "and";
        }
}

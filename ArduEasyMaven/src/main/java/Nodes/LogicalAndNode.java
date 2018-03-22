package Nodes;

public class LogicalAndNode extends LogicalExprNode
{
    public LogicalExprNode LeftChild;
    public LogicalExprNode RightChild;

    @Override
    public String toString()
        {
        return "and";
        }
}

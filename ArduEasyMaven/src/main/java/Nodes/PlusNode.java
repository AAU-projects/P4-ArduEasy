package Nodes;

public class PlusNode extends ExpressionNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "plus";
    }
}

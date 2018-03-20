package Nodes;

public class DivisionNode extends ExpressionNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "division";
    }
}

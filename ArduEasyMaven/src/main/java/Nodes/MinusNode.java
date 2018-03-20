package Nodes;

public class MinusNode extends ExpressionNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "minus";
    }
}

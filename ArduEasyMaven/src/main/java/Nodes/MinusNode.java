package Nodes;

public class MinusNode extends Node
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "minus";
    }
}
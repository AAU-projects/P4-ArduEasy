package Nodes;

public class DivisionNode extends Node
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "division";
    }
}

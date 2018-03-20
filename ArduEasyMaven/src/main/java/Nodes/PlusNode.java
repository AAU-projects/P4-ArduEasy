package Nodes;

public class PlusNode extends Node
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "plus";
    }
}

package Nodes;

public class TimesNode extends Node
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "times";
    }
}

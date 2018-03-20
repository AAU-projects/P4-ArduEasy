package Nodes;

public class TimesNode extends ExpressionNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "times";
    }
}

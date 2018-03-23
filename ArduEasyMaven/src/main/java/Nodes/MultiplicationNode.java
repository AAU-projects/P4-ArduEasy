package Nodes;

public class MultiplicationNode extends ArithmeticExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "multiplication";
    }
}

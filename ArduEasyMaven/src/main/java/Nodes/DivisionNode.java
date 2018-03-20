package Nodes;

public class DivisionNode extends ArithmeticExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "division";
    }
}

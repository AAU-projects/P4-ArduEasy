package AST.Nodes;

public class BelowOrEqualNode extends LogicalExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "BelowOrEqual comparison";
    }
}
package AST.Nodes;

import visitor.Visitor;

public class AdditiveNode extends ArithmeticExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "plus";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

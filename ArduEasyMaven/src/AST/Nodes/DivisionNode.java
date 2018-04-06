package AST.Nodes;

import visitor.Visitor;

public class DivisionNode extends ArithmeticExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "division";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

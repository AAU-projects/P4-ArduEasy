package AST.Nodes;

import visitor.Visitor;

public class MultiplicationNode extends ArithmeticExprNode
{
    public ExpressionNode LeftChild;
    public ExpressionNode RightChild;

    @Override
    public String toString()
    {
        return "multiplication";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

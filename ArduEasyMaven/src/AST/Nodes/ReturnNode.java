package AST.Nodes;

import visitor.Visitor;

public class ReturnNode extends Node
{
    public ExpressionNode Value;

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

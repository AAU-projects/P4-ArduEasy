package AST.Nodes;

import visitor.Visitor;

public class ParameterNode extends Node
{
    public String Type;
    public IdentifierNode Identifier;

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

package AST.Nodes;

import visitor.Visitor;

public class DeclarationNode extends DefinitionNode
{
    public String Type;
    public ExpressionNode Value;

    @Override
    public String toString()
    {
        return "Declaration";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

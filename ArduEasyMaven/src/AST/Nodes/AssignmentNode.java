package AST.Nodes;

import visitor.Visitor;

public class AssignmentNode extends DefinitionNode
{
    public IdentifierNode Identifier;
    public ExpressionNode Value;

    @Override
    public String toString()
    {
        return "Assignment";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

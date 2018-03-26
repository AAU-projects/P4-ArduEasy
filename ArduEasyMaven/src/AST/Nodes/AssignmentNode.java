package AST.Nodes;

public class AssignmentNode extends DefinitionNode
{
    public IdentifierNode Identifier;
    public ExpressionNode Value;

    @Override
    public String toString()
    {
        return "Assignment";
    }
}

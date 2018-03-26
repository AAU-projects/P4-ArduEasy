package AST.Nodes;

public class DeclarationNode extends DefinitionNode
{
    public String Type;
    public IdentifierNode Identifier;
    public ExpressionNode Value;

    @Override
    public String toString()
    {
        return "Declaration";
    }
}

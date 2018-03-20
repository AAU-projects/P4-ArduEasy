package Nodes;

public class DeclarationNode extends DefinitionNode
{
    public String Type;
    public IdentifierNode Identifier;
    public String Value;

    @Override
    public String toString()
    {
        return "Declaration";
    }
}

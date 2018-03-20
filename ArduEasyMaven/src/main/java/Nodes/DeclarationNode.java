package Nodes;

public class DeclarationNode extends Node
{
    public String Type;
    public IdentifierNode Identifier;
    public String Value;

    @Override
    public String toString()
    {
        return "Decleration";
    }
}

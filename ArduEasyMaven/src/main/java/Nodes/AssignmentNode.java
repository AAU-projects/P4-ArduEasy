package Nodes;

public class AssignmentNode extends DefinitionNode
{
    public IdentifierNode Identifier;
    public String Value;

    @Override
    public String toString() {
        return "Assignment";
    }
}

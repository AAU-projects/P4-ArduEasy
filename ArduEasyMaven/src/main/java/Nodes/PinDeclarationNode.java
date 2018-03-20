package Nodes;

public class PinDeclarationNode extends DefinitionNode{
    public IdentifierNode Identifier;
    public PinNode Pin;
    public IoStatusNode IoStatus;

    @Override
    public String toString() {
        return "PinDeclaration";
    }
}

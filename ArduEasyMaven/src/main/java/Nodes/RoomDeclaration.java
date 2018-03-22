package Nodes;

import java.util.ArrayList;

public class RoomDeclaration extends DefinitionNode
{
    public IdentifierNode Identifier;
    public ArrayList<RoomBlockNode> body = new ArrayList<RoomBlockNode>();

}

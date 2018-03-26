package AST.Nodes;

import java.util.ArrayList;
import java.util.List;

public class RoomDeclaration extends DefinitionNode
{
    public IdentifierNode Identifier;
    public List<RoomBlockNode> body = new ArrayList<RoomBlockNode>();

}

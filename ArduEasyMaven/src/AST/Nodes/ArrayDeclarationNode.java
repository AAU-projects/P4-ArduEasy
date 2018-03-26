package AST.Nodes;

import java.util.ArrayList;
import java.util.List;

public class ArrayDeclarationNode extends Node implements RoomBlockNode
{
    public IdentifierNode Identifier;
    public List<IdentifierNode> Values = new ArrayList<IdentifierNode>();

    @Override
    public String toString()
    {
        return "Array Declaration";
    }
}

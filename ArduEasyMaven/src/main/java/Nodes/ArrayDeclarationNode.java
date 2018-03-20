package Nodes;

import java.util.ArrayList;

public class ArrayDeclarationNode extends Node implements RoomBlockNode
{
    public IdentifierNode Identifier;
    public ArrayList<IdentifierNode> Values = new ArrayList<IdentifierNode>();

    @Override
    public String toString() {
        return "Array Declaration";
    }
}

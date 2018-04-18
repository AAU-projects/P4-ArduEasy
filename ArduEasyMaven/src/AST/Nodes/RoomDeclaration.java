package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class RoomDeclaration extends DefinitionNode
{
    public List<RoomBlockNode> body = new ArrayList<RoomBlockNode>();

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }

}

package AST.Nodes;

import visitor.Visitor;

public interface RoomBlockNode
{
    Object Accept(Visitor visitor);
}

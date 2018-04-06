package AST.Nodes;
import visitor.*;

public abstract class Node
{
    public abstract Object Accept(Visitor visitor);
}
package AST.Nodes;
import visitor.*;

public abstract class Node
{
    public int LineNumber;
    public abstract Object Accept(Visitor visitor);
}
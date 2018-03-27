package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;

public class RootNode extends Node
{
    public SetupNode Setup;
    public ArrayList<FunctionsNode> Functions = new ArrayList<FunctionsNode>();

    @Override
    public String toString()
    {
        return "Root";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }

}

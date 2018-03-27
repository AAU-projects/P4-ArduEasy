package AST.Nodes;

import visitor.Visitor;

import java.util.ArrayList;

public class SetupNode extends Node
{
    public ArrayList<DefinitionNode> Childs = new ArrayList<DefinitionNode>();

    @Override
    public String toString()
    {
        return "home";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

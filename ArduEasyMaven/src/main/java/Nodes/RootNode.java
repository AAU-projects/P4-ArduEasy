package Nodes;

import java.util.ArrayList;

public class RootNode extends Node
{
    protected SetupNode Home;
    public ArrayList<FunctionsNode> Functions = new ArrayList<FunctionsNode>();

    @Override
    public String toString() {
        return "Root";
    }
}

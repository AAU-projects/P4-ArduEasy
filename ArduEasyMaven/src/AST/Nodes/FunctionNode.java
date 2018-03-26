package AST.Nodes;

import java.util.ArrayList;

public class FunctionNode extends FunctionsNode
{
    public String ReturnType;
    public IdentifierNode Identifier;
    public ArrayList<ParameterNode> Parameters = new ArrayList<ParameterNode>();
    public ArrayList<StatementsNode> Body = new ArrayList<StatementsNode>();
    public ReturnNode Return;
}

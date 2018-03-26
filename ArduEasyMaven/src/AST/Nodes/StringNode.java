package AST.Nodes;

public class StringNode extends ExpressionNode
{
    public String Value;

    @Override
    public String toString()
    {
        return Value;
    }
}

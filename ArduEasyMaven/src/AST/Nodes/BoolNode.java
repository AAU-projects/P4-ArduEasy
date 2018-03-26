package AST.Nodes;

public class BoolNode extends ExpressionNode
{
    public Boolean Value;

    @Override
    public String toString()
    {
        return String.valueOf(Value);
    }
}
package Nodes;


public class IdentifierNode extends ExpressionNode
{
    public String Value;

    @Override
    public String toString() {
        return Value;
    }
}

package Nodes;

public class IntNode extends ExpressionNode
{
    public int Value;

    @Override
    public String toString() {
        return String.valueOf(Value);
    }
}

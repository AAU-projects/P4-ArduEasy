package Nodes;

public class FloatNode extends ExpressionNode
{
    public Float Value;

    @Override
    public String toString() {
        return String.valueOf(Value);
    }
}

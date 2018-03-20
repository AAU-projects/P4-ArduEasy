package Nodes;

public class PercentNode extends ExpressionNode
{
    public int Value;

    @Override
    public String toString() {
        return String.format("%d%s",Value,"%");
    }
}

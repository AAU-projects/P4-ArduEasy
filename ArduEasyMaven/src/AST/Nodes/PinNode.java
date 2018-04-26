package AST.Nodes;

public abstract class PinNode extends Node
{
    public int Value;
    public String Type;

    @Override
    public String toString()
    {
        return "Pin";
    }


}
package AST.Nodes;

import visitor.Visitor;

public class AnalogPinNode extends PinNode
{
    @Override
    public String toString()
    {
        return "Analog Pin";
    }

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

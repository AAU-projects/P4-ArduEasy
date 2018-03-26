package AST.Nodes;

import visitor.Visitor;

public class DigitalPinNode extends PinNode
{
    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

package AST.Nodes;

import visitor.Visitor;

public class ForNodeAssign extends ForNode
{
    public AssignmentNode Var;

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

package AST.Nodes;

import visitor.Visitor;

public class ForNodeDecl extends ForNode
{
    public DeclarationNode Var;

    @Override
    public Object Accept(Visitor visitor) {
        return visitor.Visit(this);
    }
}

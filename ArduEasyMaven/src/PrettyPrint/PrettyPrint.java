package PrettyPrint;

import AST.Nodes.*;
import visitor.Visitor;

public class PrettyPrint implements Visitor
{
    private int tabsIndent = 0; // increase or decrease this int to indend the code
    //tabindent should increase after {
    //tabindent should decrease before }
    //first printIndent and then system.out.print or printIndentln to print

    @Override
    public Object Visit(AdditiveNode node) {
        node.LeftChild.Accept(this);
        System.out.print("+");
        node.RightChild.Accept(this);
        return null;
    }

    @Override
    public Object Visit(AnalogPinNode node) {
        System.out.print("A ");
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(ArrayDeclarationNode node) {
        printIndentln("ArrayDeclaration {"); // TODO
        tabsIndent++;

        node.Identifier.Accept(this);

        for (IdentifierNode identifier : node.Values )
        {
            System.out.println();
            identifier.Accept(this);
        }
        tabsIndent--;
        printIndent("}");

        return null;
    }

    @Override
    public Object Visit(AssignmentNode node) {
        printIndentln("Assigment {");
        tabsIndent++;

        node.Identifier.Accept(this);
        System.out.print(" = ");
        node.Value.Accept(this); //TODO prints dot notations?

        tabsIndent--;
        printIndentln("}");
        return null;
    }

    @Override
    public Object Visit(BoolNode node) {
        System.out.print(node.Value); // just print ???
        return null;
    }

    @Override
    public Object Visit(CaseNode node) {
        printIndent("case ");
        System.out.print(node.Value);
        System.out.print(":");

        for (StatementsNode Statement : node.Body )
        {
            System.out.println();
            Statement.Accept(this);
        }

        return null;

    }

    @Override
    public Object Visit(DayNode node) {
        System.out.print(node.Value); // just print ???
        return null;
    }

    @Override
    public Object Visit(DeclarationNode node) {
        printIndentln("Declaration {");
        tabsIndent++;

        printIndent(node.Type + " ");
        node.Identifier.Accept(this);
        System.out.print(" = ");
        node.Value.Accept(this);

        System.out.print("\n");

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(DigitalPinNode node) {
        System.out.print(node.Value); // TODO missing a infront?
        return null;
    }

    @Override
    public Object Visit(DivisionNode node) {
        node.LeftChild.Accept(this);
        System.out.print("/");
        node.RightChild.Accept(this);
        return null;
    }

    @Override
    public Object Visit(ElseIfNode node) {
        printIndent("else if (");
        node.Predicate.Accept(this);
        System.out.println(")");
        printIndentln("{ ");
        tabsIndent++;

        for (StatementsNode Statement : node.Body )
        {
            Statement.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        node.Alternative.Accept(this);

        return null;
    }

    @Override
    public Object Visit(ElseNode node) {
        printIndentln("else");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode Statement : node.Body )
        {
            Statement.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(EqualsNode node) {
        node.Left.Accept(this);
        System.out.print("==");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(FloatNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(ForNodeAssign node) {
        printIndent("For (");
        node.Var.Accept(this);
        System.out.print("; ");
        node.Predicate.Accept(this);
        System.out.print("; ");
        node.Increment.Accept(this);
        printIndentln(")");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode Statement : node.body )
        {
            Statement.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(ForNodeDecl node) {
        printIndent("For (");
        node.Var.Accept(this);
        System.out.print("; ");
        node.Predicate.Accept(this);
        System.out.print("; ");
        node.Increment.Accept(this);
        printIndentln(")");
        printIndentln("{");
        for (StatementsNode Statement : node.body )
        {
            Statement.Accept(this);
        }
        printIndentln("} ");

        return null;
    }

    @Override
    public Object Visit(FunctionNode node) {
        printIndent("function ");
        System.out.print(node.ReturnType + " ");
        node.Identifier.Accept(this);
        System.out.print("(");

        int parametersCounter = 0;
        for (ParameterNode parameter : node.Parameters)
        {
            if (parametersCounter++ != node.Parameters.size() - 1)
            {
                parameter.Accept(this);
                System.out.print(", " );
            }
            else
            {
                parameter.Accept(this);
            }
        }
        printIndentln(")" );
        printIndentln("{" );
        tabsIndent++;

        for (StatementsNode Statement : node.Body )
        {
            Statement.Accept(this);
        }

        if (node.Return != null) // return can be null if function is void
        {
            node.Return.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(GreaterOrEqualNode node) {
        node.Left.Accept(this);
        System.out.print(">=");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(GreaterThanNode node) {
        node.Left.Accept(this);
        System.out.print(">");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(IdentifierNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(IfNode node) {
        printIndent("if(");
        node.Predicate.Accept(this);
        System.out.println(")");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode Statement : node.Body )
        {
            Statement.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        if (node.Alternative != null) // only accept if there is another else or else if node
        {
            node.Alternative.Accept(this);
        }



        return null;
    }

    @Override
    public Object Visit(IfOrElseNode node) {
        //TODO dont know what to do with this :)
        return null;
    }

    @Override
    public Object Visit(IntNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(IoStatusNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(LessOrEqualNode node) {
        node.Left.Accept(this);
        System.out.print("<=");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(LessThanNode node) {
        node.Left.Accept(this);
        System.out.print("<");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(LogicalAndNode node) {
        node.Left.Accept(this);
        System.out.print("&&");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(LogicalOrNode node) {
        node.Left.Accept(this);
        System.out.print("||");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(MonthNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(MultiplicationNode node) {
        node.LeftChild.Accept(this);
        System.out.print("*");
        node.RightChild.Accept(this);
        return null;
    }

    @Override
    public Object Visit(NegateNode node) {
        System.out.print("!" + node.child.toString());
        return null;
    }

    @Override
    public Object Visit(NotEqualsNode node) {
        node.Left.Accept(this);
        System.out.print("!=");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(ParameterNode node) {
        System.out.print(node.Type + " ");
        node.Identifier.Accept(this);

        return null;
    }

    @Override
    public Object Visit(PercentNode node) {
        System.out.print(node.toString());

        return null;
    }

    @Override
    public Object Visit(PerformTimes node) {
        printIndent("Perform (");
        node.value.Accept(this);
        System.out.print(") times");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");
        return null;
    }

    @Override
    public Object Visit(PerformUntil node) {
        printIndent("Perform until (");
        node.Predicate.Accept(this);
        printIndentln(") {");
        tabsIndent++;

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(PinDeclarationNode node) {
        printIndentln("PinDeclartion {");
        tabsIndent++;

        node.Identifier.Accept(this);
        node.Pin.Accept(this);
        node.IoStatus.Accept(this);

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(ReturnNode node) {
        printIndent("return ");
        System.out.print(node.Value.toString());

        return null;
    }

    @Override
    public Object Visit(RoomDeclaration node) {
        printIndentln("RoomDeclaration {");
        tabsIndent++;

        node.Identifier.Accept(this);

        for (RoomBlockNode RoomBlock : node.body )
        {
            System.out.println();
            RoomBlock.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(RootNode node) {
        printIndentln("Root {");
        tabsIndent++;
        node.Setup.Accept(this);

        for (FunctionsNode function : node.Functions )
        {
            System.out.println();
            function.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");
        return null;
    }

    @Override
    public Object Visit(SetupNode node) {
        printIndentln("Setup {");
        tabsIndent++;
        for (DefinitionNode definition : node.Childs )
        {
            System.out.println();
            definition.Accept(this);
        }
        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(StringNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(SubtractiveNode node) {
        node.LeftChild.Accept(this);
        System.out.print("-");
        node.RightChild.Accept(this);
        return null;
    }

    @Override
    public Object Visit(SwitchNode node) {
        printIndent("Switch: (");
        node.expression.Accept(this);
        printIndentln(") {");
        tabsIndent++;

        for (CaseNode caseN: node.Body)
        {
            caseN.Accept(this);
        }

        node.defaultCase.Accept(this);

        tabsIndent--;
        printIndentln("}");
        return null;
    }

    @Override
    public Object Visit(TimeNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(WhenNode node) {
        printIndent("When (");
        node.Predicate.Accept(this);
        printIndentln(") {");
        tabsIndent++;

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(WhileNode node) {
        printIndent("While (");
        node.Predicate.Accept(this);
        printIndentln(") {");
        tabsIndent++;

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(HouseNode node)
    {
        return null;
    }

    private void Indent(int tabs)
    {
        for (int i = 0; i < tabs; i++){
            System.out.print("\t");
        }
    }

    private void printIndent(Object print)
    {
        Indent(tabsIndent);
        System.out.print(print);
    }

    private void printIndentln(Object print)
    {
        Indent(tabsIndent);
        System.out.println(print);
    }
}

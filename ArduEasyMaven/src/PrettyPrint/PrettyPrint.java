package PrettyPrint;

import AST.Nodes.*;
import visitor.Visitor;

public class PrettyPrint implements Visitor
{
    private int tab = 0;


    @Override
    public Object Visit(AdditiveNode node) {
        node.LeftChild.Accept(this);
        System.out.print("+");
        node.RightChild.Accept(this);
        return null;
    }

    @Override
    public Object Visit(AnalogPinNode node) {
        System.out.println("AnalogPin {");

        System.out.println(node.Value); // missing a infront?

        System.out.println("}");
        return null;
    }

    @Override
    public Object Visit(ArrayDeclarationNode node) {
        System.out.println("ArrayDeclaration {"); // TODO

        node.Identifier.Accept(this);

        for (IdentifierNode identifier : node.Values )
        {
            System.out.println();
            identifier.Accept(this);
        }
        System.out.println("}");

        return null;
    }

    @Override
    public Object Visit(AssignmentNode node) {
        System.out.println("Assigment {");

        node.Identifier.Accept(this);
        node.Value.Accept(this);

        System.out.println("}");
        return null;
    }

    @Override
    public Object Visit(BoolNode node) {
        System.out.println(node.Value); // just print ???

        return null;
    }

    @Override
    public Object Visit(CaseNode node) {
        System.out.print("case ");
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
        System.out.println(node.Value); // just print ???
        return null;
    }

    @Override
    public Object Visit(DeclarationNode node) {
        System.out.println("Declaration {");

        System.out.println(node.Type);
        node.Identifier.Accept(this);
        node.Value.Accept(this);
        System.out.println("}");

        return null;
    }

    @Override
    public Object Visit(DigitalPinNode node) {
        System.out.println("DigitalPin {");

        System.out.println(node.Value); // missing a infront?

        System.out.println("}");
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
        System.out.println("else if (");
        node.Predicate.Accept(this)
        System.out.println(")");
        System.out.println("{ ");

        for (StatementsNode Statement : node.Body )
        {
            Statement.Accept(this);
        }

        System.out.println("}");

        node.Alternative.Accept(this);

        return null;
    }

    @Override
    public Object Visit(ElseNode node) {
        System.out.println("else");
        System.out.println("{");

        for (StatementsNode Statement : node.Body )
        {
            Statement.Accept(this);
        }

        System.out.println("}");

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
        System.out.print("For (");
        node.Var.Accept(this);
        System.out.print("; ");
        node.Predicate.Accept(this);
        System.out.print("; ");
        node.Increment.Accept(this);
        System.out.println(")");
        System.out.print("{");
        for (StatementsNode Statement : node.body )
        {
            Statement.Accept(this);
        }
        System.out.print("}");

        return null;
    }

    @Override
    public Object Visit(ForNodeDecl node) {

        System.out.print("For (");
        node.Var.Accept(this);
        System.out.print("; ");
        node.Predicate.Accept(this);
        System.out.print("; ");
        node.Increment.Accept(this);
        System.out.println(")");
        System.out.print("{");
        for (StatementsNode Statement : node.body )
        {
            Statement.Accept(this);
        }
        System.out.print("} ");

        return null;
    }

    @Override
    public Object Visit(FunctionNode node) {
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
        return null;
    }

    @Override
    public Object Visit(IfNode node) {
        return null;
    }

    @Override
    public Object Visit(IfOrElseNode node) {
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
        return null;
    }

    @Override
    public Object Visit(LessThanNode node) {
        return null;
    }

    @Override
    public Object Visit(LogicalAndNode node) {
        return null;
    }

    @Override
    public Object Visit(LogicalOrNode node) {
        return null;
    }

    @Override
    public Object Visit(MonthNode node) {
        return null;
    }

    @Override
    public Object Visit(MultiplicationNode node) {
        return null;
    }

    @Override
    public Object Visit(NegateNode node) {
        return null;
    }

    @Override
    public Object Visit(NotEqualsNode node) {
        return null;
    }

    @Override
    public Object Visit(ParameterNode node) {
        return null;
    }

    @Override
    public Object Visit(PercentNode node) {
        System.out.print(node.toString());

        return null;
    }

    @Override
    public Object Visit(PerformTimes node) {
        System.out.print("Perform (");
        node.value.Accept(this);
        System.out.println(") times {");

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        System.out.println("}");
        return null;
    }

    @Override
    public Object Visit(PerformUntil node) {
        System.out.print("Perform until (");
        node.Predicate.Accept(this);
        System.out.println(") {");

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        System.out.println("}");

        return null;
    }

    @Override
    public Object Visit(PinDeclarationNode node) {
        System.out.println("PinDeclartion {");

        node.Identifier.Accept(this);
        node.Pin.Accept(this);
        node.IoStatus.Accept(this);

        System.out.println("}");

        return null;
    }

    @Override
    public Object Visit(ReturnNode node) {


        return null;
    }

    @Override
    public Object Visit(RoomDeclaration node) {
        System.out.println("RoomDeclaration {");

        node.Identifier.Accept(this);

        for (RoomBlockNode RoomBlock : node.body )
        {
            System.out.println();
            RoomBlock.Accept(this);
        }

        System.out.println("}");

        return null;
    }

    @Override
    public Object Visit(RootNode node) {
        System.out.println("Root {");
        node.Setup.Accept(this);

        for (FunctionsNode function : node.Functions )
        {
            System.out.println();
            function.Accept(this);
        }

        System.out.println("}");
        return null;
    }

    @Override
    public Object Visit(SetupNode node) {
        System.out.println("Setup {");

        for (DefinitionNode definition : node.Childs )
        {
            System.out.println();
            definition.Accept(this);
        }
        System.out.println("}");

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
        System.out.print(" - ");
        node.RightChild.Accept(this);
        return null;
    }

    @Override
    public Object Visit(SwitchNode node) {
        System.out.print("Switch: (");
        node.expression.Accept(this);
        System.out.println(") {");

        for (CaseNode caseN: node.Body)
        {
            caseN.Accept(this);
        }

        node.defaultCase.Accept(this);
        System.out.println("}");
        return null;
    }

    @Override
    public Object Visit(TimeNode node) {
        System.out.print(node.Value);

        return null;
    }

    @Override
    public Object Visit(WhenNode node) {
        System.out.print("When (");
        node.Predicate.Accept(this);
        System.out.println(") {");

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        System.out.println("}");

        return null;
    }

    @Override
    public Object Visit(WhileNode node) {
        System.out.print("While (");
        node.Predicate.Accept(this);
        System.out.println(") {");

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        System.out.println("}");

        return null;
    }

    @Override
    public Object Visit(HouseNode node)
    {
        return null;
    }
}

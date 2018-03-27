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
        return null;
    }

    @Override
    public Object Visit(ArrayDeclarationNode node) {
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
        return null;
    }

    @Override
    public Object Visit(CaseNode node) {
        return null;
    }

    @Override
    public Object Visit(DayNode node) {
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
        return null;
    }

    @Override
    public Object Visit(DivisionNode node) {
        return null;
    }

    @Override
    public Object Visit(ElseIfNode node) {
        return null;
    }

    @Override
    public Object Visit(ElseNode node) {
        return null;
    }

    @Override
    public Object Visit(EqualsNode node) {
        return null;
    }

    @Override
    public Object Visit(FloatNode node) {
        return null;
    }

    @Override
    public Object Visit(ForNodeAssign node) {
        return null;
    }

    @Override
    public Object Visit(ForNodeDecl node) {
        return null;
    }

    @Override
    public Object Visit(FunctionNode node) {
        return null;
    }

    @Override
    public Object Visit(GreaterOrEqualNode node) {
        return null;
    }

    @Override
    public Object Visit(GreaterThanNode node) {
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
        return null;
    }

    @Override
    public Object Visit(IoStatusNode node) {
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

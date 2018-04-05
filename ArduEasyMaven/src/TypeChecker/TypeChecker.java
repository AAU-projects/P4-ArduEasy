package TypeChecker;

import AST.Nodes.*;
import visitor.Visitor;

public class TypeChecker implements Visitor {

    @Override
    public Object Visit(AdditiveNode node) {
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
        return null;
    }

    @Override
    public Object Visit(BoolNode node) {
        return "bool";
    }

    @Override
    public Object Visit(CaseNode node) {
        return null;
    }

    @Override
    public Object Visit(DayNode node) {
        return "day";
    }

    @Override
    public Object Visit(DeclarationNode node) {
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
        return "float";
    }

    @Override
    public Object Visit(ForNode node) {
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
        return "int";
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
        return null;
    }

    @Override
    public Object Visit(PerformTimes node) {
        return null;
    }

    @Override
    public Object Visit(PerformUntil node) {
        return null;
    }

    @Override
    public Object Visit(PinDeclarationNode node) {
        return null;
    }

    @Override
    public Object Visit(ReturnNode node) {
        return null;
    }

    @Override
    public Object Visit(RoomDeclaration node) {
        return null;
    }

    @Override
    public Object Visit(RootNode node) {
        return null;
    }

    @Override
    public Object Visit(SetupNode node) {
        return null;
    }

    @Override
    public Object Visit(StringNode node) {
        return null;
    }

    @Override
    public Object Visit(SubtractiveNode node) {
        return null;
    }

    @Override
    public Object Visit(SwitchNode node) {
        return null;
    }

    @Override
    public Object Visit(TimeNode node) {
        return null;
    }

    @Override
    public Object Visit(WhenNode node) {
        return null;
    }

    @Override
    public Object Visit(WhileNode node) {
        return null;
    }

    @Override
    public Object Visit(HouseNode node) {
        return null;
    }

    @Override
    public Object Visit(MethodCallNode node) {
        return null;
    }
}

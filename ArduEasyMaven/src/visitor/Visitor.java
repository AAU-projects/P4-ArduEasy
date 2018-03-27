package visitor;

import AST.Nodes.*;

public interface Visitor
{
    Object Visit(AdditiveNode node);
    Object Visit(AnalogPinNode node);
    Object Visit(ArrayDeclarationNode node);
    Object Visit(AssignmentNode node);
    Object Visit(BelowAndEqualNode node);
    Object Visit(BelowOrEqualNode node);
    Object Visit(BoolNode node);
    Object Visit(CaseNode node);
    Object Visit(DayNode node);
    Object Visit(DeclarationNode node);
    Object Visit(DigitalPinNode node);
    Object Visit(DivisionNode node);
    Object Visit(ElseIfNode node);
    Object Visit(ElseNode node);
    Object Visit(EqualsNode node);
    Object Visit(FloatNode node);
    Object Visit(ForNodeAssign node);
    Object Visit(ForNodeDecl node);
    Object Visit(FunctionNode node);
    Object Visit(GreaterAndEqualNode node);
    Object Visit(GreaterOrEqualNode node);
    Object Visit(GreaterThanNode node);
    Object Visit(IdentifierNode node);
    Object Visit(IfNode node);
    Object Visit(IfOrElseNode node);
    Object Visit(IntNode node);
    Object Visit(IoStatusNode node);
    Object Visit(LessOrEqualNode node);
    Object Visit(LessThanNode node);
    Object Visit(LogicalAndNode node);
    Object Visit(LogicalOrNode node);
    Object Visit(MonthNode node);
    Object Visit(MultiplicationNode node);
    Object Visit(NegateNode node);
    Object Visit(NotEqualsNode node);
    Object Visit(ParameterNode node);
    Object Visit(PercentNode node);
    Object Visit(PerformTimes node);
    Object Visit(PerformUntil node);
    Object Visit(PinDeclarationNode node);
    Object Visit(ReturnNode node);
    Object Visit(RoomDeclaration node);
    Object Visit(RootNode node);
    Object Visit(SetupNode node);
    Object Visit(StringNode node);
    Object Visit(SubtractiveNode node);
    Object Visit(SwitchNode node);
    Object Visit(TimeNode node);
    Object Visit(WhenNode node);
    Object Visit(WhileNode node);
}

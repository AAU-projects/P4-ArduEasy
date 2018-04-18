package TypeChecker;

import AST.Nodes.*;
import ErrorHandler.ErrorHandler;
import ErrorHandler.Errors.SemanticError;
import SymbolTable.SymbolTable;
import visitor.Visitor;

import java.util.Arrays;

public class TypeChecker implements Visitor
{
    String[] ArithmeticTypes = {"int", "float", "percent", "time"};
    private SymbolTable symbolTable;
    private int idx = 0;

    public TypeChecker(SymbolTable table)
    {
        symbolTable = table;
    }

    public boolean IsNumber(Node node)
    {
        return false;
    }

    @Override
    public Object Visit(AdditiveNode node)
    {
        ExpressionNode left = (ExpressionNode)node.LeftChild.Accept(this);
        String leftType = TypeOfNode(left);
        ExpressionNode right = (ExpressionNode)node.RightChild.Accept(this);
        String rightType = TypeOfNode(right);

        boolean matchFound = Arrays.asList(ArithmeticTypes).contains(leftType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to add invalid type " + leftType));

        matchFound = Arrays.asList(ArithmeticTypes).contains(rightType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to add invalid type " + rightType));

        if(!(leftType.equals("int") && rightType.equals("float")) && !(leftType.equals("float") && rightType.equals("int")) && !leftType.equals(rightType))
            ErrorHandler.AddError(new SemanticError(node, "Tried to add " + leftType + " with a  " + rightType));

        if(leftType.equals("int") && rightType.equals("float"))
            return right;
        else if (leftType.equals("float") && rightType.equals("int"))
            return left;

        return left;
    }

    @Override
    public Object Visit(AnalogPinNode node) {
        return null;
    }

    @Override
    public Object Visit(ArrayDeclarationNode node)
    {
        for (IdentifierNode value : node.Values)
        {
            value.Accept(this);
        }

        return node;
    }

    @Override
    public Object Visit(AssignmentNode node)
    {
        IdentifierNode identifier = (IdentifierNode)node.Identifier.Accept(this);
        String identifierType = symbolTable.ClosedSymbolTables.get(idx).Variables.get(identifier.Value).Type;

        ExpressionNode value = (ExpressionNode)node.Value.Accept(this);
        String valueType = TypeOfNode(value);

        if(identifierType.equals("float"))
        {
            if(!valueType.equals("int") && !valueType.equals("float"))
                ErrorHandler.AddError(new SemanticError(node, "Tried to assign " + valueType + " to float instance"));
        }
        else if (!identifierType.equals(valueType))
            ErrorHandler.AddError(new SemanticError(node, "Tried to assign " + valueType + " to " + identifierType + " instance"));

        return node;
    }

    public String TypeOfNode(Node node)
    {
        if(node instanceof IntNode)
            return "int";
        else if (node instanceof FloatNode)
            return "float";
        else if (node instanceof PercentNode)
            return "percent";
        else if (node instanceof TimeNode)
            return "time";
        else if (node instanceof StringNode)
            return "string";
        else if (node instanceof ArrayDeclarationNode)
            return "array";
        else if (node instanceof DayNode)
            return "day";
        else if (node instanceof MonthNode)
            return "month";
        else if (node instanceof BoolNode)
            return "bool";
        else if (node instanceof RoomDeclaration)
            return "room";

        return null;
    }

    @Override
    public BoolNode Visit(BoolNode node) {
        return node;
    }

    @Override
    public Object Visit(CaseNode node)
    {

        idx++;
        return null;
    }

    @Override
    public DayNode Visit(DayNode node) {
        return node;
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
    public Object Visit(ElseIfNode node)
    {
        idx++;
        return null;
    }

    @Override
    public Object Visit(ElseNode node)
    {
        idx++;
        return null;
    }

    @Override
    public Object Visit(EqualsNode node) {
        return null;
    }

    @Override
    public FloatNode Visit(FloatNode node) {
        return node;
    }

    @Override
    public Object Visit(ForNode node)
    {
        idx++;
        return null;
    }

    @Override
    public Object Visit(FunctionNode node)
    {
        idx++;
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
    public IdentifierNode Visit(IdentifierNode node)
    {
        return node;
    }

    @Override
    public Object Visit(IfNode node)
    {
        idx++;
        return null;
    }

    @Override
    public Object Visit(IfOrElseNode node) {
        return null;
    }

    @Override
    public IntNode Visit(IntNode node) {
        return node;
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
    public PercentNode Visit(PercentNode node) {
        return node;
    }

    @Override
    public Object Visit(PerformTimes node)
    {
        idx++;
        return null;
    }

    @Override
    public Object Visit(PerformUntil node)
    {
        idx++;
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
    public Object Visit(RoomDeclaration node)
    {
        idx++;
        return null;
    }

    @Override
    public Object Visit(RootNode node)
    {
        node.Setup.Accept(this);

        for (FunctionsNode function : node.Functions)
        {
            function.Accept(this);
        }

        return node;
    }

    @Override
    public Object Visit(SetupNode node)
    {
        for (DefinitionNode child : node.Childs)
        {
            child.Accept(this);
        }

        return node;
    }

    @Override
    public StringNode Visit(StringNode node) {
        return node;
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
    public TimeNode Visit(TimeNode node) {
        return node;
    }

    @Override
    public Object Visit(WhenNode node)
    {
        idx++;
        return null;
    }

    @Override
    public Object Visit(WhileNode node)
    {
        idx++;
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

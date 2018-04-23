package TypeChecker;

import AST.Nodes.*;
import ErrorHandler.ErrorHandler;
import ErrorHandler.Errors.SemanticError;
import SymbolTable.SymbolTable;
import visitor.Visitor;

import java.util.Arrays;

public class TypeChecker implements Visitor
{
    private SymbolTable symbolTable;
    private int lastScopeLine;

    public TypeChecker(SymbolTable table)
    {
        symbolTable = table;
    }

    public boolean IsNumber(Node node)
    {
        return false;
    }

    //Variables
    private String intType = "int";
    private String floatType = "float";
    private String percentageType = "percentage";
    private String stringType = "string";
    private String boolType = "bool";
    private String timeType = "time";
    private String dayType = "day";
    private String monthType = "month";
    private String arrayType = "array";
    private String roomType = "room";

    @Override
    public Object Visit(AdditiveNode node)
    {
        String[] AdditiveTypes = {intType, floatType, percentageType, timeType};

        String leftType = (String)node.LeftChild.Accept(this);
        String rightType = (String)node.RightChild.Accept(this);

        boolean matchFound = Arrays.asList(AdditiveTypes).contains(leftType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to add invalid type " + leftType));

        matchFound = Arrays.asList(AdditiveTypes).contains(rightType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to add invalid type " + rightType));

        if(leftType.equals(intType) && rightType.equals(floatType) ||leftType.equals(floatType) && rightType.equals(intType))
        {
            return floatType;
        }
        if(!leftType.equals(rightType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Tried to add " + leftType + " with a  " + rightType));
        }
        return leftType;
    }

    @Override
    public Object Visit(AnalogPinNode node)
    {
        return node;
    }

    @Override
    public String Visit(ArrayDeclarationNode node)
    {
        String arrayType = (String)node.Identifier.Accept(this);

        for (IdentifierNode value : node.Values)
        {
            String valueType = (String)value.Accept(this);
            if (!valueType.equals(arrayType))
            {
                ErrorHandler.AddError(new SemanticError(node, "Tried to add invalid " + valueType + " to a " + arrayType + " array"));
            }
        }

        return arrayType;
    }

    @Override
    public Object Visit(AssignmentNode node)
    {
        String identifierType = (String)node.Identifier.Accept(this);

        String valueType = (String)node.Value.Accept(this);

        if(identifierType.equals(floatType))
        {
            if(!valueType.equals(intType) && !valueType.equals(floatType))
                ErrorHandler.AddError(new SemanticError(node, "Tried to assign " + valueType + " to float instance"));
        }
        else if (!identifierType.equals(valueType))
            ErrorHandler.AddError(new SemanticError(node, "Tried to assign " + valueType + " to " + identifierType + " instance"));

        return node;
    }

    @Override
    public String Visit(BoolNode node)
    {
        return boolType;
    }

    @Override
    public String Visit(CaseNode node)
    {
        lastScopeLine = node.LineNumber;
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }
        return (String) node.Value.Accept(this);
    }

    @Override
    public String Visit(DayNode node)
    {
        return dayType;
    }

    @Override
    public Object Visit(DeclarationNode node)
    {
        String expressionType = (String) node.Value.Accept(this);
        if (!expressionType.equals(node.Type))
        {
            ErrorHandler.AddError(new SemanticError(node, "Tried to declare object of type: " + node.Type + " with type: " + expressionType));
        }
        return null;
    }

    @Override
    public Object Visit(DigitalPinNode node)
    {
        return node;
    }

    @Override
    public Object Visit(DivisionNode node)
    {
        String[] DivisionTypes = {intType, floatType};

        String leftType = (String)node.LeftChild.Accept(this);
        String rightType = (String)node.RightChild.Accept(this);

        boolean matchFound = Arrays.asList(DivisionTypes).contains(leftType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to divide invalid type " + leftType));

        matchFound = Arrays.asList(DivisionTypes).contains(rightType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to divide invalid type " + rightType));


        return floatType;
    }

    @Override
    public Object Visit(ElseIfNode node)
    {
        lastScopeLine = node.LineNumber;
        String predicateType = (String)node.Predicate.Accept(this);
        if (!predicateType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Predicate not of type boolean "));
        }
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }
        node.Alternative.Accept(this);
        return null;
    }

    @Override
    public Object Visit(ElseNode node)
    {
        lastScopeLine = node.LineNumber;
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }
        return null;
    }

    @Override
    public String Visit(EqualsNode node)
    {
        String[] EqualsTypes = {intType, floatType, percentageType, timeType, dayType, monthType, boolType, stringType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        boolean matchFound = Arrays.asList(EqualsTypes).contains(leftType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + leftType));

        matchFound = Arrays.asList(EqualsTypes).contains(rightType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + rightType));

        if(!(leftType.equals(intType) && rightType.equals(floatType)) || !(leftType.equals(floatType) && rightType.equals(intType)) || !leftType.equals(rightType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid equals comparison"));
        }

        return boolType;
    }

    @Override
    public String Visit(FloatNode node)
    {
        return floatType;
    }

    @Override
    public Object Visit(ForNode node)
    {
        lastScopeLine = node.LineNumber;
        return null;
    }

    @Override
    public Object Visit(FunctionNode node)
    {
        lastScopeLine = node.LineNumber;
        return null;
    }

    @Override
    public String Visit(GreaterOrEqualNode node)
    {
        String[] GreaterOrEqualTypes = {intType, floatType, percentageType, timeType, dayType, monthType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        boolean matchFound = Arrays.asList(GreaterOrEqualTypes).contains(leftType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + leftType));

        matchFound = Arrays.asList(GreaterOrEqualTypes).contains(rightType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + rightType));


        if(!(leftType.equals(intType) && rightType.equals(floatType)) || !(leftType.equals(floatType) && rightType.equals(intType)) || !leftType.equals(rightType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid greater or equals comparison"));
        }

        return boolType;
    }

    @Override
    public String Visit(GreaterThanNode node)
    {
        String[] GreaterThanTypes = {intType, floatType, percentageType, timeType, dayType, monthType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        boolean matchFound = Arrays.asList(GreaterThanTypes).contains(leftType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + leftType));

        matchFound = Arrays.asList(GreaterThanTypes).contains(rightType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + rightType));


        if(!(leftType.equals(intType) && rightType.equals(floatType)) || !(leftType.equals(floatType) && rightType.equals(intType)) || !leftType.equals(rightType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid greater than comparison"));
        }

        return boolType;
    }

    @Override
    public String Visit(IdentifierNode node)
    {
        return symbolTable.GetScope((String.valueOf(lastScopeLine))).GetTypeofVariable(node, node.Value);
    }

    @Override
    public Object Visit(IfNode node)
    {
        lastScopeLine = node.LineNumber;
        String predicateType = (String)node.Predicate.Accept(this);
        if (!predicateType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Predicate not of type boolean"));
        }
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }
        node.Alternative.Accept(this);
        return null;
    }

    @Override
    public Object Visit(IfOrElseNode node) {
        return null;
    }

    @Override
    public String Visit(IntNode node)
    {
        return intType;
    }

    @Override
    public Object Visit(IoStatusNode node) {
        return null;
    }

    @Override
    public String Visit(LessOrEqualNode node)
    {
        String[] LessOrEqualTypes = {intType, floatType, percentageType, timeType, dayType, monthType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        boolean matchFound = Arrays.asList(LessOrEqualTypes).contains(leftType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + leftType));

        matchFound = Arrays.asList(LessOrEqualTypes).contains(rightType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + rightType));


        if(!(leftType.equals(intType) && rightType.equals(floatType)) || !(leftType.equals(floatType) && rightType.equals(intType)) || !leftType.equals(rightType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid less or equal comparison"));
        }

        return boolType;
    }

    @Override
    public String Visit(LessThanNode node)
    {
        String[] LessThanTypes = {intType, floatType, percentageType, timeType, dayType, monthType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        boolean matchFound = Arrays.asList(LessThanTypes).contains(leftType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + leftType));

        matchFound = Arrays.asList(LessThanTypes).contains(rightType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + rightType));


        if(!(leftType.equals(intType) && rightType.equals(floatType)) || !(leftType.equals(floatType) && rightType.equals(intType)) || !leftType.equals(rightType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid less than comparison "));
        }

        return boolType;
    }

    @Override
    public String Visit(LogicalAndNode node)
    {
        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        if (!leftType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Logical-and statement not of type boolean. Is of type: " + leftType));
        }
        else if (!rightType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Logical-and statement not of type boolean. Is of type: " + rightType));
        }

        return boolType;
    }

    @Override
    public String Visit(LogicalOrNode node)
    {
        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        if (!leftType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Logical-or statement not of type boolean. Is of type: " + leftType));
        }
        else if (!rightType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Logical-or statement not of type boolean. Is of type: " + rightType));
        }

        return boolType;
    }

    @Override
    public String Visit(MonthNode node)
    {
        return monthType;
    }

    @Override
    public Object Visit(MultiplicationNode node)
    {
        String[] MultiplicationTypes = {intType, floatType};

        String leftType = (String)node.LeftChild.Accept(this);
        String rightType = (String)node.RightChild.Accept(this);

        boolean matchFound = Arrays.asList(MultiplicationTypes).contains(leftType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to multiply invalid type " + leftType));

        matchFound = Arrays.asList(MultiplicationTypes).contains(rightType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to multiply invalid type " + rightType));

        if(leftType.equals(intType) && rightType.equals(floatType) || leftType.equals(floatType) && rightType.equals(intType))
        {
            return floatType;
        }
        if(leftType.equals(rightType))
        {
            return leftType;
        }
        return floatType;
    }

    @Override
    public Object Visit(NegateNode node)
    {
        node.child.Accept(this);
        return null;
    }

    @Override
    public String Visit(NotEqualsNode node)
    {
        String[] NotEqualsTypes = {intType, floatType, percentageType, timeType, dayType, monthType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        boolean matchFound = Arrays.asList(NotEqualsTypes).contains(leftType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + leftType));

        matchFound = Arrays.asList(NotEqualsTypes).contains(rightType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + rightType));


        if(!(leftType.equals(intType) && rightType.equals(floatType)) || !(leftType.equals(floatType) && rightType.equals(intType)) || !leftType.equals(rightType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid not equals comparison"));
        }

        return boolType;
    }

    @Override
    public Object Visit(ParameterNode node)
    {
        node.Identifier.Accept(this);
        return null;
    }

    @Override
    public String Visit(PercentNode node)
    {
        return percentageType;
    }

    @Override
    public Object Visit(PerformTimes node)
    {
        lastScopeLine = node.LineNumber;
        String iteratorType = (String)node.value.Accept(this);
        if (!iteratorType.equals(intType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Iterator has to be of type int, is of type: " + iteratorType));
        }
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }
        return null;
    }

    @Override
    public Object Visit(PerformUntil node)
    {
        lastScopeLine = node.LineNumber;
        IterationChecker(node);
        return null;
    }

    @Override
    public Object Visit(PinDeclarationNode node)
    {
        node.Pin.Accept(this);
        node.IoStatus.Accept(this);
        return null;
    }

    @Override
    public Object Visit(ReturnNode node)
    {
        return null;
    }

    @Override
    public String Visit(RoomDeclaration node)
    {
        lastScopeLine = node.LineNumber;
        for (RoomBlockNode roomBlockNode : node.body)
        {
            roomBlockNode.Accept(this);
        }
        return roomType;
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
    public String Visit(StringNode node)
    {
        return stringType;
    }

    @Override
    public Object Visit(SubtractiveNode node)
    {
        String[] SubtractiveTypes = {intType, floatType, percentageType, timeType};

        String LeftType = (String)node.LeftChild.Accept(this);
        String rightVar = (String)node.RightChild.Accept(this);

        boolean matchFound = Arrays.asList(SubtractiveTypes).contains(LeftType);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to subtract invalid type " + LeftType));

        matchFound = Arrays.asList(SubtractiveTypes).contains(rightVar);

        if(!matchFound)
            ErrorHandler.AddError(new SemanticError(node, "Tried to subtract invalid type " + rightVar));

        if(LeftType.equals(intType) && rightVar.equals(floatType) || LeftType.equals(floatType) && rightVar.equals(intType))
        {
            return floatType;
        }
        if(!LeftType.equals(rightVar))
        {
            ErrorHandler.AddError(new SemanticError(node, "Tried to subtract " + LeftType + " with a  " + rightVar));
        }
        return LeftType;
    }

    @Override
    public Object Visit(SwitchNode node)
    {
        lastScopeLine = node.LineNumber;
        String switchType = (String)node.expression.Accept(this);

        for (CaseNode caseNode : node.Body)
        {
            String caseType = (String) caseNode.Accept(this);
            if (!caseType.equals(switchType))
            {
                ErrorHandler.AddError(new SemanticError(node, "Case type is: " + caseType + " expecting: " + switchType));
            }
        }
        node.defaultCase.Accept(this);
        return null;
    }

    @Override
    public String Visit(TimeNode node)
    {
        return timeType;
    }

    @Override
    public Object Visit(WhenNode node)
    {
        lastScopeLine = node.LineNumber;
        String predicateType = (String)node.Predicate.Accept(this);
        if (!predicateType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Predicate has to be of type boolean, is of type: " + predicateType));
        }
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }
        return null;
    }

    @Override
    public Object Visit(WhileNode node)
    {
        lastScopeLine = node.LineNumber;
        IterationChecker(node);
        return null;
    }

    private void IterationChecker(IterationNode node)
    {
        String predicateType = (String)node.Predicate.Accept(this);
        if (!predicateType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Predicate has to be of type boolean, is of type: " + predicateType));
        }
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }
    }

    @Override
    public Object Visit(HouseNode node)
    {
        lastScopeLine = node.LineNumber;
        node.Identifier.Accept(this);
        return null;
    }

    @Override
    public Object Visit(MethodCallNode node)
    {
        node.identifier.Accept(this);
        for (ExpressionNode expression : node.expressions)
        {
            expression.Accept(this);
        }
        return null;
    }
}
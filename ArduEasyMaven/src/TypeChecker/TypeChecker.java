package TypeChecker;

import AST.Nodes.*;
import ErrorHandler.ErrorHandler;
import ErrorHandler.Errors.SemanticError;
import SymbolTable.SymbolTable;
import visitor.Visitor;

import java.util.*;

public class TypeChecker implements Visitor
{
    private SymbolTable symbolTable;
    private int lastScopeLine;
    private String isRoom = null;

    public TypeChecker(SymbolTable table)
    {
        symbolTable = table;
    }

    public Map<String, List<String>> FunctionList = new HashMap<String, List<String>>();

    //Variables
    private String intType = "int";
    private String floatType = "float";
    private String percentageType = "percent";
    private String stringType = "string";
    private String boolType = "bool";
    private String timeType = "time";
    private String dayType = "day";
    private String monthType = "month";
    private String arrayDType = "array";
    private String roomType = "room";
    private String digital_inputType = "bool.input";
    private String digital_outputType = "bool.output";
    private String analog_inputType = "int.input";
    private String analog_outputType = "int.output";
    private String pullup_inputType = "bool.inputpullup";
    private String voidType = "void";

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
            if (arrayDType.equals(arrayType) && CheckIfPinType(valueType)) // if arraytype is still array, and valuetype is one of the 5 array types, then arraytype is defined as the valuetype.
            {
                arrayType = valueType;
                symbolTable.GetScope(isRoom).Update(node, node.Values.get(0).Value, GetPinType(arrayType));
            }
            if (!arrayType.equals(valueType))
            {
                ErrorHandler.AddError(new SemanticError(node, "Tried to add " + valueType + " to an " + arrayType + " array"));
            }
        }

        return arrayType;
    }

    @Override
    public Object Visit(AssignmentNode node)
    {
        String identifierType = GetPinType((String)node.Identifier.Accept(this)); // tries to get pin type if expression is a pintype
        String valueType =  GetPinType((String)node.Value.Accept(this));

        if(identifierType.equals(floatType))
        {
            if(!valueType.equals(intType) && !valueType.equals(floatType))
                ErrorHandler.AddError(new SemanticError(node, "Tried to assign " + valueType + " to float instance"));
        }
        else if (!identifierType.equals(valueType))
            ErrorHandler.AddError(new SemanticError(node, "Tried to assign " + valueType + " to " + identifierType + " instance"));

        return node;
    }

    private String GetPinType(String type) {
        // if identifier is a pin declaration then tried to split type to only get type because type in pin returns type and iostatus
        return type.split("\\.")[0];
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
        String caseType ;

        if (node.Value != null)
        {
            caseType = (String) node.Value.Accept(this);
        }
        else
        {
            caseType = null;
        }

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
            lastScopeLine = node.LineNumber;
        }
        return caseType;
    }

    @Override
    public String Visit(DayNode node)
    {
        return dayType;
    }

    @Override
    public Object Visit(DeclarationNode node)
    {
        String identifierType = (String) node.Identifier.Accept(this);
        String expressionType = (String) node.Value.Accept(this);

        if (!expressionType.equals(identifierType))
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
            lastScopeLine = node.LineNumber;

        }
        if (node.Alternative != null)
        {
            node.Alternative.Accept(this);
            lastScopeLine = node.LineNumber;
        }
        return null;
    }

    @Override
    public Object Visit(ElseNode node)
    {
        lastScopeLine = node.LineNumber;
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
            lastScopeLine = node.LineNumber;
        }
        return null;
    }

    @Override
    public String Visit(EqualsNode node)
    {
        String[] EqualsTypes = {intType, floatType, percentageType, timeType, dayType, monthType, boolType, stringType, digital_inputType, digital_outputType, analog_inputType, analog_outputType, pullup_inputType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        if(CheckComparisonOperators(EqualsTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid equals comparison " + leftType + " and " + rightType));
        }

        return boolType;
    }

    private boolean CheckComparisonOperators(String[] comparisonTypes, String leftType, String rightType, Node node)
    {
        if (leftType == null || rightType == null) return false;

        boolean matchFound = Arrays.asList(comparisonTypes).contains(leftType);

        if(!matchFound)
        {
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + leftType));
            return false;
        }

        matchFound = Arrays.asList(comparisonTypes).contains(rightType);

        if(!matchFound)
        {
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + rightType));
            return false;
        }

        // check for array declaration values, int.input int.output bool.input etc...
        if (CheckIfPinType(leftType) || CheckIfPinType(rightType))
        {
            if (leftType.equals(rightType) || rightType.equals(leftType))
            {
                return true; // returns true if its a array declaration with the same type. e.g int.output == int.output
            }
            else
            {
                // if its not the same type, the type is assigned to leftype e.g int.ouput is a int type.
                leftType = GetPinType(leftType);
                rightType = GetPinType(rightType);
            }
        }
        // a int and float is the only exception that may be compared with different types, else the type have to be equal on both sides.
        return !(leftType.equals(intType) && rightType.equals(floatType) // float and int comparison
                || (leftType.equals(floatType) && rightType.equals(intType))
                || leftType.equals(rightType));
    }

    private boolean CheckIfPinType(String valueType)
    {
        if (valueType.equals(digital_inputType) || valueType.equals(digital_outputType) || valueType.equals(analog_inputType) || valueType.equals(analog_outputType) || valueType.equals(pullup_inputType))
            return true;
        return false;
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
        String predicateType = (String)node.Predicate.Accept(this);
        if (!predicateType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Predicate not of type boolean"));
        }

        node.Increment.Accept(this);
        node.Var.Accept(this);

        for (StatementsNode statementsNode : node.body)
        {
            statementsNode.Accept(this);
            lastScopeLine = node.LineNumber;
        }
        return null;
    }

    @Override
    public Object Visit(FunctionNode node)
    {
        lastScopeLine = node.LineNumber;

        if (!node.ReturnType.equals(voidType))
        {
            String typeOfReturn = ((String) node.Return.Accept(this));

            if (!typeOfReturn.equals(node.ReturnType))
            {
                ErrorHandler.AddError(new SemanticError(node, "Tried to return a " + typeOfReturn + " in a " + node.ReturnType + " method"));
            }
        }

        for (ParameterNode parameter : node.Parameters)
        {
            parameter.Accept(this);
        }

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
            lastScopeLine = node.LineNumber;
        }
        return null;
    }

    @Override
    public String Visit(GreaterOrEqualNode node)
    {
        String[] GreaterOrEqualTypes = {intType, floatType, percentageType, timeType, dayType, monthType, analog_inputType, analog_outputType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        if(CheckComparisonOperators(GreaterOrEqualTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid greater or equals comparison "+ leftType + " and " + rightType));
        }

        return boolType;
    }

    @Override
    public String Visit(GreaterThanNode node)
    {
        String[] GreaterThanTypes = {intType, floatType, percentageType, timeType, dayType, monthType, analog_inputType, analog_outputType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        if(CheckComparisonOperators(GreaterThanTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid greater than comparison "+ leftType + " and " + rightType));
        }

        return boolType;
    }

    @Override
    public Object Visit(IdentifierNode node)
    {
        String[] roomSplit = node.Value.split("\\.");

        if (lastScopeLine == 0)
        {
            return symbolTable.GetTypeofVariable(node, node.Value);
        }
        else if (isRoom != null)
        {
            return symbolTable.GetScope(isRoom).GetTypeofVariable(node, node.Value);
        }
        else if (roomSplit.length > 2)
        {
            return symbolTable.GetScope(roomSplit[1]).GetTypeofVariable(node, roomSplit[2]);
        }
        else
        {
            return symbolTable.GetScope((String.valueOf(lastScopeLine))).GetTypeofVariable(node, node.Value);
        }

    }

    @Override
    public Object Visit(IfNode node)
    {
        lastScopeLine = node.LineNumber;
        String predicateType = GetPinType((String)node.Predicate.Accept(this));

        if (!predicateType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Predicate not of type boolean"));
        }
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
            lastScopeLine = node.LineNumber;
        }
        if (node.Alternative != null)
        {
            node.Alternative.Accept(this);
        }
        lastScopeLine = node.LineNumber;
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
        String[] LessOrEqualTypes = {intType, floatType, percentageType, timeType, dayType, monthType, analog_inputType, analog_outputType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        if(CheckComparisonOperators(LessOrEqualTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid less or equal comparison "+ leftType + " and " + rightType));
        }

        return boolType;
    }

    @Override
    public String Visit(LessThanNode node)
    {
        String[] LessThanTypes = {intType, floatType, percentageType, timeType, dayType, monthType, analog_inputType, analog_outputType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        if(CheckComparisonOperators(LessThanTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid less than comparison " + leftType + " and " + rightType));
        }

        return boolType;
    }

    @Override
    public String Visit(LogicalAndNode node)
    {
        String leftType = GetPinType((String)node.Left.Accept(this)); // tries to get pin type if expression is a pintype
        String rightType = GetPinType((String)node.Right.Accept(this));

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
        String leftType = GetPinType((String)node.Left.Accept(this)); // tries to get pin type if expression is a pintype
        String rightType = GetPinType((String)node.Right.Accept(this));

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
    public String Visit(NegateNode node)
    {
        return (String) node.child.Accept(this);
    }

    @Override
    public String Visit(NotEqualsNode node)
    {
        String[] NotEqualsTypes = {intType, floatType, percentageType, timeType, dayType, monthType, digital_inputType, digital_outputType, analog_inputType, analog_outputType, pullup_inputType};

        String leftType = (String)node.Left.Accept(this);
        String rightType = (String)node.Right.Accept(this);

        if(CheckComparisonOperators(NotEqualsTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid not equals comparison "+ leftType + " and " + rightType));
        }

        return boolType;
    }

    @Override
    public String Visit(ParameterNode node)
    {
        return ((String) node.Identifier.Accept(this));
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

        if (iteratorType != null) // if no type is found the variable is not in the scope
        {
            if (!iteratorType.equals(intType))
            {
                ErrorHandler.AddError(new SemanticError(node, "Iterator has to be of type int, is of type: " + iteratorType));
            }
            for (StatementsNode statementsNode : node.Body)
            {
                statementsNode.Accept(this);
                lastScopeLine = node.LineNumber;
            }
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
    public String Visit(ReturnNode node)
    {
        return (String) node.Value.Accept(this);
    }

    @Override
    public String Visit(RoomDeclaration node)
    {
        lastScopeLine = node.LineNumber;
        isRoom = node.Identifier.Value;

        for (RoomBlockNode roomBlockNode : node.body)
        {
            roomBlockNode.Accept(this);
            lastScopeLine = node.LineNumber;
        }

        isRoom = null;
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
        String switchType = (String)node.expression.Accept(this);

        for (CaseNode caseNode : node.Body)
        {
            String caseType = (String) caseNode.Accept(this);

            if (!caseType.equals(switchType))
            {
                ErrorHandler.AddError(new SemanticError(node, "Case type is: " + caseType + " expecting: " + switchType));
            }
        }
        if (node.defaultCase != null)
        {
            node.defaultCase.Accept(this);
        }
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
            lastScopeLine = node.LineNumber;
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
            lastScopeLine = node.LineNumber;
        }
    }

    @Override
    public String Visit(HouseNode node)
    {
        return (String) node.Identifier.Accept(this);
    }

    @Override
    public Object Visit(MethodCallNode node)
    {
        List<String[]> parameters = SymbolTable.FunctionList.get(node.identifier.Value).Parameters;

        int i = 0;
        for (ExpressionNode expression : node.expressions)
        {
            String parameterType = (String) expression.Accept(this);
            parameterType = GetPinType(parameterType);
            if (!parameters.get(i++)[1].equals(parameterType))
            {
                ErrorHandler.AddError(new SemanticError(node, "Tried to use a " + parameterType + " when expecting a " + parameters.get(i - 1)[1] + " type in the method call parameters"));
            }
        }
        return SymbolTable.FunctionList.get(node.identifier.Value).Type;
    }
}
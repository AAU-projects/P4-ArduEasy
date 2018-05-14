package TypeChecker;

import AST.Nodes.*;
import ErrorHandler.ErrorHandler;
import ErrorHandler.Errors.SemanticError;
import SymbolTable.SymbolTable;
import SymbolTable.Variables.PinVariable;
import SymbolTable.Variables.Variable;
import visitor.Visitor;

import java.util.*;

public class TypeChecker implements Visitor
{
    private SymbolTable symbolTable;

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
    public Object Visit(ParanNode node)
    {
        return node.child.Accept(this);
    }

    @Override
    public Object Visit(AdditiveNode node)
    {
        String[] AdditiveTypes = {intType, floatType, percentageType, timeType};

        String leftType = GetTypeNode(node.LeftChild);
        String rightType = GetTypeNode(node.RightChild);

        return GetArithmetic(AdditiveTypes, leftType, rightType, node);
    }

    private String GetArithmetic(String[] comparisonTypes, String left, String right,  Node node)
    {
        if (!isValidInput(comparisonTypes, left, right, node))
        {
            return left;
        }
        else if (!isValidOperands(left, right))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid Aritmetic operands a " + left + " operand can not be used with a " + right + " operand"));
        }

        if(left.equals(intType) && right.equals(floatType) || left.equals(floatType) && right.equals(intType))
        {
            return floatType;
        }
        if(left.equals(intType) && right.equals(percentageType) || left.equals(percentageType) && right.equals(intType))
        {
            return intType;
        }

        return left;
    }

    private String GetTypeNode(Node node)
    {
       Object type = node.Accept(this);
       if (type instanceof Variable)           // checks if the object is a instance of variable
           return ((Variable) type).Type;
       else                                    // if not a variable it can be casted to a string which returns the nodes string, e.g its a intnode and a int is returned.
           return (String) type;
    }


    private String GetArrayTypeNode(Node node)
    {
        // this function is used for getting the arrayType as it have to return a different string, e.g int.output bool.intput
        Object type = node.Accept(this);
        if (type instanceof PinVariable) // if the object is a pin variable both the type and iostatus is returned as this data is needed
        {
            PinVariable pinType = (PinVariable) type;
            return pinType.Type + "." + pinType.IOStatus;
        }
        return "array"; // array is returned if its not a pin variable as this is the identifier, e.g Lamps = {Lamp1, Lamp2}, Lamps are not a pinVariable and its type is an array
    }

    @Override
    public Object Visit(AnalogPinNode node)
    {
        return "analog";
    }

    @Override
    public String Visit(ArrayDeclarationNode node)
    {
        String arrayType = GetTypeNode(node.Identifier);

        for (IdentifierNode value : node.Values)
        {
            String valueType = GetArrayTypeNode(value);
            if (arrayDType.equals(arrayType) && CheckIfPinType(valueType)) // if arraytype is still array, and valuetype is one of the 5 array types, then arraytype is defined as the valuetype.
            {
                arrayType = valueType;
                symbolTable.CurrentOpenScope.GetTypeofVariable(node, node.Values.get(0).Value).SetValue(arrayType);
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
        String identifierType = GetTypeNode(node.Identifier); // tries to get pin type if expression is a pintype
        String valueType =  GetTypeNode(node.Value);

        if(!isValidOperands(identifierType, valueType))
            ErrorHandler.AddError(new SemanticError(node, "Tried to assign " + valueType + " to " + identifierType  + " instance"));

        return node;
    }

    private boolean isValidOperands(String left, String right)
    {
        if (left == null || right == null) return true; // something went wrong with scope

        if (left.equals(right)) return true; // if identifier is the same type as right

        if (left.equals(intType)
                && (right.equals(floatType)
                || right.equals(percentageType) )) return true; // if identifier int then right can be float, percent

        if (left.equals(floatType)
                && (right.equals(intType) )) return true; // if identifier float then right can be int

        if (left.equals(percentageType)
                && (right.equals(intType) )) return true; // if percentageType float then rightType can be int)

         if (isValidPinOperatorRule(left, right)) return true;

        return false;
    }

    private boolean isValidInput(String[] comparisonTypes, String left, String right, Node node)
    {
        if (left == null || right == null) return false;

        boolean matchFound = Arrays.asList(comparisonTypes).contains(left);

        if(!matchFound)
        {
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + left));
            return false;
        }

        matchFound = Arrays.asList(comparisonTypes).contains(right);

        if(!matchFound)
        {
            ErrorHandler.AddError(new SemanticError(node, "Tried to compare invalid type " + right));
            return false;
        }

        return true;
    }

    private boolean IsValidComparison(String[] comparisonTypes, String left, String right, Node node)
    {
        if (!isValidInput(comparisonTypes, left, right, node)) return true;

        // check for array declaration values, int.input int.output bool.input etc...
        if (CheckIfPinType(left) || CheckIfPinType(right))
        {
            boolean notValid = isValidPinOperatorRule(left, right); // checks all valid pin operator rules
            if (!notValid) return true;
            left = GetPinType(left);
            right = GetPinType(right);
        }

        if (left.equals(right)) return true; // if leftType is the same type as rightType

        if (left.equals(intType)
                && right.equals(floatType)
                || right.equals(percentageType) ) return true; // if leftType int then rightType can be float, percent

        if (left.equals(floatType)
                && right.equals(intType) ) return true; // if leftType float then rightType can be int

        return false; // is not a valid operator rule
    }

    private boolean isValidPinOperatorRule(String left, String right) {
        if (left.equals(digital_inputType)
                && (right.equals(digital_outputType)
                || right.equals(pullup_inputType)
                || right.equals(boolType) )) return true; // if identifier digital_inputType then value can be digital_outputType, boolType

        if (left.equals(digital_outputType)
                && (right.equals(digital_inputType)
                || right.equals(pullup_inputType)
                || right.equals(boolType) )) return true;

        if (left.equals(analog_inputType)
                && (right.equals(analog_outputType)
                || right.equals(intType) )) return true;

        if (left.equals(analog_outputType)
                && (right.equals(analog_inputType)
                || right.equals(intType) )) return true;

        if (left.equals(pullup_inputType)
                && (right.equals(digital_outputType)
                || right.equals(digital_inputType)
                || right.equals(boolType) )) return true;

        return false;

    }

    private boolean CheckLoop(String value, String... strings)
    {
        for (String equalValue : strings) {
            if (value.equals(equalValue))
                return true;
        }
        return false;
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
        symbolTable.OpenScope(String.valueOf(node.LineNumber));
        String caseType ;

        if (node.Value != null)
        {
            caseType = GetTypeNode(node.Value);
        }
        else
        {
            caseType = null;
        }

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();
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
        String identifierType = GetTypeNode(node.Identifier);
        String expressionType = GetTypeNode(node.Value);

        if (!isValidOperands(identifierType, expressionType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Tried to declare object of type: " + node.Type + " with type: " + expressionType));
        }

        return null;
    }

    @Override
    public Object Visit(DigitalPinNode node)
    {
        return "digital";
    }

    @Override
    public Object Visit(DivisionNode node)
    {
        String[] DivisionTypes = {intType, floatType};

        String leftType = GetTypeNode(node.LeftChild);
        String rightType = GetTypeNode(node.RightChild);

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
        symbolTable.OpenScope(String.valueOf(node.LineNumber));
        String predicateType = GetTypeNode(node.Predicate);
        if (!predicateType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Predicate not of type boolean "));
        }
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();

        if (node.Alternative != null)
        {
            node.Alternative.Accept(this);
        }
        return null;
    }

    @Override
    public Object Visit(ElseNode node)
    {
        symbolTable.OpenScope(String.valueOf(node.LineNumber));
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }
        symbolTable.CloseScope();
        return null;
    }

    @Override
    public String Visit(EqualsNode node)
    {
        String[] EqualsTypes = {intType, floatType, percentageType, timeType, dayType, monthType, boolType, stringType, digital_inputType, digital_outputType, analog_inputType, analog_outputType, pullup_inputType};

        String leftType = GetTypeNode(node.Left);
        String rightType = GetTypeNode(node.Right);

        if(!IsValidComparison(EqualsTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid equals comparison " + leftType + " and " + rightType));
        }

        return boolType;
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
        symbolTable.OpenScope(String.valueOf(node.LineNumber));
        String predicateType = GetTypeNode(node.Predicate);
        if (!predicateType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Predicate not of type boolean"));
        }

        node.Increment.Accept(this);
        node.Var.Accept(this);

        for (StatementsNode statementsNode : node.body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();
        return null;
    }

    @Override
    public Object Visit(FunctionNode node)
    {
        symbolTable.OpenScope(String.valueOf(node.LineNumber));

        if (!node.ReturnType.equals(voidType))
        {
            String typeOfReturn = GetTypeNode(node.Return);

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
        }

        symbolTable.CloseScope();
        return null;
    }

    @Override
    public String Visit(GreaterOrEqualNode node)
    {
        String[] GreaterOrEqualTypes = {intType, floatType, percentageType, timeType, dayType, monthType, analog_inputType, analog_outputType};

        String leftType = GetTypeNode(node.Left);
        String rightType = GetTypeNode(node.Right);

        if(!IsValidComparison(GreaterOrEqualTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid greater or equals comparison "+ leftType + " and " + rightType));
        }

        return boolType;
    }

    @Override
    public String Visit(GreaterThanNode node)
    {
        String[] GreaterThanTypes = {intType, floatType, percentageType, timeType, dayType, monthType, analog_inputType, analog_outputType};

        String leftType = GetTypeNode(node.Left);
        String rightType = GetTypeNode(node.Right);

        if(!IsValidComparison(GreaterThanTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid greater than comparison "+ leftType + " and " + rightType));
        }

        return boolType;
    }

    @Override
    public Object Visit(IdentifierNode node)
    {
        String[] roomSplit = node.Value.split("\\.");

        if (roomSplit.length > 2)
        {
            return symbolTable.GetScope(roomSplit[1]).GetTypeofVariable(node, roomSplit[2]);
        }
        else
        {
            return symbolTable.CurrentOpenScope.GetTypeofVariable(node, node.Value);
        }
    }


    @Override
    public Object Visit(IfNode node)
    {
        symbolTable.GetCurrentScope(String.valueOf(node.LineNumber));
        String predicateType = GetTypeNode(node.Predicate);

        if (!predicateType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Predicate not of type boolean"));
        }
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();

        if (node.Alternative != null)
        {
            node.Alternative.Accept(this);
        }
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
        return node.Value;
    }

    @Override
    public String Visit(LessOrEqualNode node)
    {
        String[] LessOrEqualTypes = {intType, floatType, percentageType, timeType, dayType, monthType, analog_inputType, analog_outputType};

        String leftType = GetTypeNode(node.Left);
        String rightType = GetTypeNode(node.Right);

        if(!IsValidComparison(LessOrEqualTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid less or equal comparison "+ leftType + " and " + rightType));
        }

        return boolType;
    }

    @Override
    public String Visit(LessThanNode node)
    {
        String[] LessThanTypes = {intType, floatType, percentageType, timeType, dayType, monthType, analog_inputType, analog_outputType};

        String leftType = GetTypeNode(node.Left);
        String rightType = GetTypeNode(node.Right);

        if(!IsValidComparison(LessThanTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid less than comparison " + leftType + " and " + rightType));
        }

        return boolType;
    }

    @Override
    public String Visit(LogicalAndNode node)
    {
        String leftType = GetTypeNode(node.Left);
        String rightType = GetTypeNode(node.Right);

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
        String leftType = GetTypeNode(node.Left);
        String rightType = GetTypeNode(node.Right);

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

        String leftType = GetTypeNode(node.LeftChild);
        String rightType = GetTypeNode(node.RightChild);

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
        return GetTypeNode(node.child);
    }

    @Override
    public String Visit(NotEqualsNode node)
    {
        String[] NotEqualsTypes = {intType, floatType, percentageType, timeType, dayType, monthType, boolType, stringType, digital_inputType, digital_outputType, analog_inputType, analog_outputType, pullup_inputType};

        String leftType = GetTypeNode(node.Left);
        String rightType = GetTypeNode(node.Right);

        if(!IsValidComparison(NotEqualsTypes, leftType, rightType, node))
        {
            ErrorHandler.AddError(new SemanticError(node, "Invalid not equals comparison "+ leftType + " and " + rightType));
        }

        return boolType;
    }

    @Override
    public String Visit(ParameterNode node)
    {
        return GetTypeNode(node.Identifier);
    }

    @Override
    public String Visit(PercentNode node)
    {
        return percentageType;
    }

    @Override
    public Object Visit(PerformTimesNode node)
    {
        symbolTable.OpenScope((String.valueOf(node.LineNumber)));
        String iteratorType = GetTypeNode(node.value);

        if (iteratorType != null) // if no type is found the variable is not in the scope
        {
            if (!iteratorType.equals(intType))
            {
                ErrorHandler.AddError(new SemanticError(node, "Iterator has to be of type int, is of type: " + iteratorType));
            }
            for (StatementsNode statementsNode : node.Body)
            {
                statementsNode.Accept(this);
            }

            symbolTable.CloseScope();
        }
        return null;
    }

    @Override
    public Object Visit(PerformUntilNode node)
    {
        symbolTable.OpenScope(String.valueOf(node.LineNumber));
        IterationChecker(node);
        return null;
    }

    @Override
    public Object Visit(PinDeclarationNode node)
    {
        String pinType = (String) node.Pin.Accept(this);
        String IOType = (String) node.IoStatus.Accept(this);

        if (pinType.equals("analog"))
            if (IOType.equals("inputpullup"))
            {
                ErrorHandler.AddError(new SemanticError(node, "Tried to create an Analog inputpullup, inputpull can only be digital"));
            }

        return null;
    }

    @Override
    public String Visit(ReturnNode node)
    {
        return GetTypeNode(node.Value);
    }

    @Override
    public String Visit(RoomDeclaration node)
    {
        symbolTable.OpenScope(String.valueOf(node.Identifier.Value));
        roomType = node.Identifier.Value;

        for (RoomBlockNode roomBlockNode : node.body)
        {
            roomBlockNode.Accept(this);
        }

        symbolTable.CloseScope();

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

        String leftType = GetTypeNode(node.LeftChild);
        String rightType = GetTypeNode(node.RightChild);

        return GetArithmetic(SubtractiveTypes, leftType, rightType, node);
    }

    @Override
    public Object Visit(SwitchNode node)
    {
        String switchType = GetTypeNode(node.expression);

        for (CaseNode caseNode : node.Body)
        {
            String caseType = GetTypeNode(caseNode);

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
        symbolTable.OpenScope(String.valueOf(node.LineNumber));
        String predicateType = GetTypeNode(node.Predicate);
        if (!predicateType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Predicate has to be of type boolean, is of type: " + predicateType));
        }
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();

        return null;
    }

    @Override
    public Object Visit(WhileNode node)
    {
        IterationChecker(node);
        return null;
    }

    private void IterationChecker(IterationNode node)
    {
        String predicateType = GetTypeNode(node.Predicate);
        if (!predicateType.equals(boolType))
        {
            ErrorHandler.AddError(new SemanticError(node, "Predicate has to be of type boolean, is of type: " + predicateType));
        }
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }
        symbolTable.CloseScope();
    }

    @Override
    public String Visit(HouseNode node)
    {
        return GetTypeNode(node.Identifier);
    }

    @Override
    public Object Visit(MethodCallNode node)
    {
        List<String[]> parameters = SymbolTable.FunctionList.get(node.identifier.Value).Parameters;

        int i = 0;
        for (ExpressionNode expression : node.expressions)
        {
            String parameterType = GetTypeNode(expression);
            parameterType = GetPinType(parameterType);
            if (!parameters.get(i++)[1].equals(parameterType))
            {
                ErrorHandler.AddError(new SemanticError(node, "Tried to use a " + parameterType + " when expecting a " + parameters.get(i - 1)[1] + " type in the method call parameters"));
            }
        }
        return SymbolTable.FunctionList.get(node.identifier.Value).Type;
    }
}
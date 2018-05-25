package SymbolTable;

import AST.Nodes.*;
import ErrorHandler.CustomErrorHandler;
import ErrorHandler.Errors.SemanticError;
import SymbolTable.Variables.*;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuildSymbolTable implements Visitor
{
    public SymbolTable symbolTable = new SymbolTable();
    private String room;

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
    public Object Visit(ParanNode node)
    {
        return "(" + node.child.Accept(this) + ")";
    }

    @Override
    public Object Visit(AdditiveNode node)
    {
        String left = (String)node.LeftChild.Accept(this);
        String right = (String)node.RightChild.Accept(this);

        return left + " + " + right;
    }



    @Override
    public Object Visit(ArrayDeclarationNode node)
    {
        final String identifier = (String)node.Identifier.Accept(this);
        final String type = "array";
        final ArrayList<String> values = new ArrayList<String>();

        for (IdentifierNode childNode : node.Values)
        {
            values.add(childNode.toString());
        }

        Variable var = new ArrayVariable()
        {{
            Identifier = identifier;
            Type = type;
            Value = values;
        }};

        if (symbolTable.CurrentOpenScope == symbolTable)
            symbolTable.Insert(node, "house." + identifier, var);
        else
            symbolTable.Insert(node, identifier, var);

        return null;
    }

    @Override
    public Object Visit(AssignmentNode node)
    {
        String identifier = (String)node.Identifier.Accept(this);

        String[] temp = identifier.split("\\.");
        final String value = (String)node.Value.Accept(this);

        if (temp.length > 2 && symbolTable.GetScope(temp[1]).GetTypeofVariable(node,temp[2]).Type.equals("array"))
        {

            List<String> things = ((ArrayVariable) symbolTable.GetScope(temp[1]).Variables.get(temp[2])).Value();

            for (String thing : things)
            {
                if (!thing.equals(temp[2]))
                    symbolTable.GetScope(temp[1]).Update(node, thing, value);
            }
        }
        else if (temp.length > 2)
        {
            symbolTable.GetScope(temp[1]).Update(node, temp[2], value);
        }
        else
            symbolTable.Update(node, identifier, value);

        return null;
    }

    @Override
    public Object Visit(BoolNode node)
    {
        return boolType;
    }

    @Override
    public Object Visit(CaseNode node)
    {
        symbolTable.CreateScope(node);
        //System.out.println("Opened a case (" + node.LineNumber + ")");

        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }

        for (String s : symbolTable.CurrentOpenScope.Variables.keySet())
        {
            //System.out.println("    " + s);
        }
        symbolTable.CloseScope();
        //System.out.println("Closed a case (" + node.LineNumber + ")");
        return null;
    }

    @Override
    public Object Visit(DayNode node)
    {
        return dayType;
    }

    @Override
    public Object Visit(DeclarationNode node)
    {
        final String identifier = (String)node.Identifier.Accept(this);
        final String value = (String)node.Value.Accept(this);
        final String type = node.Type;

        Variable var = new IdentifierVariable()
        {{
            Identifier = identifier;
            Value = value;
            Type = type;
        }};

        symbolTable.Insert(node, identifier, var);
        return null;
    }

    @Override
    public Object Visit(DivisionNode node)
    {
        String left = (String)node.LeftChild.Accept(this);
        String right = (String)node.RightChild.Accept(this);

        return left + " / " + right;
    }

    @Override
    public Object Visit(ElseIfNode node)
    {
        node.Predicate.Accept(this);

        symbolTable.CreateScope(node);
        //System.out.println("Opened an ElseIf (" + node.LineNumber + ")");

        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }

        for (String s : symbolTable.CurrentOpenScope.Variables.keySet())
        {
            //System.out.println("    " + s);
        }

        symbolTable.CloseScope();
        //System.out.println("Closed an ElseIf (" + node.LineNumber + ")");

        if(node.Alternative != null)
            node.Alternative.Accept(this);

        return null;
    }

    @Override
    public Object Visit(ElseNode node)
    {
        symbolTable.CreateScope(node);
        //System.out.println("Opened an else (" + node.LineNumber + ")");

        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }

        for (String s : symbolTable.CurrentOpenScope.Variables.keySet())
        {
            //System.out.println("    " + s);
        }

        symbolTable.CloseScope();
        //System.out.println("Closed an else (" + node.LineNumber + ")");

        return null;
    }

    @Override
    public Object Visit(EqualsNode node)
    {
        node.Left.Accept(this);
        node.Right.Accept(this);

        return null;
    }

    @Override
    public Object Visit(FloatNode node)
    {
        return floatType;
    }

    @Override
    public Object Visit(ForNode node)
    {
        symbolTable.CreateScope(node);
        //System.out.println("Opened a for (" + node.LineNumber + ")");

        node.Var.Accept(this);
        node.Predicate.Accept(this);
        node.Increment.Accept(this);

        for (StatementsNode childNode : node.body)
        {
            childNode.Accept(this);
        }

        for (String s : symbolTable.CurrentOpenScope.Variables.keySet())
        {
            //System.out.println("    " + s);
        }

        symbolTable.CloseScope();
        //System.out.println("Closed a for (" + node.LineNumber + ")");

        return null;
    }

    @Override
    public Object Visit(final FunctionNode node)
    {
        symbolTable.CreateScope(node);
        //System.out.println("Opened a function (" + node.LineNumber + ")");

        final List<String[]> parameters = new ArrayList<String[]>();
        for (ParameterNode childNode: node.Parameters)
        {
            childNode.Accept(this);
            parameters.add(new String[] {childNode.Identifier.Value, childNode.Type});
        }

        for (StatementsNode childNode: node.Body)
        {
            childNode.Accept(this);
        }

        if (SymbolTable.FunctionList.get(node.Identifier.Value) != null)
        {
            CustomErrorHandler.FireInstantError(new SemanticError(node, "Compile Error: Tried to create a method with a already existing identifier " + node.Identifier.Value));
        }
        else
        {
            SymbolTable.FunctionList.put(node.Identifier.Value, new FunctionVariable() {{
                Identifier = node.Identifier.Value;
                Type = node.ReturnType;
                Parameters = parameters;
            }});
        }

        for (String s : symbolTable.CurrentOpenScope.Variables.keySet())
        {
            //System.out.println("    " + s);
        }

        symbolTable.CloseScope();
        //System.out.println("Closed a function (" + node.LineNumber + ")");

        return null;
    }

    @Override
    public Object Visit(GreaterOrEqualNode node)
    {
        node.Left.Accept(this);
        node.Right.Accept(this);

        return null;
    }

    @Override
    public Object Visit(GreaterThanNode node)
    {
        node.Left.Accept(this);
        node.Right.Accept(this);

        return null;
    }

    @Override
    public Object Visit(IdentifierNode node)
    {
        return node.toString();
    }

    @Override
    public Object Visit(IfNode node)
    {
        symbolTable.CreateScope(node);
        //System.out.println("Opened an if (" + node.LineNumber + ")");

        node.Predicate.Accept(this);
        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }

        for (String s : symbolTable.CurrentOpenScope.Variables.keySet())
        {
            //System.out.println("    " + s);
        }

        symbolTable.CloseScope();
        //System.out.println("Closed an if (" + node.LineNumber + ")");

        if(node.Alternative != null)
            node.Alternative.Accept(this);

        return null;
    }

    @Override
    public Object Visit(IfOrElseNode node)
    {
        return null;
    }

    @Override
    public Object Visit(IntNode node)
    {
        return intType;
    }

    @Override
    public Object Visit(IoStatusNode node)
    {
        return String.valueOf(node.Value);
    }

    @Override
    public Object Visit(LessOrEqualNode node)
    {
        node.Left.Accept(this);
        node.Right.Accept(this);

        return null;
    }

    @Override
    public Object Visit(LessThanNode node)
    {
        node.Left.Accept(this);
        node.Right.Accept(this);

        return null;
    }

    @Override
    public Object Visit(LogicalAndNode node)
    {
        node.Left.Accept(this);
        node.Right.Accept(this);

        return null;
    }

    @Override
    public Object Visit(LogicalOrNode node)
    {
        node.Left.Accept(this);
        node.Right.Accept(this);

        return null;
    }

    @Override
    public Object Visit(MonthNode node)
    {
        return monthType;
    }

    @Override
    public Object Visit(MultiplicationNode node)
    {
        String left = (String)node.LeftChild.Accept(this);
        String right = (String)node.RightChild.Accept(this);

        return left + " * " + right;
    }

    @Override
    public Object Visit(NegateNode node)
    {
        node.child.Accept(this);

        return null;
    }

    @Override
    public Object Visit(NotEqualsNode node)
    {
        node.Left.Accept(this);
        node.Right.Accept(this);

        return null;
    }

    @Override
    public Object Visit(ParameterNode node)
    {
        final String identifier = (String)node.Identifier.Accept(this);
        final String type = node.Type;

        Variable var = new IdentifierVariable()
        {{
            Identifier = identifier;
            Type = type;
            Value = null;
        }};

        symbolTable.Insert(node, identifier, var);

        return null;
    }

    @Override
    public Object Visit(PercentNode node)
    {
        return percentageType;
    }

    @Override
    public Object Visit(PerformTimesNode node)
    {
        symbolTable.CreateScope(node);
        //System.out.println("Opened a perform (" + node.LineNumber + ")");

        node.value.Accept(this);

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        for (String s : symbolTable.CurrentOpenScope.Variables.keySet())
        {
            //System.out.println("    " + s);
        }

        symbolTable.CloseScope();
        //System.out.println("Closed a perform (" + node.LineNumber + ")");

        return null;
    }

    @Override
    public Object Visit(PerformUntilNode node)
    {
        symbolTable.CreateScope(node);
        //System.out.println("Opened a perform (" + node.LineNumber + ")");

        node.Predicate.Accept(this);

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        for (String s : symbolTable.CurrentOpenScope.Variables.keySet())
        {
            //System.out.println("    " + s);
        }

        symbolTable.CloseScope();
        //System.out.println("Closed a perform (" + node.LineNumber + ")");

        return null;
    }

    @Override
    public Object Visit(final PinDeclarationNode node)
    {
        final String identifier = (String)node.Identifier.Accept(this);
        final PinNode pin = (PinNode)node.Pin.Accept(this);
        final String IOType = (String)node.IoStatus.Accept(this);

        Variable var = new PinVariable()
        {{
            Identifier = identifier;
            Value = String.valueOf(pin.Value);
            Type = pin.Type;
            IOStatus = IOType;
        }};

        if(symbolTable.CurrentOpenScope == symbolTable)
            symbolTable.Insert(node, "house." + identifier, var);
        else
            symbolTable.Insert(node, identifier, var);

        return null;
    }

    @Override
    public PinNode Visit(final DigitalPinNode node)
    {
        return new DigitalPinNode()
        {{
            Value = node.Value;
            Type = boolType;
        }};
    }

    @Override
    public Object Visit(final AnalogPinNode node)
    {
        return new AnalogPinNode()
        {{
            Value = node.Value;
            Type = intType;
        }};
    }


    @Override
    public Object Visit(ReturnNode node)
    {
        node.Value.Accept(this);

        return null;
    }

    @Override
    public Object Visit(RoomDeclaration node)
    {
        final String identifier = (String)node.Identifier.Accept(this);
        final String type = "room";

        ScopeVariable var = new ScopeVariable()
        {{
            Identifier = identifier;
            Type = type;
            Value = new SymbolTable()
            {{
                Variables = new HashMap<String, Variable>(symbolTable.Variables);
                ParrentScope = symbolTable.CurrentOpenScope;
            }};
        }};

        symbolTable.Insert(node, identifier, var);
        symbolTable.OpenScope(var.Value);
        //System.out.println("Opened a room (" + node.LineNumber + ")");

        for (RoomBlockNode childNode : node.body)
        {
            childNode.Accept(this);
        }

        for (String s : symbolTable.CurrentOpenScope.Variables.keySet())
        {
            //System.out.println("    " + s);
        }

        symbolTable.CloseScope();
        //System.out.println("Closed a room (" + node.LineNumber + ")");

        return null;
    }

    @Override
    public Object Visit(RootNode node)
    {
        node.Setup.Accept(this);

        for (FunctionsNode childNode: node.Functions)
        {
            childNode.Accept(this);
        }

        return null;
    }

    @Override
    public Object Visit(SetupNode node)
    {
        for (DefinitionNode childNode: node.Childs)
        {
            childNode.Accept(this);
        }

        return null;
    }

    @Override
    public Object Visit(StringNode node)
    {
        return stringType;
    }

    @Override
    public Object Visit(SubtractiveNode node)
    {
        String left = (String) node.LeftChild.Accept(this);
        String right = (String) node.RightChild.Accept(this);

        return left + " - " + right;
    }

    @Override
    public Object Visit(SwitchNode node)
    {
        node.expression.Accept(this);

        for (CaseNode caseNode : node.Body)
        {
            caseNode.Accept(this);
        }

        if(node.defaultCase != null)
            node.defaultCase.Accept(this);

        return null;
    }

    @Override
    public Object Visit(TimeNode node)
    {
        return timeType;
    }

    @Override
    public Object Visit(WhenNode node)
    {
        symbolTable.CreateScope(node);
        //System.out.println("Opened a when scope(" + node.LineNumber + ")");

        node.Predicate.Accept(this);

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        for (String s : symbolTable.CurrentOpenScope.Variables.keySet())
        {
            //System.out.println("    " + s);
        }

        symbolTable.CloseScope();
        //System.out.println("Closed a when (" + node.LineNumber + ")");

        return null;
    }

    @Override
    public Object Visit(WhileNode node)
    {
        symbolTable.CreateScope(node);
        //System.out.println("Opened a While (" + node.LineNumber + ")");

        node.Predicate.Accept(this);

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        for (String s : symbolTable.CurrentOpenScope.Variables.keySet())
        {
            //System.out.println("    " + s);
        }

        symbolTable.CloseScope();
        //System.out.println("Closed a while (" + node.LineNumber + ")");

        return null;
    }

    @Override
    public Object Visit(HouseNode node)
    {
        return node.Identifier.Accept(this);
    }

    @Override
    public Object Visit(MethodCallNode node)
    {
        node.identifier.Accept(this);

        for (ExpressionNode expression : node.expressions)
        {
            String id = null;

            if (expression instanceof HouseNode)
                id = (String)((HouseNode) expression).Identifier.Accept(this);
            else if (expression instanceof IdentifierNode)
                id = ((IdentifierNode) expression).Value;
            else
                expression.Accept(this);


            if (id != null)
            {
                String[] split = id.split("\\.");

                if (split.length > 2 && !symbolTable.GetScope(split[1]).LookUp(split[2]))
                    CustomErrorHandler.AddError(new SemanticError(expression, "Tired to send non-existing identifier " + id + " as parameter"));
                else if (split.length < 2 && !symbolTable.LookUp(id))
                    CustomErrorHandler.AddError(new SemanticError(expression, "Tired to send non-existing identifier " + id + " as parameter"));

            }
        }

        return null;
    }

    @Override
    public Object Visit(ModuloNode node)
    {
        String left = (String)node.LeftChild.Accept(this);
        String right = (String)node.RightChild.Accept(this);

        return left + " % " + right;
    }
}

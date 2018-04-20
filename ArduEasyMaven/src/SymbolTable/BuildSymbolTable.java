package SymbolTable;

import AST.Nodes.*;
import ErrorHandler.ErrorHandler;
import ErrorHandler.Errors.SemanticError;
import SymbolTable.Variables.ArrayVariable;
import SymbolTable.Variables.IdentifierVariable;
import SymbolTable.Variables.ScopeVariable;
import SymbolTable.Variables.Variable;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuildSymbolTable implements Visitor
{
    private SymbolTable symbolTable = new SymbolTable();
    private String room;

    @Override
    public Object Visit(AdditiveNode node)
    {
        String left = (String)node.LeftChild.Accept(this);
        String right = (String)node.RightChild.Accept(this);

        return left + " + " + right;
    }

    @Override
    public Object Visit(AnalogPinNode node)
    {
        return "A " + node.Value;
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

        if (temp.length > 2 && symbolTable.GetScope(temp[1]).GetTypeofVariable(node,temp[2]).equals("array"))
        {

            List<String> things = ((ArrayVariable) symbolTable.GetScope(temp[1]).Variables.get(temp[2])).Value();

            for (String thing : things)
            {
                if (!thing.equals(temp[2]))
                    symbolTable.GetScope(temp[1]).Update(node, thing, value);
            }
        } else
            symbolTable.Update(node, identifier, value);

        return null;
    }

    @Override
    public Object Visit(BoolNode node)
    {
        return node.toString();
    }

    @Override
    public Object Visit(CaseNode node)
    {
        symbolTable.CreateScope(node);
        System.out.println("Opened a case scope");

        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();
        System.out.println("Closed a case scope");
        return null;
    }

    @Override
    public Object Visit(DayNode node)
    {
        return node.toString();
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
    public Object Visit(DigitalPinNode node)
    {
        return String.valueOf(node.Value);
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
        System.out.println("Opened an ElseIf scope");

        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }
        node.Alternative.Accept(this);

        symbolTable.CloseScope();
        System.out.println("Closed an ElseIf scope");

        return null;
    }

    @Override
    public Object Visit(ElseNode node)
    {
        symbolTable.CreateScope(node);
        System.out.println("Opened an else scope");

        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();
        System.out.println("Closed an else scope");

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
        return node.toString();
    }

    @Override
    public Object Visit(ForNode node)
    {
        symbolTable.CreateScope(node);
        System.out.println("Opened a for scope");

        node.Var.Accept(this);
        node.Predicate.Accept(this);
        node.Increment.Accept(this);

        for (StatementsNode childNode : node.body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();
        System.out.println("Closed a for scope");

        return null;
    }

    @Override
    public Object Visit(FunctionNode node)
    {
        symbolTable.CreateScope(node);
        System.out.println("Opened a function scope");

        for (ParameterNode childNode: node.Parameters)
        {
            childNode.Accept(this);
        }

        for (StatementsNode childNode: node.Body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();
        System.out.println("Closed a function scope");

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
        System.out.println("Opened an if scope");

        node.Predicate.Accept(this);
        if(node.Alternative != null)
            node.Alternative.Accept(this);
        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();
        System.out.println("Closed an if scope");

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
        return node.toString();
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
        return node.toString();
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
        node.Identifier.Accept(this);

        return null;
    }

    @Override
    public Object Visit(PercentNode node)
    {
        return node.toString();
    }

    @Override
    public Object Visit(PerformTimes node)
    {
        symbolTable.CreateScope(node);
        System.out.println("Opened a perform scope");

        node.value.Accept(this);

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();
        System.out.println("Closed a perform scope");

        return null;
    }

    @Override
    public Object Visit(PerformUntil node)
    {
        symbolTable.CreateScope(node);
        System.out.println("Opened a perform scope");

        node.Predicate.Accept(this);

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();
        System.out.println("Closed a perform scope");

        return null;
    }

    @Override
    public Object Visit(PinDeclarationNode node)
    {
        final String identifier = (String)node.Identifier.Accept(this);
        final String value = (String)node.Pin.Accept(this);
        final String type = (String)node.IoStatus.Accept(this);

        Variable var = new IdentifierVariable()
        {{
            Identifier = identifier;
            Value = value;
            Type = type;
        }};

        if(symbolTable.CurrentOpenScope == symbolTable)
            symbolTable.Insert(node, "house." + identifier, var);
        else
            symbolTable.Insert(node, identifier, var);

        return null;
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
        room = identifier;

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
        System.out.println("Opened a room scope");

        for (RoomBlockNode childNode : node.body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();
        System.out.println("Closed a room scope");

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
        return node.toString();
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
        return node.toString();
    }

    @Override
    public Object Visit(WhenNode node)
    {
        symbolTable.CreateScope(node);
        System.out.println("Opened a when scope");

        node.Predicate.Accept(this);

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();
        System.out.println("Closed a when scope");

        return null;
    }

    @Override
    public Object Visit(WhileNode node)
    {
        symbolTable.CreateScope(node);
        System.out.println("Opened a While scope");

        node.Predicate.Accept(this);

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();
        System.out.println("Closed a while scope");

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

            if (id != null && !symbolTable.LookUp(id))
                ErrorHandler.FireInstantError(new SemanticError(expression,"Compile Error: Tried to send non-existing identifier: " + ((IdentifierNode)expression).Value + " as param"));
        }

        return null;
    }
}

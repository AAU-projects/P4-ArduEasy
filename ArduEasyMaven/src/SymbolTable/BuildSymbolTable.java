package SymbolTable;

import AST.Nodes.*;
import visitor.Visitor;

import java.util.ArrayList;

public class BuildSymbolTable implements Visitor
{
    private SymbolTable symbolTable = new SymbolTable();

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

        Variable var = new Variable()
        {{
            Identifier = identifier;
            Type = type;
            Values = values;
        }};

        symbolTable.Insert(identifier, var);
        return null;
    }

    @Override
    public Object Visit(AssignmentNode node)
    {
        final String identifier = (String)node.Identifier.Accept(this);
        final ArrayList<String> values = new ArrayList<String>();
        final String value = (String)node.Value.Accept(this);

        values.add(value);
        symbolTable.Update(identifier, values);
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
        symbolTable.CreateScope();

        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();
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

        Variable var = new Variable()
        {{
            Identifier = identifier;
            Values.add(value);
            Type = type;
        }};

        symbolTable.Insert(identifier, var);
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

        symbolTable.CreateScope();

        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }
        node.Alternative.Accept(this);

        symbolTable.CloseScope();

        return null;
    }

    @Override
    public Object Visit(ElseNode node)
    {
        symbolTable.CreateScope();

        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();

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
        symbolTable.CreateScope();

        node.Predicate.Accept(this);
        node.Increment.Accept(this);
        node.Var.Accept(this);
        for (StatementsNode childNode : node.body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();

        return null;
    }

    @Override
    public Object Visit(FunctionNode node)
    {
        symbolTable.CreateScope();

        for (ParameterNode childNode: node.Parameters)
        {
            childNode.Accept(this);
        }

        for (StatementsNode childNode: node.Body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();

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
        symbolTable.CreateScope();

        node.Predicate.Accept(this);
        node.Alternative.Accept(this);
        for (StatementsNode childNode : node.Body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();

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
        symbolTable.CreateScope();

        node.value.Accept(this);

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();

        return null;
    }

    @Override
    public Object Visit(PerformUntil node)
    {
        symbolTable.CreateScope();

        node.Predicate.Accept(this);

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();

        return null;
    }

    @Override
    public Object Visit(PinDeclarationNode node)
    {
        final String identifier = (String)node.Identifier.Accept(this);
        final String value = (String)node.Pin.Accept(this);
        final String type = (String)node.IoStatus.Accept(this);

        Variable var = new Variable()
        {{
            Identifier = identifier;
            Values.add(value);
            Type = type;
        }};

        symbolTable.Insert(identifier, var);

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

        Variable var = new Variable()
        {{
            Identifier = identifier;
            Type = type;
        }};

        symbolTable.Insert(identifier, var);
        symbolTable.CreateScope();

        for (RoomBlockNode childNode : node.body)
        {
            childNode.Accept(this);
        }

        symbolTable.CloseScope();

        return null;
    }

    @Override
    public Object Visit(RootNode node)
    {
        symbolTable.CreateScope();

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
        symbolTable.CreateScope();

        node.Predicate.Accept(this);

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
        symbolTable.CreateScope();

        node.Predicate.Accept(this);

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        symbolTable.CloseScope();

        return null;
    }

    @Override
    public Object Visit(HouseNode node)
    {
        node.Identifiers.Accept(this);

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

package CodeGeneration;

import AST.Nodes.*;
import SymbolTable.SymbolTable;
import visitor.Visitor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class BuildCode implements Visitor
{
    private PrintWriter writer;
    private HashMap<String, String> pinMap = new HashMap<String, String>();
    private String room;
    private int indent = 0; //Used to indent statements
    private StringBuilder strB = new StringBuilder();

    public BuildCode(PrintWriter filewriter)
    {
        writer = filewriter;
    }

    private void IncreaseIndent()
    {
        indent += 4;
    }

    private void DeacreaseIndent()
    {
        indent -= 4;
    }

    private void Addtext(String input)
    {
        for (int i = 0; i < indent; i++)
            strB.append(" ");

        strB.append(input);
    }

    private void Addtextln(String input)
    {
        for (int i = 0; i < indent; i++)
            strB.append(" ");

        strB.append(input).append(System.getProperty("line.separator"));
    }

    @Override
    public Object Visit(ParanNode node)
    {
        return "(" + node.child.Accept(this) + ")";
    }

    @Override
    public Object Visit(AdditiveNode node)
    {
        return node.LeftChild.Accept(this) + " + " + node.RightChild.Accept(this);
    }

    @Override
    public Object Visit(AnalogPinNode node)
    {
        return null;
    }

    @Override
    public Object Visit(ArrayDeclarationNode node)
    {
        String result = "int " + room + "_" + node.Identifier.Accept(this) + "[] = {";
        int i = 1;

        for (IdentifierNode value : node.Values)
        {
            if(value.toString().equals(node.Identifier.Value))
                continue;

            result += pinMap.get(value.toString());

            if(i++ < node.Values.size() - 1)
                result += ", ";
        }

        result += "};";

        Addtextln(result);

        return null;
    }

    @Override
    public Object Visit(AssignmentNode node)
    {
        Addtextln(node.Identifier.Accept(this) + " = " + node.Value.Accept(this) + ";");
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
        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        return null;
    }

    @Override
    public Object Visit(DayNode node)
    {
        return node.Value;
    }

    @Override
    public Object Visit(DeclarationNode node)
    {
        String type;
        String value;

        if(node.Type.equals("string") || node.Type.equals("time") || node.Type.equals("day") || node.Type.equals("month"))
            type = "String";
        else
            type = node.Type;

        if(node.Value instanceof TimeNode || node.Value instanceof DayNode || node.Value instanceof StringNode || node.Value instanceof MonthNode)
            value = "\""+ node.Value.toString() + "\"";
        else
            value = (String)node.Value.Accept(this);

        Addtextln(type + " " + node.Identifier.Accept(this) + " = " + value + ";");
        return null;
    }

    @Override
    public Object Visit(DigitalPinNode node)
    {
        return null;
    }

    @Override
    public Object Visit(DivisionNode node)
    {
        return node.LeftChild.Accept(this) + " / " + node.RightChild.Accept(this);
    }

    @Override
    public Object Visit(ElseIfNode node)
    {
        Addtextln("else if(" + node.Predicate.Accept(this) + ")");
        Addtextln("{");
        IncreaseIndent();

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        DeacreaseIndent();

        Addtextln("}");

        node.Alternative.Accept(this);
        return null;
    }

    @Override
    public Object Visit(ElseNode node)
    {
        Addtextln("else");
        Addtextln("{");
        IncreaseIndent();

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        DeacreaseIndent();
        Addtextln("}");
        return null;
    }

    @Override
    public Object Visit(EqualsNode node)
    {
        return node.Left.Accept(this) + " == " + node.Right.Accept(this);
    }

    @Override
    public Object Visit(FloatNode node)
    {
        return node.Value;
    }

    @Override
    public Object Visit(ForNode node)
    {
        Addtextln("for (" + node.Var.Accept(this) + "; " + node.Predicate.Accept(this) + "; " + node.Increment.Accept(this) + ")");
        Addtextln("{");
        IncreaseIndent();

        for (StatementsNode statementsNode : node.body)
        {
            statementsNode.Accept(this);
        }

        DeacreaseIndent();
        Addtextln("}");

        return null;
    }

    @Override
    public Object Visit(FunctionNode node)
    {
        Addtext(node.ReturnType + node.Identifier.Accept(this) + "(");

        int i = 1;

        for (ParameterNode parameter : node.Parameters)
        {
            Addtext(parameter.Accept(this).toString());

            if(i++ < node.Parameters.size())
                Addtext(", ");
        }

        Addtextln(")");
        Addtextln("{");
        IncreaseIndent();

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        DeacreaseIndent();
        Addtextln("}");

        return null;
    }

    @Override
    public Object Visit(GreaterOrEqualNode node)
    {
        return node.Left.Accept(this) + " >= " + node.Right.Accept(this);
    }

    @Override
    public Object Visit(GreaterThanNode node)
    {
        return node.Left.Accept(this) + " > " + node.Right.Accept(this);
    }

    @Override
    public Object Visit(IdentifierNode node)
    {
        return node.Value;
    }

    @Override
    public Object Visit(IfNode node)
    {
        Addtextln("if (" + node.Predicate.Accept(this) + ")");
        Addtextln("{");
        IncreaseIndent();

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        DeacreaseIndent();
        Addtextln("}");
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
        return node.Value;
    }

    @Override
    public Object Visit(LessOrEqualNode node)
    {
        return node.Left.Accept(this) + " <= " + node.Right.Accept(this);
    }

    @Override
    public Object Visit(LessThanNode node)
    {
        return node.Left.Accept(this) + " < " + node.Right.Accept(this);
    }

    @Override
    public Object Visit(LogicalAndNode node)
    {
        return node.Left.Accept(this) + " && " + node.Right.Accept(this);
    }

    @Override
    public Object Visit(LogicalOrNode node)
    {
        return node.Left.Accept(this) + " || " + node.Right.Accept(this);
    }

    @Override
    public Object Visit(MonthNode node)
    {
        return node.Value;
    }

    @Override
    public Object Visit(MultiplicationNode node)
    {
        return node.LeftChild.Accept(this) + " * " + node.RightChild.Accept(this);
    }

    @Override
    public Object Visit(NegateNode node)
    {
        return "!" + node.child.Accept(this);
    }

    @Override
    public Object Visit(NotEqualsNode node)
    {
        return node.Left.Accept(this) + " != " + node.Right.Accept(this);
    }

    @Override
    public Object Visit(ParameterNode node)
    {
        return node.Type + " " + node.Identifier;
    }

    @Override
    public Object Visit(PercentNode node)
    {
        return String.valueOf(node.Value/100 * 255);
    }

    @Override
    public Object Visit(PerformTimes node)
    {
        String identifier = UUID.randomUUID().toString();
        Addtextln("for (int " + identifier + " = 0; " + identifier + " < " + node.value.Accept(this) + "; " + identifier + "++");
        Addtextln("{");
        IncreaseIndent();

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        DeacreaseIndent();
        Addtextln("}");

        return null;
    }

    @Override
    public Object Visit(PerformUntil node)
    {
        Addtextln("while (" + node.Predicate.Accept(this) + ")");
        Addtextln("{");
        IncreaseIndent();

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        DeacreaseIndent();
        Addtextln("}");
        return null;
    }

    @Override
    public Object Visit(PinDeclarationNode node)
    {
        Addtextln("pinMode(" + node.Pin.Value + ", " + node.IoStatus.Value + ");");
        pinMap.put(node.Identifier.toString(), String.valueOf(node.Pin.Value));
        return null;
    }

    @Override
    public Object Visit(ReturnNode node)
    {
        return node.Value.Accept(this);
    }

    @Override
    public Object Visit(RoomDeclaration node)
    {
        room = node.Identifier.Accept(this).toString();

        for (RoomBlockNode roomBlockNode : node.body)
        {
            if(!(roomBlockNode instanceof ArrayDeclarationNode))
                roomBlockNode.Accept(this);
        }
        return null;
    }

    @Override
    public Object Visit(RootNode node)
    {
        node.Setup.Accept(this);

        Addtextln("void loop()");
        Addtextln("{");
        IncreaseIndent();

        for (FunctionsNode function : node.Functions)
        {
            if(function instanceof WhenNode)
                function.Accept(this);
        }

        DeacreaseIndent();
        Addtextln("}");
        Addtextln("");

        for (FunctionsNode function : node.Functions)
        {
            if(!(function instanceof WhenNode))
                function.Accept(this);
        }

        System.out.println(strB);

        return null;
    }

    @Override
    public Object Visit(SetupNode node)
    {
        //First we add the global variables,
        for (DefinitionNode child : node.Childs)
        {
            if(child instanceof DeclarationNode)
                child.Accept(this);

            if(child instanceof RoomDeclaration)
            {
                room = child.Identifier.toString();

                for (Object grandchild : ((RoomDeclaration) child).body)
                {
                    if(grandchild instanceof ArrayDeclarationNode)
                        ((ArrayDeclarationNode) grandchild).Accept(this);
                }
            }
        }

        //Then we open the setup block
        Addtextln("");
        Addtextln("void setup()");
        Addtextln("{");
        IncreaseIndent();

        //We then add all the pin declerations
        for (DefinitionNode child : node.Childs)
        {
            if(!(child instanceof DeclarationNode))
                child.Accept(this);
        }

        DeacreaseIndent();
        Addtextln("}");
        Addtextln("");

        return null;
    }

    @Override
    public Object Visit(StringNode node)
    {
        return node.Value;
    }

    @Override
    public Object Visit(SubtractiveNode node)
    {
        return node.LeftChild.Accept(this) + " - " + node.RightChild.Accept(this);
    }

    @Override
    public Object Visit(SwitchNode node)
    {
        boolean first = true;

        for (CaseNode caseNode : node.Body)
        {
            if (first)
            {
                Addtextln("if (" + node.expression.Accept(this) + " == " + caseNode.Value + ")");
                Addtextln("{");
                IncreaseIndent();
                caseNode.Accept(this);
                DeacreaseIndent();
                Addtextln("}");
                first = false;
            }
            else
            {
                Addtextln("else if (" + node.expression.Accept(this) + " == " + caseNode.Value +")");
                Addtextln("{");
                IncreaseIndent();
                caseNode.Accept(this);
                DeacreaseIndent();
                Addtextln("}");
            }
        }
        if(node.defaultCase != null)
        {
            Addtextln("else");
            Addtextln("{");
            IncreaseIndent();
            node.defaultCase.Accept(this);
            DeacreaseIndent();
            Addtextln("}");
        }

        return null;
    }

    @Override
    public Object Visit(TimeNode node)
    {
        return node.Value;
    }

    @Override
    public Object Visit(WhenNode node)
    {
        Addtextln("if (" + node.Predicate.Accept(this) + ")");
        Addtextln("{");
        IncreaseIndent();

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        DeacreaseIndent();
        Addtextln("}");
        Addtextln("");

        return null;
    }

    @Override
    public Object Visit(WhileNode node)
    {
        Addtextln("while (" + node.Predicate.Accept(this) + ")");
        Addtextln("{");
        IncreaseIndent();

        for (StatementsNode statementsNode : node.Body)
        {
            statementsNode.Accept(this);
        }

        DeacreaseIndent();
        Addtextln("}");
        return null;
    }

    @Override
    public Object Visit(HouseNode node)
    {
        String[] split = node.Identifier.toString().split("\\.");

        if(split.length == 2)
            return split[0] + "_" + split[1];
        else if(split.length == 3)
            return split[0] + "_" + split[1] + "_" + split[2];

        return null;
    }

    @Override
    public Object Visit(MethodCallNode node)
    {
        Addtext(node.identifier.Accept(this) + "(");

        int i = 1;

        for (ExpressionNode expression : node.expressions)
        {
            expression.Accept(this);

            if(i++ != node.expressions.size())
                Addtext(", ");
        }

        Addtextln(");");
        return null;
    }
}

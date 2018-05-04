package CodeGeneration;

import AST.Nodes.*;
import visitor.Visitor;
import java.io.PrintWriter;
import java.util.*;

public class BuildCode implements Visitor
{
    private PrintWriter writer;
    private HashMap<String, String> pinMap = new HashMap<String, String>();
    private HashMap<String, List<String>> arrayList = new HashMap<String, List<String>>();
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

    private String ReadPin(String pin)
    {
        return (pin.contains("A") ? "analogRead" : "digitalRead") + "(" + pin + ")";
    }

    private String ReadPin(Object node)
    {
        if(!(node instanceof ExpressionNode)) return null;

        String identifier = (String)((ExpressionNode)node).Accept(this);
        if(node instanceof IdentifierNode)
            return pinMap.containsKey(identifier) ? ReadPin(pinMap.get(identifier)) : identifier;

        return identifier;
    }

    @Override
    public Object Visit(ParanNode node)
    {
        return "(" + ReadPin(node.child) + ")";
    }

    @Override
    public Object Visit(AdditiveNode node)
    {
        return ReadPin(node.LeftChild) + " + " + ReadPin(node.RightChild);
    }

    @Override
    public Object Visit(AnalogPinNode node)
    {
        return ReadPin("A" + node.Value);
    }

    @Override
    public Object Visit(ArrayDeclarationNode node)
    {
        String result = "int " + "house_" + room + "_" + node.Identifier.Accept(this) + "[] = {";
        int i = 1;

        List<String> templist = new ArrayList<String>();

        for (IdentifierNode value : node.Values)
        {
            if(value.toString().equals(node.Identifier.Value))
                continue;

            templist.add(pinMap.get("house_" + room + "_" + value.toString()));
            result += pinMap.get("house_" + room + "_" + value.toString());

            if(i++ < node.Values.size() - 1)
                result += ", ";
        }

        arrayList.put("house_" + room + "_" + node.Identifier.Accept(this), templist);

        result += "};";

        Addtextln(result);

        return null;
    }

    @Override
    public Object Visit(AssignmentNode node)
    {
        String identifier = (String)node.Identifier.Accept(this);
        String realvalue = (String)node.Value.Accept(this);
        String value = pinMap.containsKey(identifier) ? ReadPin(pinMap.get(identifier)) : realvalue;

        if(pinMap.containsKey(identifier))
        {
            if(pinMap.get(identifier).contains("A"))
                Addtextln("analogWrite("+ pinMap.get(identifier) + ", " + realvalue + ");");
            else
                Addtextln("digitalWrite("+ pinMap.get(identifier) + ", " + realvalue + ");");
        }
        else if(arrayList.containsKey(identifier))
        {
            String writemode = arrayList.get(identifier).get(0).contains("A") ? "analogWrite" : "digitalWrite";
            String iterator = "i" + UUID.randomUUID().toString().replaceAll("-", "");
            Addtextln("for (int " + iterator + " = 0; " + iterator + " < " + arrayList.get(identifier).size() + "; " + iterator + "++)");
            Addtextln("{");
            IncreaseIndent();
            Addtextln(writemode + "(" + identifier.replaceAll("\\.", "_") + "[" + iterator + "], " + value + ");");
            DeacreaseIndent();
            Addtextln("}");
        }

        else
            Addtextln(identifier + " = " + value + ";");
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
        String identifier = (String)node.Identifier.Accept(this);
        String type;
        String value;

        if(node.Type.equals("string") || node.Type.equals("time") || node.Type.equals("day") || node.Type.equals("month"))
            type = "String";
        else
            type = node.Type;

        if(node.Value instanceof TimeNode || node.Value instanceof DayNode || node.Value instanceof StringNode || node.Value instanceof MonthNode)
            value = "\""+ node.Value.toString() + "\"";
        else
            value = pinMap.containsKey(identifier) ? ReadPin(pinMap.get(identifier)) : (String)node.Value.Accept(this);

        Addtextln(type + " " + identifier + " = " + value + ";");
        return null;
    }

    @Override
    public Object Visit(DigitalPinNode node)
    {
        return ReadPin(String.valueOf(node.Value));
    }

    @Override
    public Object Visit(DivisionNode node)
    {
        return ReadPin(node.LeftChild) + " / " + ReadPin(node.RightChild);
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
        return ReadPin(node.Left) + " == " + ReadPin(node.Right);
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
        return ReadPin(node.Left) + " >= " + ReadPin(node.Right);
    }

    @Override
    public Object Visit(GreaterThanNode node)
    {
        return ReadPin(node.Left) + " > " + ReadPin(node.Right);
    }

    @Override
    public Object Visit(IdentifierNode node)
    {
        return node.Value;
    }

    public Object Visit(IdentifierNode node, boolean read)
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
        return ReadPin(node.Left) + " <= " + ReadPin(node.Right);
    }

    @Override
    public Object Visit(LessThanNode node)
    {
        return ReadPin(node.Left) + " < " + ReadPin(node.Right);
    }

    @Override
    public Object Visit(LogicalAndNode node)
    {
        return ReadPin(node.Left) + " && " + ReadPin(node.Right);
    }

    @Override
    public Object Visit(LogicalOrNode node)
    {
        return ReadPin(node.Left) + " || " + ReadPin(node.Right);
    }

    @Override
    public Object Visit(MonthNode node)
    {
        return node.Value;
    }

    @Override
    public Object Visit(MultiplicationNode node)
    {
        return ReadPin(node.LeftChild) + " * " + ReadPin(node.RightChild);
    }

    @Override
    public Object Visit(NegateNode node)
    {
        return "!" + ReadPin(node.child);
    }

    @Override
    public Object Visit(NotEqualsNode node)
    {
        return ReadPin(node.Left) + " != " + ReadPin(node.Right);
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
        String identifier = "i" + UUID.randomUUID().toString().replaceAll("-", "");
        Addtextln("for (int " + identifier + " = 0; " + identifier + " < " + node.value.Accept(this) + "; " + identifier + "++)");
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
        String pin = node.Pin instanceof AnalogPinNode ? "A" : "";
        pin += node.Pin.Value;
        Addtextln("pinMode(" + pin + ", " + node.IoStatus.Value.toUpperCase() + ");");
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

        //We then add all the pin declerations
        for (DefinitionNode child : node.Childs)
        {
            if(child instanceof PinDeclarationNode)
            {
                String identifier = ((PinDeclarationNode) child).Identifier.Value;
                String pin = (((PinDeclarationNode) child).Pin instanceof AnalogPinNode) ? "A" : "";
                pin += String.valueOf(((PinDeclarationNode) child).Pin.Value);
                pinMap.put("house_" + identifier, pin);

            }

            if(child instanceof RoomDeclaration)
            {
                room = child.Identifier.toString();

                for (Object grandchild : ((RoomDeclaration) child).body)
                {
                    if(grandchild instanceof PinDeclarationNode)
                    {
                        String identifier = ((PinDeclarationNode) grandchild).Identifier.Value;
                        String pin = (((PinDeclarationNode) grandchild).Pin instanceof AnalogPinNode) ? "A" : "";
                        pin += String.valueOf(((PinDeclarationNode) grandchild).Pin.Value);
                        pinMap.put("house_" + room + "_" + identifier, pin);
                    }
                }
            }
        }

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
        return ReadPin(node.LeftChild) + " - " + ReadPin(node.RightChild);
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
        String[] split = ((String)node.Identifier.Accept(this)).split("\\.");

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

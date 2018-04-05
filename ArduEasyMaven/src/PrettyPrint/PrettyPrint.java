package PrettyPrint;

import AST.Nodes.*;
import visitor.Visitor;

import java.util.List;

public class PrettyPrint implements Visitor
{
    private int tabsIndent = 0; // increase or decrease this int to indent the code
    //tabindent should increase after {
    //tabindent should decrease before }
    //first printIndent and then system.out.print or printIndentln to print

    @Override
    public Object Visit(AdditiveNode node) {
        node.LeftChild.Accept(this);
        System.out.print(" + ");
        node.RightChild.Accept(this);
        return null;
    }

    @Override
    public Object Visit(AnalogPinNode node) {
        System.out.print("A ");
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(ArrayDeclarationNode node) {
        printIndent("");
        node.Identifier.Accept(this);
        System.out.print(" = {");

        List<IdentifierNode> arrayValues = node.Values;
        arrayValues.remove(0);

        int valuesCounter = 0;
        for (IdentifierNode value : arrayValues)
        {
            if (valuesCounter++ != arrayValues.size() - 1)
            {
                value.Accept(this);
                System.out.print(", " );
            }
            else
            {
                value.Accept(this);
            }
        }
        System.out.print("}");

        return null;
    }

    @Override
    public Object Visit(AssignmentNode node) {
        if (node.indentPrettyPrint)
        {
            printIndent("");
        }

        node.Identifier.Accept(this);
        System.out.print(" = ");
        node.Value.Accept(this);

        if (node.indentPrettyPrint)
        {
            System.out.println();
        }

        return null;
    }

    @Override
    public Object Visit(BoolNode node) {
        System.out.print(node.Value); // just print ???
        return null;
    }

    @Override
    public Object Visit(CaseNode node) {
        if (!node.Value.equals("default")) //TODO get default token from grammar?
        {
            printIndent("case ");
            System.out.print(node.Value);
        }
        else
        {
            printIndent(node.Value);
        }
        System.out.println(":");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode Statement : node.Body )
        {
            Statement.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;

    }

    @Override
    public Object Visit(DayNode node) {
        System.out.print(node.Value); // just print ???
        return null;
    }

    @Override
    public Object Visit(DeclarationNode node) {
        if (node.indentPrettyPrint)
        {
            printIndent("");
        }

        System.out.print(node.Type + " ");
        node.Identifier.Accept(this);
        System.out.print(" = ");
        node.Value.Accept(this);

        if (node.indentPrettyPrint)
        {
            System.out.println();
        }
        return null;
    }

    @Override
    public Object Visit(DigitalPinNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(DivisionNode node) {
        node.LeftChild.Accept(this);
        System.out.print(" / ");
        node.RightChild.Accept(this);
        return null;
    }

    @Override
    public Object Visit(ElseIfNode node) {
        printIndent("else if (");
        node.Predicate.Accept(this);
        System.out.println(")");
        printIndentln("{ ");
        tabsIndent++;

        for (StatementsNode Statement : node.Body )
        {
            Statement.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        node.Alternative.Accept(this);

        return null;
    }

    @Override
    public Object Visit(ElseNode node) {
        printIndentln("else");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode Statement : node.Body )
        {
            Statement.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(EqualsNode node) {
        node.Left.Accept(this);
        System.out.print(" == ");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(FloatNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(ForNodeAssign node) {
        printIndent("for (");
        node.Var.indentPrettyPrint = false;
        node.Var.Accept(this);
        System.out.print("; ");
        node.Predicate.Accept(this);
        System.out.print("; ");
        node.Increment.indentPrettyPrint = false;
        node.Increment.Accept(this);
        System.out.println(")");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode Statement : node.body )
        {
            Statement.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(ForNodeDecl node) {
        printIndent("for (");
        node.Var.indentPrettyPrint = false;
        node.Var.Accept(this);
        System.out.print("; ");
        node.Predicate.Accept(this);
        System.out.print("; ");
        node.Increment.indentPrettyPrint = false;
        node.Increment.Accept(this);
        System.out.println(")");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode Statement : node.body )
        {
            Statement.Accept(this);
        }

        tabsIndent--;
        printIndentln("} ");

        return null;
    }

    @Override
    public Object Visit(FunctionNode node) {
        printIndent("function ");
        System.out.print(node.ReturnType + " ");
        node.Identifier.Accept(this);
        System.out.print("(");

        int parametersCounter = 0;
        for (ParameterNode parameter : node.Parameters)
        {
            if (parametersCounter++ != node.Parameters.size() - 1)
            {
                parameter.Accept(this);
                System.out.print(", " );
            }
            else
            {
                parameter.Accept(this);
            }
        }
        printIndentln(")" );
        printIndentln("{" );
        tabsIndent++;

        for (StatementsNode Statement : node.Body )
        {
            Statement.Accept(this);
        }

        if (node.Return != null) // return can be null if function is void
        {
            node.Return.Accept(this);
            System.out.println();
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(GreaterOrEqualNode node) {
        node.Left.Accept(this);
        System.out.print(" >= ");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(GreaterThanNode node) {
        node.Left.Accept(this);
        System.out.print(" > ");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(IdentifierNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(IfNode node) {
        printIndent("if(");
        node.Predicate.Accept(this);
        System.out.println(")");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode Statement : node.Body )
        {
            Statement.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        if (node.Alternative != null) // only accept if there is another else or else if node
        {
            node.Alternative.Accept(this);
        }



        return null;
    }

    @Override
    public Object Visit(IfOrElseNode node) {
        //TODO dont know what to do with this :) should this node be an abstract class?
        return null;
    }

    @Override
    public Object Visit(IntNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(IoStatusNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(LessOrEqualNode node) {
        node.Left.Accept(this);
        System.out.print(" <= ");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(LessThanNode node) {
        node.Left.Accept(this);
        System.out.print(" < ");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(LogicalAndNode node) {
        node.Left.Accept(this);
        System.out.print(" && ");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(LogicalOrNode node) {
        node.Left.Accept(this);
        System.out.print(" || ");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(MonthNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(MultiplicationNode node) {
        node.LeftChild.Accept(this);
        System.out.print(" * ");
        node.RightChild.Accept(this);
        return null;
    }

    @Override
    public Object Visit(NegateNode node) {
        System.out.print("!" + node.child.toString());
        return null;
    }

    @Override
    public Object Visit(NotEqualsNode node) {
        node.Left.Accept(this);
        System.out.print(" != ");
        node.Right.Accept(this);
        return null;
    }

    @Override
    public Object Visit(ParameterNode node) {
        System.out.print(node.Type + " ");
        node.Identifier.Accept(this);

        return null;
    }

    @Override
    public Object Visit(PercentNode node) {
        System.out.print(node.toString());

        return null;
    }

    @Override
    public Object Visit(PerformTimes node) {
        printIndent("perform ");
        node.value.Accept(this);
        System.out.println(" times");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");
        return null;
    }

    @Override
    public Object Visit(PerformUntil node) {
        printIndent("perform until (");
        node.Predicate.Accept(this);
        System.out.println(")");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(PinDeclarationNode node) {
        printIndent("");
        node.Identifier.Accept(this);
        System.out.print(" = PIN ");
        node.Pin.Accept(this);
        System.out.print(" as ");
        node.IoStatus.Accept(this);

        return null;
    }

    @Override
    public Object Visit(ReturnNode node) {
        printIndent("return ");
        System.out.print(node.Value.toString());
        return null;
    }

    @Override
    public Object Visit(RoomDeclaration node) {
        printIndent("room ");
        System.out.println(node.Identifier);
        printIndent("{");
        tabsIndent++;

        for (RoomBlockNode RoomBlock : node.body )
        {
            System.out.println();
            RoomBlock.Accept(this);
        }

        tabsIndent--;
        System.out.println();
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(RootNode node) {
        node.Setup.Accept(this);

        for (FunctionsNode function : node.Functions )
        {
            System.out.println();
            function.Accept(this);
        }

        return null;
    }

    @Override
    public Object Visit(SetupNode node) {
        printIndentln("Setup ");
        printIndent("{");
        tabsIndent++;
        for (DefinitionNode definition : node.Childs )
        {
            System.out.println();
            definition.Accept(this);
        }
        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(StringNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(SubtractiveNode node) {
        node.LeftChild.Accept(this);
        System.out.print(" - ");
        node.RightChild.Accept(this);
        return null;
    }

    @Override
    public Object Visit(SwitchNode node) {
        printIndent("switch (");
        node.expression.Accept(this);
        System.out.println(")");
        printIndentln("{");
        tabsIndent++;

        for (CaseNode caseN: node.Body)
        {
            caseN.Accept(this);
        }

        if (node.defaultCase != null)
        {
            node.defaultCase.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");
        return null;
    }

    @Override
    public Object Visit(TimeNode node) {
        System.out.print(node.Value);
        return null;
    }

    @Override
    public Object Visit(WhenNode node) {
        printIndent("When (");
        node.Predicate.Accept(this);
        printIndentln(")");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(WhileNode node) {
        printIndent("While (");
        node.Predicate.Accept(this);
        System.out.println(")");
        printIndentln("{");
        tabsIndent++;

        for (StatementsNode stmt : node.Body)
        {
            stmt.Accept(this);
        }

        tabsIndent--;
        printIndentln("}");

        return null;
    }

    @Override
    public Object Visit(HouseNode node)
    {
        System.out.print(node.Identifiers);
        return null;
    }

    @Override
    public Object Visit(MethodCallNode node) {
        System.out.print(node.identifier);
        System.out.print("(");

        int exprCounter = 0;
        for (ExpressionNode expr : node.expressions)
        {
            if (exprCounter++ != node.expressions.size() - 1)
            {
                expr.Accept(this);
                System.out.print(", " );
            }
            else
            {
                expr.Accept(this);
            }
        }

        System.out.print(")");

        return null;
    }

    private void Indent(int tabs)
    {
        for (int i = 0; i < tabs; i++){
            System.out.print("\t");
        }
    }

    private void printIndent(Object print)
    {
        Indent(tabsIndent);
        System.out.print(print);
    }

    private void printIndentln(Object print)
    {
        Indent(tabsIndent);
        System.out.println(print);
    }
}

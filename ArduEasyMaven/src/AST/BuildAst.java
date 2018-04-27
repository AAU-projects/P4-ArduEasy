package AST;

import AST.Nodes.*;
import java.util.ArrayList;
import java.util.List;
import antlr4.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class BuildAst extends ArduEasyBaseVisitor<Node>
{

    @Override
    public Node visitR(final ArduEasyParser.RContext ctx)
    {
        return new RootNode()
        {{
            Setup = visitSetup(ctx.setup());
            Functions = new ArrayList<FunctionsNode>(visitFunctionsList(ctx.function()));
            LineNumber = getLineNumber(ctx);
        }};
    }

    @Override
    public SetupNode visitSetup(final ArduEasyParser.SetupContext ctx)
    {
        return new SetupNode()
        {{
            Childs = new ArrayList<DefinitionNode>(visitSetupDefs(ctx.definition()));
            LineNumber = getLineNumber(ctx);
        }};
    }

    private List<FunctionsNode> visitFunctionsList(List<ArduEasyParser.FunctionContext> ctx)
    {
        List<FunctionsNode> nodeList = new ArrayList<FunctionsNode>();

        for (ArduEasyParser.FunctionContext func: ctx)
        {
            if (func != null)
            {
                if (func.WHEN() != null)
                {
                    nodeList.add(visitFucntionWhen(func));
                }
                else if (func.FUNCTION() != null)
                {
                    nodeList.add(visitFunctionFunction(func));
                }
            }
        }

        return nodeList;
    }

    private WhenNode visitFucntionWhen(final ArduEasyParser.FunctionContext ctx)
    {
        return new WhenNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Body = visitStatementList(ctx.statement());
            LineNumber = getLineNumber(ctx);
        }};
    }

    private List<StatementsNode> visitStatementsList(List<ArduEasyParser.StatementContext> ctx)
    {
        List<StatementsNode> nodeList = new ArrayList<StatementsNode>();

        for (ArduEasyParser.StatementContext stmt: ctx)
        {
            if (stmt != null)
            {
                nodeList.add(visitStatement(stmt));
            }
        }

        return nodeList;
    }

    private FunctionsNode visitFunctionFunction(final ArduEasyParser.FunctionContext ctx)
    {
        if (ctx.returnType() != null)
        {
            return new FunctionNode()
            {{
                ReturnType = ctx.returnType().getText();
                Identifier = visitIdentifier(ctx.identifier());
                Parameters = visitParameterList(ctx.parameters());
                Body = visitStatementList(ctx.statement());
                Return = visitReturn(ctx.logicalExpressions());
                LineNumber = getLineNumber(ctx);
            }};
        }
        else if (ctx.VOIDDEC() != null)
        {
            return new FunctionNode()
            {{
                ReturnType = ctx.VOIDDEC().getText();
                Identifier = visitIdentifier(ctx.identifier());
                Parameters = visitParameterList(ctx.parameters());
                Body = visitStatementList(ctx.statement());
                LineNumber = getLineNumber(ctx);
            }};
        }
        System.out.println("visitFunctionFunction");
        return null;
    }

    private ReturnNode visitReturn(final ArduEasyParser.LogicalExpressionsContext ctx) {

        return new ReturnNode()
        {{
            Value = visitLogicalExpressions(ctx);
            LineNumber = getLineNumber(ctx);
        }};
    }

    private ArrayList<ParameterNode> visitParameterList(ArduEasyParser.ParametersContext ctx)
    {
        ArrayList<ParameterNode> nodeList = new ArrayList<ParameterNode>();

        if (ctx.parameter() == null) return nodeList;

        nodeList.add(visitParameter(ctx.parameter()));

        if (ctx.parameters() == null) return nodeList;

        nodeList.addAll(visitParameterList(ctx.parameters()));

        return nodeList;
    }

    @Override
    public ParameterNode visitParameter(final ArduEasyParser.ParameterContext ctx) {
        return new ParameterNode()
        {{
            Type = ctx.typeSpecifier().getText();
            Identifier = visitIdentifier(ctx.identifier());
            LineNumber = getLineNumber(ctx);
        }};
    }


    private List<DefinitionNode> visitSetupDefs(List<ArduEasyParser.DefinitionContext> context)
    {
        List<DefinitionNode> nodeList = new ArrayList<DefinitionNode>();

        for (ArduEasyParser.DefinitionContext def: context)
        {
            if (def != null)
            {
                nodeList.add(visitDefinition(def));
            }
        }

        return nodeList;
    }

    @Override
    public DefinitionNode visitDefinition(ArduEasyParser.DefinitionContext ctx)
    {
        if (ctx.pindeclaration() != null)
        {
            return visitPindeclaration(ctx.pindeclaration());
        }
        else if (ctx.declaration() != null)
        {
            return visitDeclaration(ctx.declaration());
        }
        else if (ctx.assignment() != null)
        {
            return visitAssignment(ctx.assignment());
        }
        else if (ctx.roomdeclaration() != null)
        {
            return visitRoomdeclaration(ctx.roomdeclaration());
        }
        System.out.println("visitDefinition");
        return null;
    }

    @Override
    public PinDeclarationNode visitPindeclaration(final ArduEasyParser.PindeclarationContext ctx)
    {
        return new PinDeclarationNode()
        {{
            Identifier = visitIdentifier(ctx.identifier());
            Pin = visitPin(ctx.pin());
            IoStatus = visitIoStatus(ctx.ioStatus());
            LineNumber = getLineNumber(ctx);
        }};
    }

    @Override
    public DeclarationNode visitDeclaration(final ArduEasyParser.DeclarationContext ctx)
    {
        return new DeclarationNode()
        {{
            Type = ctx.typeSpecifier().getText();
            Identifier = visitIdentifier(ctx.identifier());
            LineNumber = getLineNumber(ctx);

            if (ctx.logicalExpressions() != null)
            {
                Value = visitLogicalExpressions(ctx.logicalExpressions());
            }
            else if (ctx.methodCall() != null)
            {
                Value = visitMethodCall(ctx.methodCall());
            }

        }};

    }

    @Override
    public ExpressionNode visitMethodCall(final ArduEasyParser.MethodCallContext ctx) {
        return new MethodCallNode()
        {{
            identifier = visitIdentifier(ctx.identifier());
            expressions = visitExpressionList(ctx.expression());
            LineNumber = getLineNumber(ctx);
        }};
    }

    @Override
    public AssignmentNode visitAssignment(final ArduEasyParser.AssignmentContext ctx)
    {
        return new AssignmentNode()
        {{
            if (ctx.identifier() != null)
            {
                Identifier = visitIdentifier(ctx.identifier());
            }
            else if (ctx.houseaccess() != null)
            {
                Identifier = visitHouseaccess(ctx.houseaccess());
            }
            Value = visitLogicalExpressions(ctx.logicalExpressions());
            LineNumber = getLineNumber(ctx);
        }};
    }

    @Override
    public RoomDeclaration visitRoomdeclaration(final ArduEasyParser.RoomdeclarationContext ctx)
    {
        return new RoomDeclaration()
        {{
            Identifier = visitIdentifier(ctx.identifier());
            body = visitRoomBlockList(ctx.roomblock());
            LineNumber = getLineNumber(ctx);
        }};
    }

    private List<RoomBlockNode> visitRoomBlockList(ArduEasyParser.RoomblockContext context)
    {
        List<RoomBlockNode> nodeList = new ArrayList<RoomBlockNode>();

        for (ArduEasyParser.PindeclarationContext ctx: context.pindeclaration())
        {
            if (ctx != null)
            {
                nodeList.add(visitPindeclaration(ctx));
            }
        }

        for (ArduEasyParser.ArraydeclarationContext ctx: context.arraydeclaration())
        {
            if (ctx != null)
            {
                nodeList.add(visitArraydeclaration(ctx));
            }
        }

        return nodeList;
    }

    @Override
    public ArrayDeclarationNode visitArraydeclaration(final ArduEasyParser.ArraydeclarationContext ctx)
    {
        return new ArrayDeclarationNode()
        {{
            Identifier = visitIdentifier(ctx.identifier().remove(0));
            Values = visitIdentifierList(ctx.identifier());
            LineNumber = getLineNumber(ctx);
        }};
    }

    private List<IdentifierNode> visitIdentifierList(List<ArduEasyParser.IdentifierContext> ctx)
    {
        List<IdentifierNode> nodeList = new ArrayList<IdentifierNode>();

        for (ArduEasyParser.IdentifierContext id : ctx)
        {
            if (id != null) nodeList.add(visitIdentifier(id));
        }

        return nodeList;
    }

    @Override
    public IdentifierNode visitIdentifier(final ArduEasyParser.IdentifierContext ctx)
    {
        return new IdentifierNode()
        {{
            Value = ctx.IDENTIFIER().getText();
            LineNumber = getLineNumber(ctx);
        }};
    }

    @Override
    public HouseNode visitHouseaccess(final ArduEasyParser.HouseaccessContext ctx)
    {
        return new HouseNode()
        {{
            Identifier = SplitDotNotation(ctx);
            LineNumber = getLineNumber(ctx);
        }};
    }

    private IdentifierNode SplitDotNotation(final ArduEasyParser.HouseaccessContext ctx)
    {
        return new IdentifierNode()
        {{
            Value = ctx.DOT_NOTATION().getText();
            LineNumber = getLineNumber(ctx);
        }};
    }

    @Override
    public PinNode visitPin(final ArduEasyParser.PinContext ctx)
    {
        if (ctx.A() == null) return new DigitalPinNode()
        {{
            Value = Integer.parseInt(ctx.INT().toString());
            LineNumber = getLineNumber(ctx);
        }};

        return new AnalogPinNode()
        {{
            Value = Integer.parseInt(ctx.INT().toString());
            LineNumber = getLineNumber(ctx);
        }};
    }

    @Override
    public IoStatusNode visitIoStatus(final ArduEasyParser.IoStatusContext ctx)
    {
        return new IoStatusNode(){{ Value = ctx.getText(); LineNumber = getLineNumber(ctx);}};
    }

    @Override
    public StatementsNode visitStatement(final ArduEasyParser.StatementContext ctx) {

        if (ctx.if_r() != null)
        {
            return visitIf_r(ctx.if_r());
        }
        else if (ctx.for_r() != null)
        {
            return visitFor_r(ctx.for_r());
        }
        else if (ctx.switch_r() != null)
        {
            return visitSwitch_r(ctx.switch_r());
        }
        else if (ctx.perform_r() != null)
        {
            return visitPerform_r(ctx.perform_r());
        }
        else if (ctx.while_r() != null)
        {
            return visitWhile_r(ctx.while_r());
        }
        else if (ctx.declaration() != null)
        {
            return visitDeclaration(ctx.declaration());
        }
        else if (ctx.assignment() != null)
        {
            return visitAssignment(ctx.assignment());
        }
        System.out.println("visitStatement");
        return null;
    }

    @Override
    public SwitchNode visitSwitch_r(final ArduEasyParser.Switch_rContext ctx) {
        return new SwitchNode()
        {{
            expression = visitExpression(ctx.expression()); //TODO not totaly sure here
            Body = visitCaseList(ctx.cases());
            LineNumber = getLineNumber(ctx);
            if (ctx.cases().default_case() != null) // for some reaon statements is not null so i check for size
            {
                defaultCase = visitDefaultCase(ctx.cases().default_case());
            }
            else
            {
                defaultCase = null;
            }
        }};
    }

    private CaseNode visitDefaultCase(final ArduEasyParser.Default_caseContext ctx)
    {
        return new CaseNode()
        {{
            Body = visitStatementList(ctx.statement());
            LineNumber = getLineNumber(ctx);
        }};
    }

    private ArrayList<CaseNode> visitCaseList(final ArduEasyParser.CasesContext ctx) {
        ArrayList<CaseNode> nodeList = new ArrayList<CaseNode>();

        for (ArduEasyParser.Case_rContext cases: ctx.case_r())
        {
            if (cases != null)
            {
                nodeList.add(visitCase_r(cases));
            }
        }

        return nodeList;
    }

    @Override
    public CaseNode visitCase_r(final ArduEasyParser.Case_rContext ctx) {
        return new CaseNode()
        {{
            Value = determinateValue(ctx.value());
            Body = visitStatementList(ctx.statement());
            LineNumber = getLineNumber(ctx);
        }};
    }

    @Override
    public WhileNode visitWhile_r(final ArduEasyParser.While_rContext ctx) {
        return new WhileNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Body = visitStatementList(ctx.statement());
            LineNumber = getLineNumber(ctx);
        }};
    }

    @Override
    public PerformNode visitPerform_r(final ArduEasyParser.Perform_rContext ctx) {
        if (ctx.expression() != null)
        {
            return visitPerformTimes(ctx); // if the grammar contains a expression we know its perform times
        }
        else if (ctx.logicalExpressions() != null)
        {
            return visitPerformUntil(ctx); // if the grammar contains a logical expression we know its perform until
        }
        System.out.println("visitPerform");
        return null;
    }

    private PerformNode visitPerformTimes(final ArduEasyParser.Perform_rContext ctx)
    {
        return new PerformTimes()
        {{
            value = visitExpression(ctx.expression());
            Body = visitStatementList(ctx.statement());
            LineNumber = getLineNumber(ctx);
        }};
    }

    private PerformNode visitPerformUntil(final ArduEasyParser.Perform_rContext ctx)
    {
        return new PerformUntil()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions()); //TODO skal ikke være logical
            Body = visitStatementList(ctx.statement());
            LineNumber = getLineNumber(ctx);
        }};
    }

    @Override
    public ForNode visitFor_r(final ArduEasyParser.For_rContext ctx) {
        if (ctx.declaration() != null)
        {
            return new ForNode()
            {{
                Var = visitDeclaration(ctx.declaration());
                Predicate = visitLogicalExpressions(ctx.logicalExpressions());
                Increment = visitAssignment(ctx.assignment(0)); // takes the second assignment in the for loop
                body = visitStatementList(ctx.statement());
                LineNumber = getLineNumber(ctx);
            }};
        }
        else
        {
            return new ForNode()
            {{
                Var = visitAssignment(ctx.assignment(0));
                Predicate = visitLogicalExpressions(ctx.logicalExpressions());
                Increment = visitAssignment(ctx.assignment(1)); // takes the second assignment in the for loop
                body = visitStatementList(ctx.statement());
                LineNumber = getLineNumber(ctx);
            }};
        }
    }

    @Override
    public IfNode visitIf_r(final ArduEasyParser.If_rContext ctx) {
        return new IfNode()
        {{
            Body = visitStatementList(ctx.statement());
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            LineNumber = getLineNumber(ctx);

            if (ctx.ifElse() != null)
            {
                Alternative = visitIfElse(ctx.ifElse());
            }
            else if (ctx.else_r() != null)
            {
                Alternative = visitElse_r(ctx.else_r());
            }
        }};
    }

    @Override
    public ElseNode visitElse_r(final ArduEasyParser.Else_rContext ctx) {
        return new ElseNode()
        {{
            Body = visitStatementList(ctx.statement());
            LineNumber = getLineNumber(ctx);
        }};
    }

    @Override
    public IfOrElseNode visitIfElse(final ArduEasyParser.IfElseContext ctx) {
        return new ElseIfNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Body = visitStatementList(ctx.statement());
            LineNumber = getLineNumber(ctx);

            if (ctx.ifElse() != null)
            {
                Alternative = visitIfElse(ctx.ifElse());
            }
            else if (ctx.else_r() != null)
            {
                Alternative = visitElse_r(ctx.else_r());
            }
        }};
    }

    private ArrayList<StatementsNode> visitStatementList(List<ArduEasyParser.StatementContext> context)
    {
        ArrayList<StatementsNode> nodeList = new ArrayList<StatementsNode>();

        for (ArduEasyParser.StatementContext statement: context)
        {
            if (statement != null)
            {
                nodeList.add(visitStatement(statement));
            }
        }

        return nodeList;
    }

    private ArrayList<ExpressionNode> visitExpressionList(List<ArduEasyParser.ExpressionContext> context)
    {
        ArrayList<ExpressionNode> nodeList = new ArrayList<ExpressionNode>();

        for (ArduEasyParser.ExpressionContext expression: context)
        {
            if (expression != null)
            {
                nodeList.add(visitExpression(expression));
            }
        }

        return nodeList;
    }

    @Override
    public ExpressionNode visitLogicalExpressions(final ArduEasyParser.LogicalExpressionsContext ctx)
    {
        if (ctx.logicalOperator() != null)
        {
            if (ctx.logicalOperator().ANDOPERATOR() != null)
            {
                return new LogicalAndNode()
                {{
                    Left = visitLogicalExpressions(ctx.logicalExpressions(0));
                    Right = visitLogicalExpressions(ctx.logicalExpressions(1));
                    LineNumber = getLineNumber(ctx);
                }};
            }
            else if (ctx.logicalOperator().OROPERATOR() != null)
            {
                return new LogicalOrNode()
                {{
                    Left = visitLogicalExpressions(ctx.logicalExpressions(0));
                    Right = visitLogicalExpressions(ctx.logicalExpressions(1));
                    LineNumber = getLineNumber(ctx);
                }};
            }
        }

        return visitLogicalExpression(ctx.logicalExpression());
    }

    @Override
    public ExpressionNode visitLogicalExpression(final ArduEasyParser.LogicalExpressionContext ctx)
    {
        if (ctx.comparisonOperator() != null)
        {
            if (ctx.comparisonOperator().EQUALSOPERATOR() != null)
            {
                return new EqualsNode()
                {{
                    Left = visitAddSubExpression(ctx.addSubExpression(0));
                    Right = visitAddSubExpression(ctx.addSubExpression(1));
                    LineNumber = getLineNumber(ctx);
                }};
            }
            else if (ctx.comparisonOperator().BELOWOPERATOR() != null)
            {
                return new LessThanNode()
                {{
                    Left = visitAddSubExpression(ctx.addSubExpression(0));
                    Right = visitAddSubExpression(ctx.addSubExpression(1));
                    LineNumber = getLineNumber(ctx);
                }};
            }
            else if (ctx.comparisonOperator().ABOVEOPERATOR() != null)
            {
                return new GreaterThanNode()
                {{
                    Left = visitAddSubExpression(ctx.addSubExpression(0));
                    Right = visitAddSubExpression(ctx.addSubExpression(1));
                    LineNumber = getLineNumber(ctx);
                }};
            }
            else if (ctx.comparisonOperator().EQUALSORBELOWOPERATOR() != null)
            {
                return new LessOrEqualNode()
                {{
                    Left = visitAddSubExpression(ctx.addSubExpression(0));
                    Right = visitAddSubExpression(ctx.addSubExpression(1));
                    LineNumber = getLineNumber(ctx);
                }};
            }
            else if (ctx.comparisonOperator().EQUALSORABOVEOPERATOR() != null)
            {
                return new GreaterOrEqualNode()
                {{
                    Left = visitAddSubExpression(ctx.addSubExpression(0));
                    Right = visitAddSubExpression(ctx.addSubExpression(1));
                    LineNumber = getLineNumber(ctx);
                }};
            }
            else if (ctx.comparisonOperator().ISNOTOPERATOR() != null)
            {
                return new NotEqualsNode()
                {{
                    Left = visitAddSubExpression(ctx.addSubExpression(0));
                    Right = visitAddSubExpression(ctx.addSubExpression(1));
                    LineNumber = getLineNumber(ctx);
                }};
            }
        }
        else if (ctx.addSubExpression(0) != null)
        {
            return visitAddSubExpression(ctx.addSubExpression(0));
        }
        return null;
    }

    @Override
    public ExpressionNode visitExpression(final ArduEasyParser.ExpressionContext ctx) {
        if (ctx.SUBTRACTIVEOPERATOR() != null)
        {
            return new NegateNode(){{ child = visitIdentifier(ctx.identifier()); LineNumber = getLineNumber(ctx);}};
        }
        else if (ctx.identifier() != null)
        {
            return visitIdentifier(ctx.identifier());
        }
        else if (ctx.houseaccess() != null)
        {
            return visitHouseaccess(ctx.houseaccess());
        }
        else if (ctx.value() != null)
        {
            return determinateValue(ctx.value());
        }
        else if (ctx.NEGATEOPERATOR() != null)
        {
            return new NegateNode()
            {{
                LineNumber = getLineNumber(ctx);
                if (ctx.houseaccess() != null)
                {
                    child = visitHouseaccess(ctx.houseaccess());
                }
                else
                {
                    child = visitIdentifier(ctx.identifier());
                }
            }};
        }
        else if (ctx.parenExpression() != null)
        {
            return visitParenExpression(ctx.parenExpression());
        }

        System.out.println("visitExpression | " + ctx.getText() + " " + ctx.start);
        System.out.println(ctx.SUBTRACTIVEOPERATOR() + " | " + ctx.identifier() + " | " + ctx.value() + "\n");
        return null;
    }

    private ValueNode determinateValue(final ArduEasyParser.ValueContext ctx)
    {
        if (ctx.INT() != null)
        {
            if (ctx.SUBTRACTIVEOPERATOR() != null)
            {
                return new IntNode(){{ Value = -Integer.parseInt(ctx.INT().getText()); LineNumber = getLineNumber(ctx);}};
            }

            return new IntNode(){{ Value = Integer.parseInt(ctx.INT().getText()); LineNumber = getLineNumber(ctx);}};

        }
        else if (ctx.FLOAT() != null)
        {
            if (ctx.SUBTRACTIVEOPERATOR() != null)
            {
                return new FloatNode(){{ Value = -Float.parseFloat(ctx.FLOAT().getText()); LineNumber = getLineNumber(ctx);}};
            }

            return new FloatNode(){{ Value = Float.parseFloat(ctx.FLOAT().getText()); LineNumber = getLineNumber(ctx);}};
        }
        else if (ctx.PERCENTAGE() != null)
        {
            return new PercentNode(){{ Value = Integer.parseInt(ctx.PERCENTAGE().getText().replaceAll("%","")); LineNumber = getLineNumber(ctx);}};
        }
        else if (ctx.STRING() != null)
        {
            return new StringNode(){{ Value = ctx.STRING().getText(); LineNumber = getLineNumber(ctx);}};
        }
        else if (ctx.BOOL() != null)
        {
            if (ctx.NEGATEOPERATOR() != null)
            {
                return new NegateNode()
                {{
                    LineNumber = getLineNumber(ctx);
                    child = new BoolNode()
                    {{
                        Value = Boolean.valueOf(ctx.BOOL().getText());
                        LineNumber = getLineNumber(ctx);
                    }};
                }};
            }

            return new BoolNode(){{ Value = Boolean.valueOf(ctx.BOOL().getText()); LineNumber = getLineNumber(ctx);}};
        }
        else if (ctx.TIME() != null)
        {
            return new TimeNode(){{ Value = ctx.TIME().getText(); LineNumber = getLineNumber(ctx);}};
        }
        else if (ctx.DAY() != null)
        {
            return new DayNode(){{ Value = ctx.DAY().getText(); LineNumber = getLineNumber(ctx);}};
        }
        else if (ctx.MONTH() != null)
        {
            return new MonthNode(){{ Value = ctx.MONTH().getText(); LineNumber = getLineNumber(ctx);}};
        }
        System.out.println("DeterminateValue");
        return null;
    }

    @Override
    public ExpressionNode visitAddSubExpression(final ArduEasyParser.AddSubExpressionContext ctx)
    {
        if (ctx.ADDITIVEOPERATOR() != null)
        {
            return new AdditiveNode()
            {{
                LineNumber = getLineNumber(ctx);
                LeftChild = visitAddSubExpression(ctx.addSubExpression());
                RightChild = visitMultiDivExpression(ctx.multiDivExpression());
            }};
        }
        else if (ctx.SUBTRACTIVEOPERATOR() != null)
        {
            return new SubtractiveNode()
            {{
                LineNumber = getLineNumber(ctx);
                LeftChild = visitAddSubExpression(ctx.addSubExpression());
                RightChild = visitMultiDivExpression(ctx.multiDivExpression());
            }};
        }
        else
        {
            return visitMultiDivExpression(ctx.multiDivExpression());
        }
    }

    @Override
    public ExpressionNode visitMultiDivExpression(final ArduEasyParser.MultiDivExpressionContext ctx)
    {
        if (ctx.MULTIPLICATIVEOPERATOR() != null)
        {
            return new MultiplicationNode()
            {{
                LineNumber = getLineNumber(ctx);
                LeftChild = visitExpression(ctx.expression());
                RightChild = visitMultiDivExpression(ctx.multiDivExpression());
            }};
        }
        else if (ctx.DIVISIONALOPERATOR() != null)
        {
            return new DivisionNode()
            {{
                LineNumber = getLineNumber(ctx);
                LeftChild = visitExpression(ctx.expression());
                RightChild = visitMultiDivExpression(ctx.multiDivExpression());
            }};
        }
        else
        {
            return visitExpression(ctx.expression());
        }
    }

    @Override
    public ExpressionNode visitParenExpression(final ArduEasyParser.ParenExpressionContext ctx)
    {
        return new ParanNode(){{child = visitLogicalExpressions(ctx.logicalExpressions()); LineNumber = getLineNumber(ctx);}};
    }

    private int getLineNumber(ParserRuleContext ctx)
    {
        return ctx.start.getLine();
    }
}
import Nodes.*;
import java.util.ArrayList;
import java.util.List;

public class BuildAst extends ArduEasyBaseVisitor<Node>
{

    @Override
    public Node visitR(final ArduEasyParser.RContext ctx)
    {
        return new RootNode()
        {{
            Home = visitSetup(ctx.setup());
            Functions = new ArrayList<FunctionsNode>(visitFunctionsList(ctx.function()));
        }};
    }

    private List<FunctionsNode> visitFunctionsList(List<ArduEasyParser.FunctionContext> ctx)
    {
        System.out.println(ctx.get(0).WHEN());

        return new ArrayList<FunctionsNode>();
    }

    private WhenNode visitFucntionWhen(final ArduEasyParser.FunctionContext ctx)
    {
        return new WhenNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Body = visitStatementList(ctx.statement());
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

    @Override
    public SetupNode visitSetup(final ArduEasyParser.SetupContext ctx)
    {
        return new SetupNode()
        {{
            Childs = new ArrayList<DefinitionNode>(visitSetupDefs(ctx.definition()));
        }};
    }

    private FunctionsNode visitFunctionFunction(final ArduEasyParser.FunctionContext ctx)
    {
        if (ctx.returnType() != null)
        {
            return new FunctionNode()
            {{
                ReturnType = ctx.returnType().toString();
                Identifier = visitIdentifier(ctx.identifier());
                Parameters = visitParameterList(ctx.parameters());
                Body = visitStatementList(ctx.statement());
                Return = visitReturn(ctx.logicalExpressions());
            }};
        }
        else if (ctx.VOIDDEC() != null)
        {
            return new FunctionNode()
            {{
                Identifier = visitIdentifier(ctx.identifier());
                Parameters = visitParameterList(ctx.parameters());
                Body = visitStatementList(ctx.statement());
            }};
        }

        return null;
    }

    private ReturnNode visitReturn(final ArduEasyParser.LogicalExpressionsContext ctx) {

        return new ReturnNode()
        {{
            Value = visitLogicalExpressions(ctx);
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
            Type = ctx.typeSpecifier().toString();
            Identifier = visitIdentifier(ctx.identifier());
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
        }};
    }

    @Override
    public DeclarationNode visitDeclaration(final ArduEasyParser.DeclarationContext ctx)
    {
        return new DeclarationNode()
        {{
            Type = ctx.typeSpecifier().getText();
            Identifier = visitIdentifier(ctx.identifier());
            Value = visitLogicalExpressions(ctx.logicalExpressions());
        }};
    }



    @Override
    public AssignmentNode visitAssignment(final ArduEasyParser.AssignmentContext ctx)
    {
        return new AssignmentNode()
        {{
           Identifier = visitIdentifier(ctx.identifier());
           Value = visitLogicalExpressions(ctx.logicalExpressions());
        }};
    }

    @Override
    public RoomDeclaration visitRoomdeclaration(final ArduEasyParser.RoomdeclarationContext ctx)
    {
        return new RoomDeclaration()
        {{
            Identifier = visitIdentifier(ctx.identifier());
            body = visitRoomBlockList(ctx.roomblock());
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
            Identifier = visitIdentifier(ctx.identifier());
            Values = visitIdentifierList(ctx.identifierloop());
        }};
    }

    private List<IdentifierNode> visitIdentifierList(ArduEasyParser.IdentifierloopContext ctx)
    {
        List<IdentifierNode> nodeList = new ArrayList<IdentifierNode>();

        if (ctx.identifier() == null) return nodeList;

        nodeList.add(visitIdentifier(ctx.identifier()));

        if (ctx.identifierloop() == null) return nodeList;

        nodeList.addAll(visitIdentifierList(ctx.identifierloop()));

        return nodeList;
    }

    @Override
    public IdentifierNode visitIdentifier(final ArduEasyParser.IdentifierContext ctx)
    {
        return new IdentifierNode()
        {{
            Value = ctx.IDENTIFIER().toString();
        }};
    }

    @Override
    public PinNode visitPin(final ArduEasyParser.PinContext ctx)
    {
        if (ctx.A() == null) return new DigitalPinNode(){{ Value = Integer.parseInt(ctx.INT().toString()); }};
        return new AnalogPinNode(){{ Value = Integer.parseInt(ctx.INT().toString()); }};
    }

    @Override
    public IoStatusNode visitIoStatus(final ArduEasyParser.IoStatusContext ctx)
    {
        return new IoStatusNode(){{ Value = ctx.toString(); }};
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

        return null;
    }

    @Override
    public SwitchNode visitSwitch_r(final ArduEasyParser.Switch_rContext ctx) {
        return new SwitchNode()
        {{
            expression = visitExpression(ctx.expression());
            Body = visitCaseList(ctx.cases());
            defaultCase = visitDefaultCase(ctx.cases());
        }};
    }

    private CaseNode visitDefaultCase(final ArduEasyParser.CasesContext ctx)
    {
        if (ctx.statement() != null) // checks for a default case
        {
            return new CaseNode()
            {{
                Value = ctx.DEFAULT().toString();
                Body = visitStatementList(ctx.statement());
            }};
        }
        return null;
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
            Value = ctx.value().toString();
            Body = visitStatementList(ctx.statement());
        }};
    }


    @Override
    public CaseNode visitCases(final ArduEasyParser.CasesContext ctx) {
        return new CaseNode(); //TODO maybe not nes
    }

    @Override
    public WhileNode visitWhile_r(final ArduEasyParser.While_rContext ctx) {
        return new WhileNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Body = visitStatementList(ctx.statement());
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
        return null;
    }

    private PerformNode visitPerformTimes(final ArduEasyParser.Perform_rContext ctx)
    {
        return new PerformTimes()
        {{
            value = visitExpression(ctx.expression());
            Body = visitStatementList(ctx.statement());
        }};
    }

    private PerformNode visitPerformUntil(final ArduEasyParser.Perform_rContext ctx)
    {
        return new PerformUntil()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Body = visitStatementList(ctx.statement());
        }};
    }

    @Override
    public ExpressionNode visitExpression(ArduEasyParser.ExpressionContext ctx) {
        return new ExpressionNode(); //TODO
    }


    @Override
    public ForNode visitFor_r(final ArduEasyParser.For_rContext ctx) {
        return new ForNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Increment = visitAssignment(ctx.assignment(1)); // takes the second assignment in the for loop
            body = visitStatementList(ctx.statement());

        }};
    }

    @Override
    public IfNode visitIf_r(final ArduEasyParser.If_rContext ctx) {
        return new IfNode()
        {{
            Body = visitStatementList(ctx.statement());
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());

            if (ctx.ifElse() != null)
            {
                Alternative = visitIfElse(ctx.ifElse());
            }
            else if (ctx.else_r() != null)
            {
                Else = visitElse_r(ctx.else_r());
            }
        }};
    }

    @Override
    public ElseNode visitElse_r(final ArduEasyParser.Else_rContext ctx) {
        return new ElseNode()
        {{
            Body = visitStatementList(ctx.statement());
        }};
    }

    @Override
    public IfOrElseNode visitIfElse(final ArduEasyParser.IfElseContext ctx) {
        return new IfOrElseNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Body = visitStatementList(ctx.statement());

            if (ctx.ifElse() != null)
            {
                Alternative = visitIfElse(ctx.ifElse());
            }
            else if (ctx.else_r() != null)
            {
                Else = visitElse_r(ctx.else_r());
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

    @Override
    public LogicalExprNode visitLogicalExpressions(ArduEasyParser.LogicalExpressionsContext ctx) {
        return null;
    }
}
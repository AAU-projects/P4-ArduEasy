import Nodes.*;
import jdk.nashorn.internal.ir.Assignment;

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
        }};
    }

    @Override
    public SetupNode visitSetup(final ArduEasyParser.SetupContext ctx)
    {
        return new SetupNode()
        {{
            Childs = new ArrayList<DefinitionNode>(visitSetupDefs(ctx.definition()));
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
    public DeclarationNode visitDeclaration(ArduEasyParser.DeclarationContext ctx)
    {
        return null;
    }

    @Override
    public AssignmentNode visitAssignment(ArduEasyParser.AssignmentContext ctx)
    {
        return null;
    }

    @Override
    public RoomDeclaration visitRoomdeclaration(ArduEasyParser.RoomdeclarationContext ctx)
    {
        return null;
    }

    @Override
    public IdentifierNode visitIdentifier(ArduEasyParser.IdentifierContext ctx)
    {
        return null;
    }

    @Override
    public PinNode visitPin(ArduEasyParser.PinContext ctx)
    {
        return null;
    }

    @Override
    public IoStatusNode visitIoStatus(ArduEasyParser.IoStatusContext ctx)
    {
        return null;
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
    public WhileNode visitWhile_r(final ArduEasyParser.While_rContext ctx) {
        return new WhileNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Body = new ArrayList<StatementsNode>(visitStatementList(ctx.statement()));
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
    }

    private PerformNode visitPerformTimes(final ArduEasyParser.Perform_rContext ctx)
    {
        return new PerformTimes()
        {{
            value = visitExpression(ctx.expression());
            Body = new ArrayList<StatementsNode>(visitStatementList(ctx.statement()));
        }};
    }

    private PerformNode visitPerformUntil(final ArduEasyParser.Perform_rContext ctx)
    {
        return new PerformUntil()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Body = new ArrayList<StatementsNode>(visitStatementList(ctx.statement()));
        }};
    }

    @Override
    public ExpressionNode visitExpression(ArduEasyParser.ExpressionContext ctx) {
        return new ExpressionNode(); //TODO
    }

    @Override
    public SwitchNode visitSwitch_r(final ArduEasyParser.Switch_rContext ctx) {
        return new SwitchNode()
        {{
            expression = new ExpressionNode();
             //TODO
        }};
    }

    @Override
    public ForNode visitFor_r(final ArduEasyParser.For_rContext ctx) {
        return new ForNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Increment = visitAssignment(ctx.assignment(1)); // takes the second assignment in the for loop
            body = new ArrayList<StatementsNode>(visitStatementList(ctx.statement()));

        }};
    }

    @Override
    public IfNode visitIf_r(final ArduEasyParser.If_rContext ctx) {
        return new IfNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Body = new ArrayList<StatementsNode>(visitStatementList(ctx.statement()));

            if (ctx.ifElse() != null)
            {
                Alternative = visitIfElse(ctx.ifElse());
            }
        }};
    }

    @Override
    public IfOrElseNode visitIfElse(ArduEasyParser.IfElseContext ctx) {
        return new IfOrElseNode(); //TODO
    }

    private List<StatementsNode> visitStatementList(List<ArduEasyParser.StatementContext> context)
    {
        List<StatementsNode> nodeList = new ArrayList<StatementsNode>();

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
        return new LogicalExprNode(); //TODO
    }
}